package com.javarush.test.level15.lesson12.home04;

/**
 * Created by stas on 6/11/16.
 */
public class Sun implements Planet
{

    private static Sun instance;

    private Sun(){}

    public static Sun getInstance()
    {
        if (instance==null)
        {
            instance = new Sun();
        }
        return instance;
    }
}
