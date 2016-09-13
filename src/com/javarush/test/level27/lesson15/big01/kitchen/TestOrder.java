package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;

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
        super.initDishes();

        //г) переопредели initDishes в классе-наследние TestOrder. Сделай инициализацию случайным набором блюд.
    }
}


