package level30_chat.client;

public class Client 
{
  private volatile boolean clientConnected = false;
	protected Connection connection;
	
	
	protected String getServerAddress()
	{
		
	}
	
	protected int getServerPort()
	{
		
	}
	
	protected String getUserName()
	{
		
	}
	
	
	protected boolean shouldSentTextFromConsole()
	{
		return true;
	}
	
	protected SocketThread getSocketThread()
	{
		return new SocketThread();//13.5
	}
	
	protected void sendTextMessage(String text)
	{
		Message newMessage = new Message(MessageType.TEXT, text);
		getSocketThread().connection.send(newMessage);
	}
	
	
	
	
	
	public class SocketThread extends Thread//12.3
	{
		
		
	}
}
