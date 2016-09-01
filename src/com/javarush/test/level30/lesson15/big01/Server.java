package com.javarush.test.level30.lesson15.big01;

/**
 * Created by stas on 8/31/16.
 */
public class Server
{
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
				serverSocket.accept();
				new Handler(serverSocket.accept()).start();
			}
		}
		catch (Exception e) 
		{
			ConsoleHelper.writeMessage("Some socket occured");
		}
		
		}		
}
