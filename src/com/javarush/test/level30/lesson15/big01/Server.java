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
	//class Handler implements a protocol with client
	{
		private Socket socket;
		
		Handler(Socket socket)
		{
			this.socket = socket;
		}
		
		private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException
		{
			String receivedName = null;
			while(true)
			{
				connection.send(new Message(MessageType.NAME_REQUEST));
				//request user name from client
				
				Message receivedMessage = connection.receive();
				// get the message from cilent
				
				if (receivedMessage.getType()!=MessageType.USER_NAME)
				{
					continue;
					//check whether received message is user name message type
				}
				
				receivedName = connection.receive().getData();
				//get user name
				if (receivedName == null || receivedName.isEmpty())
				{
					continue;
					//check whether received name is not null or empty
				}
				
				if (connectionMap.containsKey(receivedName))
				{
					continue;
					//check whether map with connections contains received name
				}
				
				connectionMap.put(receivedName, connection);
				//put the user to connection map
				connection.send(new Message(MessageType.NAME_ACCEPTED) );
				break;
				//send message to the client that user name is accepted
			}
			return receivedName;
			
			
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
