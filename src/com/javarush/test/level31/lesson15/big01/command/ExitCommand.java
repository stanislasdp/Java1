package com.javarush.test.level31.lesson15.big01.command;

/**
 * Created by stas on 9/19/16.
 */
import com.javarush.test.level31.lesson15.big01.ConsoleHelper;

public class ExitCommand implements Command
{
    @Override
    public void execute() throws Exception
    {
        ConsoleHelper.writeMessage("До встречи!");
    }
}