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
    public int getTotalAmount()
    {
        int summ =0;
        for (Map.Entry<Integer,Integer> pair: denominations.entrySet())
        {
            summ+=pair.getKey() * pair.getValue();
        }
        return summ;
    }

}


/*Задание 5
        1.В предыдущем таске мы реализовали основную логику операции DEPOSIT.
        Но посмотреть результат так и не удалось.
        Поэтому создадим в манипуляторе метод int getTotalAmount(), который посчитает общую сумму денег для выбранной валюты.

        2. Добавим вызов метода getTotalAmount() в метод main.
        Всё работает верно? Тогда движемся дальше.
        Видно, что метод getTotalAmount() считает то, что нам необходимо для операции INFO.
        Поэтому пришло время небольшого рефакторинга.
        !!Читайте паттерн Command.
        Однако, перед рефакторингом нужно еще разобраться в одном вопросе. Но об этом не сейчас.*/
