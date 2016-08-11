package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

/**
 * Created by stas on 8/6/16.
 */
public class ConsoleHelper
{
   private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+"common_en");


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

                readString = br.readLine();
                if (readString.equalsIgnoreCase("exit"))
                {
                   ConsoleHelper.writeMessage(res.getString("the.end"));
                    throw new InterruptOperationException();
                }


        }
        catch (IOException ie)
        {

        }
        return readString;
    }

    public static String askCurrencyCode() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("choose.currency.code"));
        String currency = readString();

        while (true)
        {
            if (currency.length()==3)
            {
                break;
            }
            else
            {
                ConsoleHelper.writeMessage(res.getString("invalid.data"));
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
            ConsoleHelper.writeMessage(String.format(res.getString("choose.denomination.and.count.format"),currencyCode));
            value_amount = readString();
            arr_amout = value_amount.split(" ");
            if (arr_amout.length != 2)
            {
                ConsoleHelper.writeMessage(res.getString("invalid.data"));
                continue;
            }
            if (!arr_amout[0].matches("-?\\d+") || !arr_amout[1].matches("-?\\d+"))
            {
                ConsoleHelper.writeMessage(res.getString("invalid.data"));;
                continue;
            }
            if (Integer.parseInt(arr_amout[0]) <= 0 || Integer.parseInt(arr_amout[1]) <= 0)
            {
                ConsoleHelper.writeMessage(res.getString("invalid.data"));
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
            ConsoleHelper.writeMessage(res.getString("choose.operation"));
            ConsoleHelper.writeMessage(res.getString("operation.INFO")+" 1");
            ConsoleHelper.writeMessage(res.getString("operation.DEPOSIT")+" 2");
            ConsoleHelper.writeMessage(res.getString("operation.WITHDRAW")+" 3");
            ConsoleHelper.writeMessage(res.getString("operation.EXIT")+" 4");
            String oper_number = readString();
            if (!String.valueOf(oper_number).matches("\\d+"))
            {
                ConsoleHelper.writeMessage(res.getString("invalid.data"));
                continue;
            }
            try
            {
                op = Operation.getAllowableOperationByOrdinal(Integer.parseInt(oper_number));
            }
            catch (IllegalArgumentException ie)
            {
                ConsoleHelper.writeMessage(res.getString("invalid.data"));
            }
        }
        return op;
    }
}

/*
the.end=Terminated. Thank you for visiting JavaRush cash machine. Good luck.
        operation.INFO=INFO
        operation.DEPOSIT=DEPOSIT
        operation.WITHDRAW=WITHDRAW
        operation.EXIT=EXIT
        invalid.data=Please specify valid data.

*/
