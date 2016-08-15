package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Order;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by stas on 8/15/16.
 */
public class Tablet
{
    private static final Logger LOGGER = Logger.getLogger(Tablet.class.getName());

   public final int number;

    public Tablet(int number)
    {
        this.number = number;
    }

    public void createOrder()
    {
        try
        {
            ConsoleHelper.writeMessage(new Order(this).toString());
        }
        catch (IOException ie)
        {
            LOGGER.log(Level.SEVERE,"Console is unavailable.");
        }


    }

    @Override
    public String toString()
    {
     return String.format("Tablet{number=%d}",number);
    }
}
