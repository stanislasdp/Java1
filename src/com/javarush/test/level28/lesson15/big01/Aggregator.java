package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.Provider;

/**
 * Created by stas on 8/21/16.
 */
public class Aggregator
{
    public static void main(String[] args)
    {
        Provider provider = new Provider(null);
        Controller controller = new Controller(provider);
        controller.scan();
    }
}
