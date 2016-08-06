package com.javarush.test.level26.lesson10.home01;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable
{
    protected BlockingQueue queue;

    public Producer(BlockingQueue queue)
    {
        this.queue = queue;
    }

    public void run()
    {
        boolean stopThread = false;
        try {
            int i = 0;

            while (!stopThread)
            {
                queue.put(String.valueOf(i++));
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
            stopThread = true;
        }
    }
}