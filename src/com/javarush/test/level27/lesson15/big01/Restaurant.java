package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;

import java.util.Locale;

/**
 * Created by stas on 9/10/16.
 */
public class Restaurant
{
    public static void main(String[] args)
    {
       /* Tablet tablet = new Tablet(5);
        Cook cook1 = new Cook("Amigo");
        Waitor waitor = new Waitor();
        tablet.addObserver(cook1);
        cook1.addObserver(waitor);
        tablet.createOrder();
        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();*/


        Locale.setDefault(Locale.ENGLISH);
        // First order
        Tablet tablet = new Tablet(5);
        Cook cook = new Cook("Ivanov");
        tablet.addObserver(cook);
        Waitor waitor = new Waitor();
        cook.addObserver(waitor);
        tablet.createOrder();
        // Second Order
        Tablet tablet2 = new Tablet(5);
        Cook cook2 = new Cook("Petrov");
        tablet2.addObserver(cook2);
        Waitor waitor2 = new Waitor();
        cook2.addObserver(waitor2);
        tablet2.createOrder();
        // Third order
        Tablet tablet3 = new Tablet(5);
        Cook cook3 = new Cook("Ivanov");
        tablet3.addObserver(cook3);
        Waitor waitor3 = new Waitor();
        cook3.addObserver(waitor2);
        tablet3.createOrder();
        // Fourth order
        Tablet tablet4 = new Tablet(5);
        Cook cook4 = new Cook("Ivanov");
        tablet4.addObserver(cook4);
        Waitor waitor4 = new Waitor();
        cook4.addObserver(waitor4);
        tablet4.createOrder();
        // Fifth order
        Tablet tablet5 = new Tablet(5);
        Cook cook5 = new Cook("Petrov");
        tablet5.addObserver(cook5);
        Waitor waitor5 = new Waitor();
        cook5.addObserver(waitor5);
        tablet5.createOrder();
        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();


    }


}
