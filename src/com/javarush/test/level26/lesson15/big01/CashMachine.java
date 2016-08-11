package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.command.CommandExecutor;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by stas on 8/6/16.
 */
public class CashMachine
{

    public static final String RESOURCE_PATH = "com.javarush.test.level26.lesson15.big01.resources.";
    public static void main(String[] args)
    {
        Locale.setDefault(Locale.ENGLISH);

        try
        {
            CommandExecutor.execute(Operation.LOGIN);



            Operation op;
            do
            {
                op = ConsoleHelper.askOperation();

                CommandExecutor.execute(op);
            }
            while (op!=Operation.EXIT);
        }
        catch (InterruptOperationException ie)
        {

        }
    }

}
