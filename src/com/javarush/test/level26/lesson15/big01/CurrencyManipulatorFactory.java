package com.javarush.test.level26.lesson15.big01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by stas on 8/6/16.
 */
public class CurrencyManipulatorFactory
{
    private static Map<String,CurrencyManipulator> currencyManipulators = new HashMap<String,CurrencyManipulator>();

    private CurrencyManipulatorFactory()
    {
        throw new UnsupportedOperationException();
    }

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencycode)
    {
        for (Map.Entry<String,CurrencyManipulator> pair: currencyManipulators.entrySet())
        {
            if (pair.getKey().equals(currencycode))
            {
                return pair.getValue();
            }
        }
        CurrencyManipulator newone = new CurrencyManipulator(currencycode);
        currencyManipulators.put(currencycode, new CurrencyManipulator(currencycode));
        return currencyManipulators.get(currencycode);
    }

    public static Collection getAllCurrencyManipulators()
    {
        return currencyManipulators.values();
    }

 /*   2.1. В классе CurrencyManipulatorFactory создайте статический метод getAllCurrencyManipulators(), который вернет Collection всех манипуляторов.
    У вас все манипуляторы хранятся в карте, не так ли? Если нет, то рефакторьте.
    2.2. В InfoCommand в цикле выведите [код валюты - общая сумма денег для выбранной валюты]
    Запустим прогу и пополним счет на EUR 100 2 и USD 20 6, и посмотрим на INFO.
    Все работает правильно?
    EUR - 200
    USD - 120
    Отлично!*/
}
