package com.javarush.test.level30.lesson15.big01;

/**
 * Created by stas on 8/31/16.
 */
public class Server
{
  private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();
	// String==clent name, Connection==connection with client
	
	public static void sendBroadcastMessage(Message message)
	{
		try
		{
			for (Map.Entry<String, Connection> pair : connectionMap.entrySet()) 
			{
				pair.getValue().send(message);
			}
			//sending message for each connection
		}
		catch (IOException ie)
		{
			ConsoleHelper.writeMessage("Can't send the message");
		}
	
	}
	
	private static class Handler extends Thread
	{
		private Socket socket;
		
		
		Handler(Socket socket)
		{
			this.socket = socket;
		}
		
		@Override
		public void run() 
		{
			//some logic will be here
		}
	}
	
	
	public static void main(String...args) throws IOException
	{
		int serverPort = ConsoleHelper.readInt();
		try (ServerSocket serverSocket = new ServerSocket(serverPort))
		{
			ConsoleHelper.writeMessage("Server is run");
			
			while(true)
			{
				new Handler(serverSocket.accept()).start();
			}
		}
		catch (Exception e) 
		{
			ConsoleHelper.writeMessage("Some socket occured");
		}
		
		}				
}
