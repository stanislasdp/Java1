package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

/**
 * Created by stas on 8/7/16.
 */
class ExitCommand implements Command
{
    ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+"exit_en");
    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("exit.question.y.n"));
        ConsoleHelper.writeMessage("Are you sure?");

           String answer = ConsoleHelper.readString();
            if (answer.equals(res.getString("yes")))
            {
                ConsoleHelper.writeMessage(res.getString("thank.message"));
            }
            else if ("n".equals(answer))
            {
                CommandExecutor.execute(ConsoleHelper.askOperation());
            }





    }


}
