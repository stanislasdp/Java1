package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.statistic.StatisticManager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by stas on 9/11/16.
 */
public class DirectorTablet
{
    public void printAdvertisementProfit()
    {
        Map<Date,Double> map = StatisticManager.getInstance().getVideoSelectedProfit();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        double totalSum = 0;

        for (Map.Entry<Date,Double> pair: map.entrySet())
        {
            ConsoleHelper.writeMessage(String.format("%s - %.2f",sdf.format(pair.getKey()),pair.getValue()));
            totalSum += pair.getValue();
        }
        ConsoleHelper.writeMessage(String.format("Total - %.2f",totalSum));

    }

    public void printCookWorkloading()
    {
       Map<Date,Map<String,Integer>> map = StatisticManager.getInstance().getCookWorkLoad();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");

        for (Map.Entry<Date,Map<String,Integer>> pair: map.entrySet() )
        {
            ConsoleHelper.writeMessage(String.format("%s",sdf.format(pair.getKey())));

            Map<String,Integer> cookInfo = pair.getValue();
            for (Map.Entry<String,Integer> cook: cookInfo.entrySet())
            {
                int roundedTime = (cook.getValue()+59)/60;

                ConsoleHelper.writeMessage(String.format("%s - %d min",cook.getKey(),roundedTime));
            }
            ConsoleHelper.writeMessage("");

        }
    }

    public void printActiveVideoSet()
    {

    }

    public  void printArchivedVideoSet()
    {

    }
}
