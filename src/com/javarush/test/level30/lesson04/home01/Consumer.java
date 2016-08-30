package com.javarush.test.level30.lesson04.home01;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

/**
 * Created by stas on 8/30/16.
 */
public class Consumer implements Runnable
{
    TransferQueue<ShareItem> transferQueue;

    public Consumer(TransferQueue<ShareItem> transferQueue)
    {
        this.transferQueue = transferQueue;
    }
    @Override
    public void run()
    {
        try
        {
            TimeUnit.MILLISECONDS.sleep(500);
            while (!Thread.currentThread().isInterrupted())
            {
                ShareItem item = transferQueue.take();
                System.out.println("Processing "+ item.toString());
            }

        }
        catch (InterruptedException ie)
        {

        }



    }
}
