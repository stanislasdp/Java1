package com.javarush.test.level30.lesson15.big01.client;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by stas on 9/3/16.
 */
public class ClientGuiModel //20.1
{


    private final Set allUserNames = new HashSet();//20.2


    private String newMessage;//20.3


    public Set getAllUserNames()
    {
        return Collections.unmodifiableSet(allUserNames);//20.4
    }

    public String getNewMessage()//20.5
    {
        return newMessage;
    }

    public void setNewMessage(String newMessage)//20.5
    {
        this.newMessage = newMessage;
    }

    public void addUser(String newUserName)
    {
        allUserNames.add(newUserName);
    }

    public void deleteUser(String userName)
    {
        allUserNames.remove(userName);
    }


}
