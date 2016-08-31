package com.javarush.test.level30.lesson15.big01;

import java.io.Serializable;

/**
 * Created by stas on 8/31/16.
 */
public class Message implements Serializable
{
    final private MessageType type;
     final private String data;

    public Message(MessageType type)
    {
        this.type = type;
        data = null;
    }

    public Message(MessageType type, String data)
    {
        this.type = type;
        this.data = data;
    }

    public MessageType getType()
{
    return type;
}

    public String getData()
    {
        return data;
    }
}
