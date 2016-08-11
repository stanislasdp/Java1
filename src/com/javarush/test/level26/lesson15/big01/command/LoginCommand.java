package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.Enumeration;
import java.util.ResourceBundle;

/**
 * Created by stas on 8/10/16.
 */
public class LoginCommand implements Command
{
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+"verifiedCards");
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+"login_en");


    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("before"));
        ConsoleHelper.writeMessage(res.getString("specify.data"));

        String askcardnumber="";

        while(true)
        {
            askcardnumber= ConsoleHelper.readString();
            String askpin = ConsoleHelper.readString();
            if (!askcardnumber.matches("\\d+") || askcardnumber.length()!=12 || !askpin.matches("\\d+") || askpin.length()!=4 )
            {
                ConsoleHelper.writeMessage(String.format(res.getString("try.again.with.details"),askcardnumber));
                continue;
            }

            if (validCreditCards.containsKey(askcardnumber) && askpin.equals(validCreditCards.getString(askcardnumber)))
            {
               break;
            }
            else
            {
                ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"),askcardnumber));
                ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
            }
           ;

        }

        ConsoleHelper.writeMessage(String.format(res.getString("success.format"),askcardnumber));
    }

}

/*
+before=Logging in...
     +   specify.data=Please specify your credit card number and pin code or type 'EXIT' for exiting.
       + success.format=Credit card [%s] is verified successfully!
      +  not.verified.format=Credit card [%s] is not verified.
        try.again.or.exit=Please try again or type 'EXIT' for urgent exiting
        try.again.with.details=Please specify valid credit card number - 12 digits, pin code - 4 digits.
*/


