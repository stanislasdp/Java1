package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by stas on 8/17/16.
 */
public class Cook extends Observable implements Observer
{
	String name;

	public Cook(String name)
	{
		this.name = name;
	}
	
	@Override
	public String toString() 
	{
		return name;
	}

	@Override
	public void update(Observable o, Object arg) 
	{
		ConsoleHelper.writeMessage(String.format("Start cooking - %s, cooking time %dmin",arg,((Order)arg).getTotalCookingTime()));
		//ConsoleHelper.writeMessage("Start cooking - "+arg+", cooking time ");
		this.setChanged();
		this.notifyObservers(arg);
	}


}
