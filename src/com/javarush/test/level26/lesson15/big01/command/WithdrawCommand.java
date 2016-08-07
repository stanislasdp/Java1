package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

/**
 * Created by stas on 8/7/16.
 */
class WithdrawCommand implements Command
{

    @Override
    public void execute() throws InterruptOperationException
    {
        String currency = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currency);

        String sum = "";
        while (true)
        {
            ConsoleHelper.writeMessage("Enter amount");
          sum = ConsoleHelper.readString();

           if (!sum.matches("\\d+")  )
           {
               ConsoleHelper.writeMessage("Incorrect data");
               continue;
           }

           if (currencyManipulator.isAmountAvailable(Integer.parseInt(sum)))
           {
               ConsoleHelper.writeMessage("Incorrect data");
           }
           else
           {
               break;
           }
        }


 /*       1. Реализуйте следующий алгоритм для команды WithdrawCommand:
        1.1. Считать код валюты (метод уже есть)
        1.2. Получить манипулятор для этой валюты.
        1.3. Пока пользователь не введет корректные данные выполнять:
        1.3.1. Попросить ввести сумму
        1.3.2. Если введены некорректные данные, то сообщить об этом пользователю и вернуться к п. 1.3.
        1.3.3. Проверить, достаточно ли средств на счету.
        Для этого в манипуляторе создайте метод boolean isAmountAvailable(int expectedAmount), который вернет true, если денег достаточно для выдачи.
        Если недостаточно, то вернуться к п. 1.3.
        1.3.4. Списать деньги со счета. Для этого в манируляторе создайте метод
        Map<Integer, Integer> withdrawAmount(int expectedAmount), который вернет карту Map<номинал, количество>.
        Подробно логику этого метода смотрите в п.2.
        1.3.5. Вывести пользователю результат из п. 1.3.4. в следующем виде:
        <табуляция>номинал - количество
        Сортировка - от большего номинала к меньшему.
        Вывести сообщение об успешной транзакции.
        1.3.6. Перехватить исключение NotEnoughMoneyException, уведомить юзера о нехватке банкнот и вернуться к п. 1.3.*/
    }


}
