package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Dish;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by stas on 8/15/16.
 */
public class ConsoleHelper
{
   private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

   public static void writeMessage(String message)
    {
        System.out.println(message);
    }

   public static String readString() throws IOException
    {
        return  br.readLine();

    }

      public static List<Dish> getAllDishesForOrder() throws IOException
     {
         List<Dish> dishes =  new ArrayList<>();
         writeMessage(Dish.allDishesToString());
         while (true)
         {
             writeMessage("Enter dish");
             String dish = readString();
             if (dish.equalsIgnoreCase("exit"))
             {
                 break;
             }
             dishes.add(Dish.valueOf(dish));
         }
         return dishes;
     }

 /*   Задание 2
        1. Мы много работаем с консолью. Пора создать единую точку взаимодействия.
    Создайте класс ConsoleHelper с единственным BufferedReader, через который будете работать с консолью.
        Запомните, этот класс не хранит никаких данных и состояний, поэтому все методы будут статическими.
    Создайте в нем три метода:
        -writeMessage(String message) - для вывода message в консоль
    -String readString() - для чтения строки с консоли
    -List<Dish> getAllDishesForOrder() - просит ползователя выбрать блюдо и добавляет его в список. Введенное 'exit' означает завершение заказа.
    исключения пробрасывайте выше, на этом уровне не понятно, что с ними делать.

        2. Отрефакторьте код - работа с консолью должна быть только через класс ConsoleHelper

    3. Вернемся к классу Order: в нем есть ссылка на планшет, и еще есть список выбранных блюд.
    Создайте поле dishes - список блюд. Инициализируйте его в конструкторе, вызвав метод getAllDishesForOrder из ConsoleHelper.

        4. Перепишите метод toString в классе Order. Пусть он возвращает пустую строку, если нет блюд в заказе, иначе
    вывод должен быть аналогичный примеру в порядке добавления блюд. Используйте ConsoleHelper.
    Пример:
    Your order: [Juice, Fish] of Tablet{number=5}

    5. У нас все завязано на работу с консолью. Однако, при возникновении исключений, наше приложение умрет.
    Чтобы узнать причину - добавим в Tablet статический логгер java.util.logging.Logger, инициализированный именем класса.

    6. В методе createOrder класса Tablet обработаем исключения ввода-вывода.
    Запишем в лог "Console is unavailable.". Уровень лога - SEVERE - это самый серьезный уровень, мы не можем работать.

    7. Надо начинать тестировать наше приложение.
    Добавьте в main создание планшета и создание заказа - new Tablet(5).createOrder();*/
}
