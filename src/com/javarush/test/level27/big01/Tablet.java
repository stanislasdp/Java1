package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by stas on 9/10/16.
 */
public class Tablet
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
          Order order  = new Order(this);
            ConsoleHelper.writeMessage(order.toString());
        }
        catch (IOException ie)
        {
            logger.log(Level.SEVERE,"Console is unavailable.");
        }


    }

}
