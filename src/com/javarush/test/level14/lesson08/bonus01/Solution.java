package com.javarush.test.level14.lesson08.bonus01;

import java.io.*;
import java.util.*;
import java.util.zip.DataFormatException;

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
            int [] arr = new int[4];
            arr[6]=7;
        }

        catch (IndexOutOfBoundsException ie)
        {
            exceptions.add(ie);
        }
        try
        {
            Object i = 42;
            String s =(String)i;

        }
        catch (ClassCastException cle)
        {
            exceptions.add(cle);
        }
        try
        {
            throw new DataFormatException();

        }
        catch (DataFormatException ie)
        {
            exceptions.add(ie);
        }
        try
        {
            int [] arr2 = new int[-4];

        }
        catch (NegativeArraySizeException naz)
        {
            exceptions.add(naz);
        }
        try
        {
            Map<String, Integer> map = new HashMap<String, Integer>();
            map.put("1",1);
            map.put("2",2);
            for(String key: map.keySet())
            {
                if(map.get(key) == 1)
                map.remove(key);
            }

        }
        catch (ConcurrentModificationException ce)
        {
            exceptions.add(ce);
        }


        try
        {
            String str = null;
            if(str.equals("Test"))
            {

            }
        }
        catch (NullPointerException ne)
        {
            exceptions.add(ne);
        }
        try
        {
            Class loadedClass = Class.forName("Clazz");

        }
        catch (ClassNotFoundException cl)
        {
            exceptions.add(cl);
        }
        try
        {

            LineNumberReader reader  = new LineNumberReader(new FileReader("ololo"));
        }
        catch (IOException ie)
        {
            exceptions.add(ie);
        }
        try
        {
            throw new UnsupportedOperationException("Invalid operation for sorted list.");

        } catch (UnsupportedOperationException ae)
        {
            exceptions.add(ae);
        }
    }
}
