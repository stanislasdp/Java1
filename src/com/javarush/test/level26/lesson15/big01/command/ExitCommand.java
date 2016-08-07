package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

/**
 * Created by stas on 8/7/16.
 */
class ExitCommand implements Command
{
    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage("Are you sure?");

           String answer = ConsoleHelper.readString();
            if (answer.equals("y"))
            {
                ConsoleHelper.writeMessage("Say Goodye");
            }
            else if ("n".equals(answer))
            {
                CommandExecutor.execute(ConsoleHelper.askOperation());
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
