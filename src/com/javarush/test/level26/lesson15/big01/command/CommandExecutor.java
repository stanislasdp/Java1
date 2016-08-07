package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.Operation;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by stas on 8/7/16.
 */
public class CommandExecutor
{
   private static Map<Operation, Command> commands = new HashMap<Operation,Command>();


    static
    {
        commands.put(Operation.INFO,new InfoCommand());
        commands.put(Operation.DEPOSIT,new DepositCommand());
        commands.put(Operation.WITHDRAW,new WithdrawCommand());
        commands.put(Operation.EXIT, new ExitCommand());
    }

    private CommandExecutor(){}

    public static final void execute(Operation operation)
    {
        commands.get(operation).execute();


    }

//    4.1 Создадим метод public static final void execute(Operation operation), который будет дергать метод execute у нужной команды.
//    Реализуйте эту логику.
//    4.2. Расставьте правильно модификаторы доступа учитывая, что единственная точка входа - это метод execute.
}
