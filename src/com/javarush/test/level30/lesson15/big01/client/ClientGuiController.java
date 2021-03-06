package com.javarush.test.level30.lesson15.big01.client;

/**
 * Created by stas on 9/3/16.
 */
public class ClientGuiController extends Client
{
    private  ClientGuiModel model = new ClientGuiModel();
    private ClientGuiView view = new ClientGuiView(this);


    @Override
    protected SocketThread getSocketThread()
    {
        return  new GuiSocketThread();
    }

    @Override
    public void run()
    {
        getSocketThread().run();
    }

    @Override
    protected String getServerAddress()
    {
       return view.getServerAddress();
    }

    @Override
    protected int getServerPort()
    {
        return view.getServerPort();
    }

    @Override
    protected String getUserName()
    {
        return view.getUserName();
    }

    public ClientGuiModel getModel()
    {
        return model;
    }

    public static void main(String[] args)
    {
        new ClientGuiController().run();
    }

    public class GuiSocketThread extends Client.SocketThread
    {
        @Override
        protected void processIncomingMessage(String message)
        {
            model.setNewMessage(message);
            view.refreshMessages();
            super.processIncomingMessage(message);
        }

        @Override
        protected void informAboutAddingNewUser(String userName)
        {
            model.addUser(userName);
            view.refreshUsers();
            super.informAboutAddingNewUser(userName);
        }

        @Override
        protected void informAboutDeletingNewUser(String userName)
        {
            model.deleteUser(userName);
            view.refreshUsers();
        }

        @Override
        protected void notifyConnectionStatusChanged(boolean clientConnected)
        {
            view.notifyConnectionStatusChanged(clientConnected);
        }
    }
}
