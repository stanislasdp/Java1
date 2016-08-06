package com.javarush.test.level26.lesson10.home02;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by stas on 8/6/16.
 */
public class Producer implements Runnable
{
    protected ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map)
    {
        this.map = map;
    }

    @Override
    public void run()
    {
        Thread currentThread = Thread.currentThread();
        try
        {
            int i = 1;
            while (!currentThread.isInterrupted())
            {
                map.put(String.valueOf(i),String.format("Some text for %d",i));
              //  System.out.println(map.get(String.valueOf(i)));
                i++;
                Thread.sleep(500);
            }
        }
        catch (InterruptedException ie)
        {
            System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
        }

    }
}
