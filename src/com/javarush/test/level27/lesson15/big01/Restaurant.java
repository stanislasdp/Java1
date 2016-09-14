package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;

import java.util.Locale;

/**
 * Created by stas on 9/10/16.
 */
public class Restaurant
{
    private static int ORDER_CREATING_INTERVAL = 100;
	
	    public static void main(String[] args)
	    {
	        Tablet tablet1 = new Tablet(5);
	        Tablet tablet2 = new Tablet(6);
	        List<Tablet>  tabletsList = new ArrayList<>();
	       tabletsList.add(tablet1);
	       tabletsList.add(tablet2);
	       Cook cook1 = new Cook("Amigo");
	       Waitor waitor = new Waitor();
	       tablet1.addObserver(cook1);
	       tablet2.addObserver(cook1);
	       cook1.addObserver(waitor);
	       Thread th = new Thread(new RandomOrderGeneratorTask(tabletsList, ORDER_CREATING_INTERVAL));
	       th.start();
	        DirectorTablet directorTablet = new DirectorTablet();
	        directorTablet.printAdvertisementProfit();
	        directorTablet.printCookWorkloading();
	        directorTablet.printActiveVideoSet();
	        directorTablet.printArchivedVideoSet();
	    }
}


