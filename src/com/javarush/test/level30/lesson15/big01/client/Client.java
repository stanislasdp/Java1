package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.Connection;
import com.javarush.test.level30.lesson15.big01.ConsoleHelper;
import com.javarush.test.level30.lesson15.big01.Message;
import com.javarush.test.level30.lesson15.big01.MessageType;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by stas on 9/1/16.
 */
public class Client
{
    protected Connection connection;//12.4
    private volatile boolean clientConnected = false;//12.5

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


    public void run()
    {
        SocketThread socketThread = new SocketThread();//14.1.1
        socketThread.setDaemon(true);//14.1.2
        socketThread.start();//14.1.3
        // when main thread finishes, additional SocketThread thread finishes as well.

        synchronized(this)
        {
            try
            {
                this.wait();//14.1.4
            }
            catch (InterruptedException ie)
            {
                ConsoleHelper.writeMessage("Error occured in client");
                return;
            }
        }

        if (clientConnected)//14.1.5
        {
            ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");
        }
        else
        {
            ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
        }

        String readString=null;
        while (clientConnected)
        {
            readString = ConsoleHelper.readString();
            if (readString.equalsIgnoreCase("exit"))//14.1.6
            {
                break;
            }
            if (shouldSentTextFromConsole())
            {
                sendTextMessage(readString);//14.1.7
            }
        }
    }

    public static void main (String...args)
    {
        Client client = new Client();//14.2
        client.run();
    }

    public class SocketThread extends Thread//12.3
    {
        protected void processIncomingMessage(String message)//15.1
        {
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName)//15.2
        {
            ConsoleHelper.writeMessage(String.format("User %s joined to chat", userName));
        }

        protected void informAboutDeletingNewUser(String userName)//15.3
        {
            ConsoleHelper.writeMessage(String.format("User %s left", userName));
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected)
        {
            Client.this.clientConnected = clientConnected;//15.4.1
            synchronized (Client.this)
            {
                Client.this.notify();//15.4.2
            }
        }
        protected void clientHandshake() throws IOException,ClassNotFoundException//16.1
        {
            while (true)
            {

                Message message = connection.receive();//16.1.1
                switch (message.getType())
                {
                    case NAME_REQUEST://16.1.2
                        String userName = getUserName();
                        Message userNameMessage = new Message(MessageType.USER_NAME,userName);
                        connection.send(userNameMessage);
                        break;
                    case NAME_ACCEPTED:
                        notifyConnectionStatusChanged(true);//16.1.3
                        return;
                    default:
                        throw new IOException("Unexpected MessageType");//16.1.4
                }
            }
        }

        protected void clientMainLoop() throws IOException,ClassNotFoundException
        {
            while (true)
            {
                Message message = connection.receive();//16.2.1
                switch (message.getType())
                {
                    case TEXT://16.2.3
                        processIncomingMessage(message.getData());
                        break;
                    case USER_ADDED:
                        informAboutAddingNewUser(message.getData());//16.2.3
                        break;
                    case USER_REMOVED:
                        informAboutDeletingNewUser(message.getData());//16.2.5
                        break;
                    default:
                        throw new IOException("Unexpected MessageType");//16.2.6
                }
            }
        }

        @Override
        public void run()
        {
            String serverAddress = getServerAddress();//17.1
            int serverPort = getServerPort();//17.1
            try
            {
                Socket newClientSocket = new Socket(serverAddress,serverPort);//17.2
                connection = new Connection(newClientSocket);//17.3
                clientHandshake();//17.4
                clientMainLoop();//17.5
            }
            catch (IOException ie)
            {
                notifyConnectionStatusChanged(false);//17.6
            }
            catch (ClassNotFoundException ie)
            {
                notifyConnectionStatusChanged(false);//17.6
            }
        }
    }

}
