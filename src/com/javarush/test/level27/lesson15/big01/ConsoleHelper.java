package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by stas on 9/10/16.
 */
public class ConsoleHelper
{
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));


    public static void writeMessage(String message)
    {
        System.out.println(message);
    }

    public static String readString() throws IOException
    {
        return bf.readLine();
    }


    public static List<Dish> getAllDishesForOrder() throws IOException
    {
        List<Dish> dishes = new ArrayList<>();
        writeMessage(Dish.allDishesToString());
        writeMessage("Please enter dish");
        while (true)
        {
            String dish = readString();

            if ("exit".equalsIgnoreCase(dish))
            {
                break;
            }
            try
            {
                dishes.add(Dish.valueOf(dish));
            }
            catch (IllegalArgumentException ie)
            {
                ConsoleHelper.writeMessage(dish+" is not detected");
            }

        }
        return dishes;
    }


}
