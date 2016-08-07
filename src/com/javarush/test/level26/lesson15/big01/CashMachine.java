package com.javarush.test.level26.lesson15.big01;

import java.util.Locale;

/**
 * Created by stas on 8/6/16.
 */
public class CashMachine
{
    public static void main(String[] args)
    {
        Locale.setDefault(Locale.ENGLISH);
        ConsoleHelper.askOperation();
       String currency = ConsoleHelper.askCurrencyCode();;
        String[] value_amount =ConsoleHelper.getValidTwoDigits(currency);
        CurrencyManipulator cm = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currency);
        cm.addAmount(Integer.parseInt(value_amount[0]),Integer.parseInt(value_amount[1]));
        System.out.println(cm.getTotalAmount());



    }
}
