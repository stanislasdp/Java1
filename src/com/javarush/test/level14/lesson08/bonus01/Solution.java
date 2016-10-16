package com.javarush.test.level14.lesson08.bonus01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            int [] arr = new int[3];
            int test  =arr[4];
        }
        catch (IndexOutOfBoundsException io)
        {
            exceptions.add(io);
        }
        try
        {
            int test = Integer.parseInt("1r");
        }
        catch (NumberFormatException ne)
        {
            exceptions.add(ne);
        }
        try
        {
          List<String> testArr = new ArrayList<>();
            LinkedList<String> testlnk = (LinkedList<String>) testArr;
            testlnk.poll();
        }
        catch (ClassCastException ce)
        {
            exceptions.add(ce);
        }
        try
        {
           final Thread th = new Thread(new Runnable()
           {
               @Override
               public void run()
               {

               }
           });
            th.start();
            th.start();
        }
        catch (IllegalThreadStateException ste)
        {
            exceptions.add(ste);
        }
        try
        {
            List<String> test = null;
            test.get(5);
        }
        catch (NullPointerException npe)
        {
            exceptions.add(npe);
        }
        try
        {
            FileInputStream fileInputStream = new FileInputStream(new File("111"));
        }
        catch (FileNotFoundException nff)
        {
            exceptions.add(nff);
        }
        try
        {
            List<Integer> testList = new ArrayList<>();
            testList.add(1);
            testList.add(2);
            testList.add(3);

            for (Integer i: testList)
            {
                testList.add(5);
                testList.remove(i);

            }
        }
        catch (ConcurrentModificationException ce)
        {
            exceptions.add(ce);
        }
        try
        {
            String str= "test";
            char ch = str.charAt(7);
        }
        catch (StringIndexOutOfBoundsException siob)
        {
            exceptions.add(siob);
        }
        try
        {
            int[] arr = new int[-7];
        }
        catch (NegativeArraySizeException nse)
        {
            exceptions.add(nse);
        }

        //Add your code here

    }
}
