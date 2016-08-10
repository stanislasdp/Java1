package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.*;

/**
 * Created by stas on 8/6/16.
 */
public class CurrencyManipulator
{

	 Map<Integer,Integer> denominations;
	    public CurrencyManipulator(String currencyCode)
	    {
	        this.currencyCode = currencyCode;
	        denominations = new TreeMap<Integer,Integer>().descendingMap();
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

	    public  boolean isAmountAvailable(int expectedAmount)
	    {
	        return getTotalAmount()>=expectedAmount;
	    }

	   public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException,ConcurrentModificationException
	    {
			int withdrawamount = expectedAmount;
			int countofcurbank = 0;

			 Map<Integer,Integer> copyofdenominations = new TreeMap<>(denominations).descendingMap();

			Map<Integer,Integer> resultMap = new TreeMap<Integer,Integer>(Collections.reverseOrder());

			try
			{
				for (Map.Entry<Integer, Integer> pair : denominations.entrySet())
				{
					int denomination = pair.getKey();
					int banknotes = pair.getValue();

					while (banknotes > 0 && (withdrawamount-denomination)>=0)
					{
						withdrawamount-= denomination;
						pair.setValue(--banknotes);
						countofcurbank++;
					}
					if (banknotes==0)
					{
						denominations.remove(denomination);
					}
					if (countofcurbank > 0)
					{
						resultMap.put(denomination, countofcurbank);
					}
					countofcurbank = 0;
				}
			}
			catch (ConcurrentModificationException ce)
			{

			}

			if  (withdrawamount>0)
			{
				denominations = copyofdenominations;
				throw new NotEnoughMoneyException();
			}

			for (Map.Entry<Integer, Integer> pair : resultMap.entrySet())
			{
				System.out.println("\t"+pair.getKey()+" - "+pair.getValue());
			}
			ConsoleHelper.writeMessage("Transaction successful");

		   return resultMap;

	    }

}


