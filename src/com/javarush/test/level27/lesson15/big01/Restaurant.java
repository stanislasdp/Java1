package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;
import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by stas on 9/10/16.
 */
public class Restaurant
{

    private static final int ORDER_CREATING_INTERVAL = 100;
    private static final LinkedBlockingQueue<Order> queue = new LinkedBlockingQueue<>();

    public static void main(String[] args)
    {
        Cook cook1 = new Cook("Amigo");
        cook1.setQueue(queue);
        Cook cook2 = new Cook("Stas");
        cook2.setQueue(queue);

        Waitor waitor = new Waitor();
        List<Tablet> tablets = new ArrayList<>();

        for (int i = 0; i <  5 ; i++)
        {
            Tablet tablet = new Tablet(i+1);
            tablet.setQueue(queue);
            tablets.add(tablet);
        }
        cook1.addObserver(waitor);

        cook2.addObserver(waitor);
        Thread thCook1 = new Thread(cook1);
        Thread thCook2 = new Thread(cook2);
        thCook1.start();
        thCook2.start();

        Thread thRandom = new Thread(new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL));
        thRandom.start();
        try
        {;
            Thread.sleep(1000);
        }
        catch (InterruptedException ie)
        {

        }
        thRandom.interrupt();

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
    }

}


