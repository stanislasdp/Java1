package com.javarush.test.level30.lesson15.big01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by stas on 8/31/16.
 */
public class ConsoleHelper
{
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage (String message)
    {
        System.out.println(message);
    }

    public static String readString()
    {
        String readString;
        while (true)
        {
            try
            {
                readString = reader.readLine();
                break;
            }
            catch (IOException e)
            {
                writeMessage("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            }
        }
      return readString;
    }

    public static int readInt()
    {
        int digit = 0;
        while (true)
        {
            try
            {
                digit = Integer.parseInt(readString());
                break;
            }
            catch (NumberFormatException ne)
            {
                writeMessage("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
            }

        }
        return digit;
    }
}
