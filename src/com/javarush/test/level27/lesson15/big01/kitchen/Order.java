package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by stas on 8/15/16.
 */
public class Order
{

   private List<Dish> dishes;
   private Tablet tablet;




    public Order(Tablet tablet) throws IOException
    {
        dishes = ConsoleHelper.getAllDishesForOrder();
        this.tablet= tablet;
    }

    @Override
    public String toString()
    {
        String ret = "";
        if (dishes.isEmpty())
    {
        return ret;
    }
        else
        {
                ret= String.format("Your order: %s of %s",dishes.toString(),tablet.toString());
        }
        return ret;


    }
}

/*3. Вернемся к классу Order: в нем есть ссылка на планшет, и еще есть список выбранных блюд.
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
