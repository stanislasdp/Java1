package com.javarush.test.level26.lesson10.home01;

import java.util.concurrent.BlockingQueue;

/**
 * Created by stas on 8/6/16.
 */
public class Consumer implements Runnable
{
    protected BlockingQueue queue;

    public Consumer(BlockingQueue queue)
    {
        this.queue =queue;
    }


    @Override
    public void run()
    {
        boolean stopThread = false;
        while (!stopThread)
        {
            try
            {
                Thread.sleep(500);
                System.out.println(queue.poll());
            }
            catch (InterruptedException ie)
            {
                System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
                stopThread = true;
            }

        }
    }
}
