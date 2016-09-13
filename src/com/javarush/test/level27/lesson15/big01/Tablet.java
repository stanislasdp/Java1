package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.ad.AdvertisementManager;
import com.javarush.test.level27.lesson15.big01.ad.NoVideoAvailableException;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;
import com.javarush.test.level27.lesson15.big01.kitchen.TestOrder;

import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by stas on 9/10/16.
 */
public class Tablet extends Observable
{
    private static final Logger logger = Logger.getLogger(Tablet.class.getName());
    private final int number;

    public Tablet(int number)
    {
        this.number = number;
    }


    @Override
    public String toString()
    {
        return String.format("Tablet{number=%d}",number);
    }

    public void createOrder()
    {
        try
        {
            orderJob(new Order(this));
        }
        catch (IOException ie)
        {
            logger.log(Level.SEVERE,"Console is unavailable.");
        }
    }

    public void createTestOrder()
    {
        try
        {
            orderJob(new TestOrder(this));
        }
        catch (IOException ie)
        {
            logger.log(Level.SEVERE,"Console is unavailable.");
        }

    }

    private void orderJob(Order order)
    {
        try
        {
            ConsoleHelper.writeMessage(order.toString());

            if (!order.isEmpty())
            {
                setChanged();
                notifyObservers(order);
                new AdvertisementManager(order.getTotalCookingTime() * 60).processVideos();
            }
        }

        catch (NoVideoAvailableException ne)
        {
            logger.log(Level.INFO,"No video is available for the order ");
        }
    }


}
