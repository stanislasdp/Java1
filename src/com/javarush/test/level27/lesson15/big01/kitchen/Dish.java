package com.javarush.test.level27.lesson15.big01.kitchen;

/**
 * Created by stas on 8/15/16.
 */
public enum Dish
{
    Fish, Steak, Soup, Juice, Water;

    public static String allDishesToString()
    {

        if (values().length==0)
        {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<Dish.values().length;i++ )
        {
            sb.append(Dish.values()[i]);
            sb.append(", ");
        }
        return sb.toString().trim().substring(0,sb.toString().length()-2);
    }
}
