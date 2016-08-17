package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Dish;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;

/**
 * Created by stas on 8/15/16.
 */
public class Restaurant
{
    public static void main(String[] args)
    {
        Tablet tablet = new Tablet(5);
		Cook firstcook = new Cook("Amigo");
		tablet.addObserver(firstcook);
		tablet.createOrder();

    }
}
