package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by stas on 6/9/16.
 */
public class Singleton
{
    private static Singleton singleton;

    private Singleton()
    {

    }

    public static Singleton getInstance()
    {
        if (singleton==null)
        {
            singleton= new Singleton();
        }
        return singleton;
    }
}
