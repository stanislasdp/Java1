package com.javarush.test.level26.lesson15.big01;

import java.util.ArrayList;

/**
 * Created by stas on 8/6/16.
 */
public class CurrencyManipulatorFactory
{
    public static ArrayList<CurrencyManipulator> currencyManipulators = new ArrayList<>();

    private CurrencyManipulatorFactory()
    {
        throw new UnsupportedOperationException();
    }

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencycode)
    {
        for (CurrencyManipulator cm: currencyManipulators)
        {
            if (cm.getCurrencyCode().equals(currencycode))
            {
               return cm;
            }
        }
        CurrencyManipulator newone = new CurrencyManipulator(currencycode);
        currencyManipulators.add(newone);
        return newone;

    }
}
