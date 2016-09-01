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
		
		
		private void sendListOfUsers(Connection connection, String userName) throws IOException//9.1
		{
			for (Map.Entry<String, Connection> pair : connectionMap.entrySet()) //9.2
			{
				
				String clientName = pair.getKey();
				//get client name
				if (!clientName.equals(userName))//9.5
				{
					Message message =  new Message(MessageType.USER_ADDED, clientName);//9.3
					connection.send(message);//9.4
				}
				//send all client names to current client excpet current client name
			}
		}
		
		private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException
		{
			while(true)
			{
				Message receivedMessage = connection.receive();//10.1
				///receive message from client
				if (receivedMessage.getType()== MessageType.TEXT)
				{
					String newMessageText = String.format("%s: %s", userName,receivedMessage);
					Message newMessage = new Message(MessageType.TEXT, newMessageText);//10.2
					sendBroadcastMessage(newMessage);
				}
				else
				{
					ConsoleHelper.writeMessage(String.format("Inappropriate message type %s from client %s",receivedMessage.getType(), userName));//10.2
				}
				
				
			}
		}
		
		private void sendBroadcastMessage(Message message) throws IOException
		{
			for (Map.Entry<String, Connection> pair : connectionMap.entrySet())//10.3 
			{
				pair.getValue().send(message);
			}
			//send received message to all clients
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
			ConsoleHelper.writeMessage("Some socket error occured");
		}
		}									
}
