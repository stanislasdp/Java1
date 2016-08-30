package com.javarush.test.level30.lesson04.home01;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

/**
 * Created by stas on 8/30/16.
 */
public class Producer implements Runnable
{
    TransferQueue<ShareItem> transferQueue;

    public Producer(TransferQueue<ShareItem> transferQueue)
    {
        this.transferQueue = transferQueue;
    }

    @Override
    public void run()
    {
        for (int N = 1; N <= 9 ; N++)
        {
            System.out.format("Элемент 'ShareItem-%d' добавлен\n",N);
            transferQueue.offer(new ShareItem("ShareItem-"+N,N));
            try
            {
                TimeUnit.MILLISECONDS.sleep(100);
            }
            catch (InterruptedException ie)
            {
                break;
            }


            if (transferQueue.hasWaitingConsumer())
            {
                System.out.println("Consumer в ожидании!");
            }
        }

        }
    }




