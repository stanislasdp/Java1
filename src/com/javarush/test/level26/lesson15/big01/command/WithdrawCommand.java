package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by stas on 8/7/16.
 */
public class WithdrawCommand implements Command
{
	private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+"withdraw_en");
	 @Override
	    public void execute() throws InterruptOperationException
	    {
			ConsoleHelper.writeMessage(res.getString("before"));
	        String currency = ConsoleHelper.askCurrencyCode();
	        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currency);

	        String sum = "";
	        while (true)
	        {
	            ConsoleHelper.writeMessage(res.getString("specify.amount"));
	          sum = ConsoleHelper.readString();

	           if (!sum.matches("\\d+") || Integer.parseInt(sum)<=0 )
	           {
	               ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
	               continue;
	           }


	           if (!currencyManipulator.isAmountAvailable(Integer.parseInt(sum)))
	           {
				   ConsoleHelper.writeMessage(res.getString("not.enough.money"));
	               continue;
	           }

	           try
	           {
	        	   currencyManipulator.withdrawAmount(Integer.parseInt(sum));

	           }
	           catch (NotEnoughMoneyException ne)
	           {
				   ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));

	           }
				ConsoleHelper.writeMessage(String.format(res.getString("success.format"),Integer.parseInt(sum),currency));
				break;
	        }
	}
	
}
/*

before=Withdrawing...+
		success.format=%d %s was withdrawn successfully+
		specify.amount=Please specify integer amount for withdrawing.+
		specify.not.empty.amount=Please specify valid positive integer amount for withdrawing.+
		not.enough.money=Not enough money on your account, please try again
		exact.amount.not.available=Exact amount is not available*/
