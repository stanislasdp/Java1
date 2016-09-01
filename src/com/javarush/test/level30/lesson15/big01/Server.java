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


    private static class Handler extends Thread
    {
        private Socket socket;

        public Handler(Socket socket)
        {
            this.socket = socket;
        }


        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException
        {
            while (true)
            {
                connection.send(new Message(MessageType.NAME_REQUEST));//8.1
                //request user name from client

                Message message = connection.receive();//8.2
                // get the message from cilent

                if (message.getType() == MessageType.USER_NAME)//8.3
                {
                    //String receivedName = connection.receive().getData();
                    if (message.getData() != null && !message.getData().isEmpty())//8.4
                    {
                        if (!connectionMap.containsKey(message.getData()))//8.4
                        {
                            connectionMap.put(message.getData(), connection);//8.5
                            connection.send(new Message(MessageType.NAME_ACCEPTED));//8.6
                            return message.getData();//8.7

                            //check whether map with connections contains received name
                        }
                    }
                }

            }
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException//9.1
        {
            for (Map.Entry<String, Connection> pair : connectionMap.entrySet()) //9.2
            {
                String clientName = pair.getKey();
                //get client name
                if (!clientName.equals(userName))//9.5
                {
                    Message message = new Message(MessageType.USER_ADDED, clientName);//9.3
                    connection.send(message);//9.4
                }
                //send all client names to current client excpet current client name
            }

        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException
        {
            while (true)
            {
                Message receivedMessage = connection.receive();//10.1
                ///receive message from client
                if (receivedMessage.getType() == MessageType.TEXT)
                {
                    String newMessageText = String.format("%s: %s", userName, receivedMessage.getData());
                    Message newMessage = new Message(MessageType.TEXT, newMessageText);//10.2
                    sendBroadcastMessage(newMessage);
                } else
                {
                    ConsoleHelper.writeMessage(String.format("Inappropriate message type %s from client %s", receivedMessage.getType(), userName));//10.2
                }
            }
        }

        @Override
        public void run()
        {;
            String newClient = null;

            ConsoleHelper.writeMessage(String.format("Connection with remote adress %s has been established", socket.getRemoteSocketAddress()));//11.1
            try ( Connection connection = new Connection(socket))
            {
                ;//11.2
                newClient = serverHandshake(connection);//11.3
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, newClient));//11.4
                sendListOfUsers(connection, newClient);//11.5
                serverMainLoop(connection, newClient);//11.6
            }
            catch (IOException ie)
            {
                ConsoleHelper.writeMessage(String.format("Error has been occured while connection with remote adress %s", socket.getRemoteSocketAddress()));//11.8
            }
            catch (ClassNotFoundException ie)
            {
                ConsoleHelper.writeMessage(String.format("Error has been occured while connection with remote adress %s", socket.getRemoteSocketAddress()));//11.8
            }
            connectionMap.remove(newClient);//11.9
            sendBroadcastMessage(new Message(MessageType.USER_REMOVED, newClient));//11.9

            ConsoleHelper.writeMessage("Connection with remote server was closed");//11.10


        }
    }



    public static void sendBroadcastMessage(Message message)
    {

        for (Map.Entry<String, Connection> pair : connectionMap.entrySet())
        {
            try
            {
                pair.getValue().send(message);
            }
            catch (IOException ie)
            {
                ConsoleHelper.writeMessage("Can't send the message to " + pair.getKey());
            }
        }
    }

    public static void main(String [] args) throws IOException
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

