package com.javarush.test.level27.lesson15.big01.kitchen;



import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;
import com.javarush.test.level27.lesson15.big01.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by stas on 9/10/16.
 */
public class Cook extends Observable implements Runnable
{
    String name;
    private LinkedBlockingQueue<Order> queue;
    private volatile boolean busy;

    public Cook(String name)
    {
        this.name = name;
    }

    public void setQueue (LinkedBlockingQueue<Order> queue)
    {
        this.queue = queue;
    }

    @Override
    public String toString()
    {
        return name;
    }


    public  void startCookingOrder(Order order)
    {
        busy = true;
        try
        {
            ConsoleHelper.writeMessage(String.format("Start cooking - %s, cooking time %dmin",order,order.getTotalCookingTime()));
            TimeUnit.MILLISECONDS.sleep(10 * order.getTotalCookingTime());
            setChanged();
            notifyObservers(order);
            StatisticEventManager.getInstance().register(new CookedOrderEventDataRow(order.getTablet().toString(),name,order.getTotalCookingTime() * 60,order.getDishes()));
            busy = false;
        }
        catch (InterruptedException ie)
        {

        }
    }

    public boolean isBusy()
    {
        return busy;
    }

    @Override
    public void run()
    {
        while (!Thread.currentThread().isInterrupted())
            try
            {
                if (!queue.isEmpty() && !isBusy())
                {
                    startCookingOrder(queue.take());
                }
                TimeUnit.MILLISECONDS.sleep(10);

            }
            catch (InterruptedException ie)
            {
                return;
            }
    }
}
