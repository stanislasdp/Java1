package com.javarush.test.level27.lesson15.big01;

import java.util.ArrayList;

/**
 * Created by stas on 9/13/16.
 */
public class RandomOrderGeneratorTask implements Runnable
{
    ArrayList<Tablet> tablets = new ArrayList<>();
    int randomTablet =(int)(Math.random() * tablets.size());



    @Override
    public void run()
    {
        while (true)
        {

        }
    }
}
