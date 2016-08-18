package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by stas on 8/15/16.
 */
public class Order
{

   private List<Dish> dishes;
   private Tablet tablet;

    public Order(Tablet tablet) throws IOException
    {
        dishes = ConsoleHelper.getAllDishesForOrder();
        this.tablet= tablet;
    }

    @Override
    public String toString()
    {
        String ret = "";
        if (dishes.isEmpty())
    {
        return ret;
    }
        else
        {
                ret= String.format("Your order: %s of %s",dishes.toString(),tablet.toString());
        }
        return ret;

    }

   public int getTotalCookingTime()
    {
        int totalTime = 0;

        for (Dish dish: this.dishes)
        {
            totalTime+=dish.getDuration();
        }
        return totalTime;
    }

    public boolean isEmpty()
     {
         return dishes.isEmpty();
     }
}

