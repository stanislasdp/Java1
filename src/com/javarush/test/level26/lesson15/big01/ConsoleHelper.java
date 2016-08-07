package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

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

    public static String readString() throws InterruptOperationException
    {
        String readString = "";
        try
        {
            if (br==null)
                br = new BufferedReader(new InputStreamReader(System.in));

          //  try
        //    {
                readString = br.readLine();
                if (readString.equalsIgnoreCase("exit"))
                {
                    throw new InterruptOperationException();
                }
          //  }
          /*  catch (InterruptOperationException ie)
            {

            }*/


        }
        catch (IOException ie)
        {

        }
        return readString;
    }

    public static String askCurrencyCode() throws InterruptOperationException
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

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException
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

    public static Operation askOperation() throws InterruptOperationException
    {
        Operation op = null;

        while (op==null)
        {
            writeMessage("Enter operation");
            String oper_number = readString();
            if (!String.valueOf(oper_number).matches("\\d+"))
            {
                writeMessage("incorrect data");
                continue;
            }
            try
            {
                op = Operation.getAllowableOperationByOrdinal(Integer.parseInt(oper_number));
            }
            catch (IllegalArgumentException ie)
            {
                writeMessage("incorrect data");
            }
        }
        return op;

    }

 /*   2. В классе ConsoleHelper реализуйте логику статического метода Operation askOperation()
    Спросить у пользователя операцию.
    Если пользователь вводит 1, то выбирается команда INFO, 2 - DEPOSIT, 3 - WITHDRAW, 4 - EXIT;
    Используйте метод, описанный в п.1.
    Обработай исключение - запроси данные об операции повторно.*/
}
