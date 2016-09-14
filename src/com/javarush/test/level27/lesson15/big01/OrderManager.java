package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by stas on 9/14/16.
 */
public class OrderManager implements Observer
{
  //  private LinkedBlockingQueue<Order> ordersQueque = new LinkedBlockingQueue<>();

    public OrderManager()
    {
        Thread thread = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                while (!Thread.currentThread().isInterrupted())
                {

                        if (ordersQueque.peek() != null)
                        {
                            for (Cook cook: StatisticEventManager.getInstance().getCookSet())
                            {
                                if (!cook.isBusy())
                                {
                                    final Cook cookFinal = cook;
                                    new Thread(new Runnable()
                                    {
                                        @Override
                                        public void run()
                                        {
                                            cookFinal.startCookingOrder(ordersQueque.poll());
                                        }
                                    }).start();
                                    break;
                                }
                            }
                        }
                    try
                    {
                        Thread.sleep(10);
                    }
                    catch (InterruptedException ie)
                    {

                    }
                    ;
                }

            }
        });
        thread.setDaemon(true);
        thread.start();
    }
    @Override
    public void update(Observable o, Object arg)
    {

            ordersQueque.add((Order)arg);


    }
}
