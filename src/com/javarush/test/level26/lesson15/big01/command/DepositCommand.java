package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

/**
 * Created by stas on 8/7/16.
 */
 class DepositCommand implements Command
{
    ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+"deposit_en");
    @Override
    public void execute() throws InterruptOperationException
    {
        try
        {
            ConsoleHelper.writeMessage(res.getString("before"));
            String currency = ConsoleHelper.askCurrencyCode();;
            String[] value_amount = ConsoleHelper.getValidTwoDigits(currency);
            CurrencyManipulator cm = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currency);
            int denom = Integer.parseInt(value_amount[0]);
            int count = Integer.parseInt(value_amount[1]);
            cm.addAmount(denom,count);

            ConsoleHelper.writeMessage(String.format(res.getString("success.format"),denom*count,currency));
        }
        catch (NumberFormatException ne)
        {
            ConsoleHelper.writeMessage(res.getString("invalid.data"));
        }


    }


   /* before=Depositing...
    success.format=%d %s was deposited successfully
    invalid.data=Please specify valid data.*/
}
