package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by stas on 9/13/16.
 */
public class TestOrder extends Order
{
    public TestOrder(Tablet tablet) throws IOException
    {
        super(tablet);
    }

    @Override
    protected void initDishes() throws IOException
    {
         dishes = new ArrayList<Dish>();
		for (int i = 0; i < Dish.values().length ; i++)
		{
			int randomDish = (int)(Math.random() * Dish.values().length);
			dishes.add(Dish.values()[randomDish]);
		}
    }
}


