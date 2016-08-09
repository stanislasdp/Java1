package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

/**
 * Created by stas on 8/7/16.
 */
public class WithdrawCommand implements Command
{
	 @Override
	    public void execute() throws InterruptOperationException
	    {
	        String currency = ConsoleHelper.askCurrencyCode();
	        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currency);

	        String sum = "";
	        while (true)
	        {
	            ConsoleHelper.writeMessage("Enter amount");
	          sum = ConsoleHelper.readString();

	           if (!sum.matches("\\d+")  )
	           {
	               ConsoleHelper.writeMessage("Incorrect data");
	               continue;
	           }

	           if (currencyManipulator.isAmountAvailable(Integer.parseInt(sum)))
	           {
	               ConsoleHelper.writeMessage("Incorrect data");
	               continue;
	           }
	           
	           try
	           {
	        	   Map <Integer,Integer> withdrawmap = currencyManipulator.withdrawAmount(Integer.parseInt(sum));
	        	   for (Map.Entry<Integer, Integer> pair : withdrawmap.entrySet()) 
	        	   {
					System.out.println("\t"+pair.getKey()+" - "+pair.getValue());
				    }
	        	   break;
	           }
	           catch (NotEnoughMoneyException ne)
	           {
	        	   ConsoleHelper.writeMessage("Not enough money");
	           }
	           
	          
	        }
	}
	
}
