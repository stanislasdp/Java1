package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.command.CommandExecutor;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.Locale;

/**
 * Created by stas on 8/6/16.
 */
public class CashMachine
{
    public static void main(String[] args)
    {
        Locale.setDefault(Locale.ENGLISH);
        try
        {
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
          ConsoleHelper.writeMessage("Bye-bye");
        }
    }

    /*   Задание 9
    Сегодня мы займемся командой ExitCommand.
    1. Реализуйте следующую логику в команде ExitCommand:
        1.1. Спросить, действительно ли пользователь хочет выйти - варианты <y,n>.
    1.2. Если пользователь подтвердит свои намерения, то попрощаться с ним.

    Это всё хорошо, но бывают случаи, когда срочно нужно прервать операцию, например, если пользователь ошибся с выбором операции.
    Для этого у нас есть InterruptOperationException.
        2.Реализуйте следующую логику:
        2.1. Если пользователь в любом месте ввел текст 'EXIT' любым регистром, то выбросить InterruptOperationException.
        2.2. Найдите единственное место, куда нужно вставить эту логику. Реализуйте функционал в этом единственном методе.

        3. Заверните тело метода main в try-catch и обработайте исключение InterruptOperationException.
    Попрощайтесь с пользователем в блоке catch используя ConsoleHelper.*/

}
