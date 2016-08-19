package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.ad.AdvertisementManager;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;

import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by stas on 8/15/16.
 */
public class Tablet extends Observable
{
	
	private static final Logger LOGGER = Logger.getLogger(Tablet.class.getName());

	public final int number;

	public Tablet(int number)
	{
		this.number = number;
	}

	public void createOrder()
	{
		Order order = null;
		try
		{
			order = new Order(this);
			ConsoleHelper.writeMessage(order.toString());

			if (!order.isEmpty())
			{
				new AdvertisementManager(order.getTotalCookingTime()*60).processVideos();
				this.setChanged();
				this.notifyObservers(order);
			}
		}
		catch (IOException ie)
		{
			LOGGER.log(Level.SEVERE,"Console is unavailable.");
		}
		catch (NoVideoAvailableException ve) 
		{
			LOGGER.log(Level.INFO,"No video is available for the order "+ order);
		}
	}

	@Override
	public String toString()
	{
		return String.format("Tablet{number=%d}",number);
	}
}
