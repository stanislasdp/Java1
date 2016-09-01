package com.javarush.test.level30.lesson15.big01;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
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
				//send all client names to current client except current client name
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
		
		
		@Override
		public void run() 
		{
			SocketAddress remoteAdress = socket.getRemoteSocketAddress();
			Connection connection = null;
			String newClient = null;
			
			ConsoleHelper.writeMessage(String.format("Connection with remote adress %s has been established", remoteAdress));//11.1
			try
			{
				connection = new Connection(socket);//11.2
				newClient = serverHandshake(connection);//11.3
				sendBroadcastMessage(new Message(MessageType.USER_ADDED, newClient));//11.4
				sendListOfUsers(connection, newClient);//11.5
				serverMainLoop(connection, newClient);//11.6
			}
			catch (IOException ie)
			{
				ConsoleHelper.writeMessage(String.format("Error has been occured while connection with remote adress %s", remoteAdress));//11.8
			}
			catch (ClassNotFoundException ie)
			{
				ConsoleHelper.writeMessage(String.format("Error has been occured while connection with remote adress %s", remoteAdress));//11.8
			}
			connectionMap.remove(newClient);//11.9
			sendBroadcastMessage(new Message(MessageType.USER_REMOVED, newClient));//11.9
			
			ConsoleHelper.writeMessage("Connection with remote server was closed");//11.10
			
		
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
