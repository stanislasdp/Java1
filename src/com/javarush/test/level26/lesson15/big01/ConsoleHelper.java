package com.javarush.test.level26.lesson15.big01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by stas on 8/6/16.
 */
public class ConsoleHelper
{
  static  BufferedReader br;

    public static void writeMessage(String message)
    {
        System.out.println(message);
    }

    public static String readString()
    {
        String readString = "";
        try
        {
            if (br==null)
                br = new BufferedReader(new InputStreamReader(System.in));

            readString = br.readLine();
        }
        catch (IOException ie)
        {

        }
        return readString;
    }

    public static String askCurrencyCode()
    {
        writeMessage("Please enter currency");
        String currency = readString();

        while (true)
        {
            if (currency.length()==3)
            {
                break;
            }
            else
            {
                writeMessage("Incorrect data");
                currency = readString();
            }
            currency = currency.toUpperCase();
        }
        return currency;
    }

    public static String[] getValidTwoDigits(String currencyCode)
    {
        String value_amount = "";
        String[] arr_amout = null;
        while (true)
        {
            writeMessage("enter two integers");
            value_amount = readString();
            arr_amout = value_amount.split(" ");
            if (arr_amout.length != 2)
            {
                writeMessage("Data is incorrect");
                continue;
            }
            if (!arr_amout[0].matches("-?\\d+") || !arr_amout[1].matches("-?\\d+"))
            {
                writeMessage("Data is incorrect");;
                continue;
            }
            if (Integer.parseInt(arr_amout[0]) <= 0 || Integer.parseInt(arr_amout[1]) <= 0)
            {
                writeMessage("Data is incorrect");
            }
            else
            {
                break;
            }



        }
        return arr_amout;
    }

   /* 3. Чтобы считать номинал и количество банкнот, добавим статический метод String[] getValidTwoDigits(String currencyCode) в ConsoleHelper.
    Этот метод должен предлагать пользователю ввести два целых положительных числа.
    Первое число - номинал, второе - количество банкнот.
    Никаких валидаторов на номинал нет. Т.е. 1200 - это нормальный номинал.
    Если данные некорректны, то сообщить об этом пользователю и повторить.
    Пример вводимых данных:
        200 5*/
}
