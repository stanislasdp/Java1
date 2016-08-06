package com.javarush.test.level26.lesson15.big01;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by stas on 8/6/16.
 */
public class CurrencyManipulator
{
     Map<Integer,Integer> denominations = new HashMap<>();
    public CurrencyManipulator(String currencyCode)
    {
        this.currencyCode = currencyCode;
    }

    private String currencyCode;


    public String getCurrencyCode()
    {
        return currencyCode;
    }

    public void addAmount(int denomination, int count)
    {
        if (denominations.containsKey(denomination))
        {
            denominations.put(denomination,denominations.get(denomination) + count);
        }
        else
        {
            denominations.put(denomination,count);
        }

    }

}


/*
4. В классе CurrencyManipulator создайте метод void addAmount(int denomination, int count),
        который добавит введенные номинал и количество банкнот

        5. Пора уже увидеть приложение в действии.
        В методе main захардкодь логику пункта 1.
        Кстати, чтобы не было проблем с тестами на стороне сервера, добавь в метод main первой строчкой Locale.setDefault(Locale.ENGLISH);
        Запускаем, дебажим, смотрим.*/
