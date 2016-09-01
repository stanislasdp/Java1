package level30_chat.client;

import java.io.IOException;

import level30_chat.Connection;
import level30_chat.ConsoleHelper;
import level30_chat.Message;
import level30_chat.MessageType;

public class Client//12.2 
{
	private volatile boolean clientConnected = false;//12.4
	protected Connection connection;
	
	
	protected String getServerAddress()//13.1
	{
		ConsoleHelper.writeMessage("Enter server address");
		return ConsoleHelper.readString();
	}
	
	protected int getServerPort()//13.2
	{
		ConsoleHelper.writeMessage("Enter server port");
		return ConsoleHelper.readInt();
	}
	
	protected String getUserName()//13.3
	{
		ConsoleHelper.writeMessage("Enter user name");
		return ConsoleHelper.readString();
	}
	
	
	protected boolean shouldSentTextFromConsole()//13.4
	{
		return true;
	}
	
	protected SocketThread getSocketThread()
	{
		return new SocketThread();//13.5
	}
	
	protected void sendTextMessage(String text)//13.6
	{
		try
		{
			Message newMessage = new Message(MessageType.TEXT, text);
			connection.send(newMessage);
		}
		catch (IOException ie)
		{
			ConsoleHelper.writeMessage(String.format("Impossible to send %s message", text));
			clientConnected = false;
		}
	}
	
	
	
	public class SocketThread extends Thread//12.3
	{
		
		
	}
}
