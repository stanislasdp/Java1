package com.javarush.test.level26.lesson15.big01;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by stas on 8/6/16.
 */
public class CurrencyManipulator
{
     Map<Integer,Integer> denominations;
    public CurrencyManipulator(String currencyCode)
    {
        this.currencyCode = currencyCode;
        denominations = new HashMap<>();
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
        int summ = 0;
        for (Map.Entry<Integer,Integer> pair: denominations.entrySet())
        {
            summ+=pair.getKey() * pair.getValue();
        }
        return summ;
    }


    public boolean hasMoney()
    {
        return getTotalAmount()>0;
    }



}


