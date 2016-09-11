package com.javarush.test.level27.lesson15.big01.kitchen;


/**
 * Created by stas on 9/10/16.
 */
public enum Dish
{
    Fish(25),
    Steak(30),
    Soup(15),
    Juice(5),
    Water(3);

    private int duration;

    Dish(int duration)
    {
        this.duration = duration;
    }

    public static String allDishesToString()
    {
        if (values().length == 0)
        return  "";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <Dish.values().length ; i++)
        {
            sb.append(Dish.values()[i]);
            if (i != Dish.values().length-1)
            {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public int getDuration()
    {
        return duration;
    }





}
