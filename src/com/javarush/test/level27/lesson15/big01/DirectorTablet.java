package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.ad.Advertisement;
import com.javarush.test.level27.lesson15.big01.ad.StatisticAdvertisementManager;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by stas on 9/11/16.
 */
public class DirectorTablet
{
    public void printAdvertisementProfit()
    {
        Map<Date,Double> map = StatisticEventManager.getInstance().getVideoSelectedProfit();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy",Locale.ENGLISH);
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
        Map<Date,Map<String,Integer>> map = StatisticEventManager.getInstance().getCookWorkLoad();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        for (Map.Entry<Date,Map<String,Integer>> pair: map.entrySet() )
        {

            ConsoleHelper.writeMessage(String.format("%s",sdf.format(pair.getKey())));

            Map<String,Integer> cookInfo = pair.getValue();

            for (Map.Entry<String,Integer> cook: cookInfo.entrySet())
            {
                if (cook.getValue() > 0)
                    ConsoleHelper.writeMessage(String.format("%s - %d min",cook.getKey(),cook.getValue()));
            }
            //ConsoleHelper.writeMessage("");

        }
    }

    public void printActiveVideoSet()
    {
        Set<Advertisement> activeVideoSet =  StatisticAdvertisementManager.getInstance().getVideo();
        for (Advertisement ad: activeVideoSet)
        {
            if (ad.getHits() >= 1)
                ConsoleHelper.writeMessage(String.format("%s - %s",ad.getName(),ad.getHits()));
        }


    }

    public  void printArchivedVideoSet()
    {
        Set<Advertisement> activeVideoSet =  StatisticAdvertisementManager.getInstance().getVideo();
        for (Advertisement ad: activeVideoSet)
        {
            if (ad.getHits() <= 0)
                ConsoleHelper.writeMessage(ad.getName());
        }

    }
}

