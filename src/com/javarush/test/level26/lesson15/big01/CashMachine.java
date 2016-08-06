package com.javarush.test.level26.lesson15.big01;

import java.util.Locale;

/**
 * Created by stas on 8/6/16.
 */
public class CashMachine
{
    public static void main(String[] args)
    {
        Locale.setDefault(Locale.ENGLISH);
       String currency = ConsoleHelper.askCurrencyCode();
        //System.out.println(currency);
        String[] value_amount =ConsoleHelper.getValidTwoDigits(currency);
        CurrencyManipulator cm = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currency);
        cm.addAmount(Integer.parseInt(value_amount[0]),Integer.parseInt(value_amount[1]));

/*
        Задание 4
        1. Выберем операцию, с которой мы сможем начать.
        Подумаем. В банкомате еще денег нет, поэтому INFO и WITHDRAW протестить не получится.
        Начнем с операции DEPOSIT - поместить деньги.
            Считаем с консоли код валюты, потом считаем номинал и количество банкнот, а потом добавим их в манипулятор.*/

    /*    5. Пора уже увидеть приложение в действии.
        В методе main захардкодь логику пункта 1.
        Кстати, чтобы не было проблем с тестами на стороне сервера, добавь в метод main первой строчкой Locale.setDefault(Locale.ENGLISH);
        Запускаем, дебажим, смотрим.*/
    }
}
