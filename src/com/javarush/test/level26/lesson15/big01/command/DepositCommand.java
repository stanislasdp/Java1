package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;

/**
 * Created by stas on 8/7/16.
 */
 class DepositCommand implements Command
{
    @Override
    public void execute()
    {
        String currency = ConsoleHelper.askCurrencyCode();;
        String[] value_amount = ConsoleHelper.getValidTwoDigits(currency);
        CurrencyManipulator cm = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currency);
        cm.addAmount(Integer.parseInt(value_amount[0]),Integer.parseInt(value_amount[1]));
    }
}
