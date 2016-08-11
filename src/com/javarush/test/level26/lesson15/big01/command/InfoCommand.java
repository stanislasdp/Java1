package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;

import java.util.*;

/**
 * Created by stas on 8/7/16.
 */
class InfoCommand implements Command
{
    ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+"info_en");
    @Override
    public void execute()
    {
        ConsoleHelper.writeMessage(res.getString("before"));
        Collection<CurrencyManipulator> col = CurrencyManipulatorFactory.getAllCurrencyManipulators();

        if (col.isEmpty())
        {
            ConsoleHelper.writeMessage("No money available.");
        }

        boolean hasmoney = false;
            for (CurrencyManipulator cm: col)
            {
                if (cm.hasMoney())
                {
                    ConsoleHelper.writeMessage(cm.getCurrencyCode() +" - " + cm.getTotalAmount());
                    hasmoney = true;

                }
                if (!hasmoney)
                {
                    ConsoleHelper.writeMessage(res.getString("no.money"));
                }
            }


    }

}
