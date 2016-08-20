package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Dish;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by stas on 8/15/16.
 */
public class ConsoleHelper
{
   private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


   public static void writeMessage(String message)
    {
        System.out.println(message);
    }

   public static String readString() throws IOException
    {
        return  br.readLine();

    }


      public static List<Dish> getAllDishesForOrder() throws IOException
     {
         List<Dish> dishes =  new ArrayList<>();
         writeMessage(Dish.allDishesToString());
         writeMessage("Enter dish");
         while (true)
         {
             String dish = readString();
             if (dish.equalsIgnoreCase("exit"))
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
