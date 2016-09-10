package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.List;

/**
 * Created by stas on 9/10/16.
 */
public class Order
{

    private List<Dish> dishes;
    private Tablet tablet;


    public Order(Tablet tablet) throws IOException
    {
        this.tablet = tablet;
        dishes = ConsoleHelper.getAllDishesForOrder();
    }


 @Override
    public String toString()
    {
        if (dishes.isEmpty())

        {
            return "";
        }

        return String.format("Your order: %s of %s",dishes.toString(),tablet.toString());
    }
}
