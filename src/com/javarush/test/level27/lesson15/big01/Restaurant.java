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
    private static final LinkedBlockingQueue<Order> ORDER_QUEU = new LinkedBlockingQueue<>();

    public static void main(String[] args)
    {
        Cook cook1 = new Cook("Amigo");
        Cook cook2 = new Cook("Stas");
        StatisticEventManager.getInstance().register(cook1);
        StatisticEventManager.getInstance().register(cook2);
        Waitor waitor = new Waitor();


        List<Tablet> tablets = new ArrayList<>();
        OrderManager ordManager = new OrderManager();
        for (int i = 0; i <  5 ; i++)
        {
            Tablet tablet = new Tablet(i+1);
            tablet.setOrderQueu(ORDER_QUEU);
            tablets.add(tablet);
           // tablet.addObserver(ordManager);
        }
        cook1.addObserver(waitor);
        cook1.setOrdersQueque(ORDER_QUEU);
        cook2.addObserver(waitor);
        cook2.setOrdersQueque(ORDER_QUEU);

        Thread th = new Thread(new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL));
        th.start();
        try
        {
           // TimeUnit.SECONDS.sleep(1);
            Thread.sleep(1000);
        }
        catch (InterruptedException ie)
        {

        }
        th.interrupt();

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
    }
}


