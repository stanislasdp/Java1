package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.Enumeration;
import java.util.ResourceBundle;

/**
 * Created by stas on 8/10/16.
 */
public class LoginCommand implements Command
{
    private ResourceBundle resource = ResourceBundle.getBundle("resources.verifiedCards");


    @Override
    public void execute() throws InterruptOperationException
    {
        final String harcodednumber = "123456789012";
        final String harcodedpin = "1234";

        while(true)
        {
            String askcardnumber= ConsoleHelper.readString();
            String askpin = ConsoleHelper.readString();

            if (!askcardnumber.matches("\\d+") || askcardnumber.length()!=12 || !askpin.matches("\\d+") || askpin.length()!=4 )
            {
                ConsoleHelper.writeMessage("Incorrect card number");
                continue;
            }

            Enumeration<String> keys = resource.getKeys();
            while (keys.hasMoreElements())
            {
                String cardnumber = keys.nextElement();
                String pin =
            }


            if (!askcardnumber.equals(harcodednumber) || !askpin.equals(harcodedpin) )
            {
                ConsoleHelper.writeMessage("Entered data don't correspond valid values");
            }
            else
            {
                break;
            }
        }
        System.out.println("Verification is successful");
    }

}

/*Задание 12
        В задании 11 мы захардкодили номер кредитной карточки с пином, с которыми разрешим работать нашему банкомату.
        Но юзеров может быть много. Не будем же мы их всех хардкодить! Если понадобится добавить еще одного пользователя,
        то придется передеплоить наше приложение. Есть решение этой проблемы.

        Смотри, добавился новый пакет resources, в котором мы будем хранить наши ресурсные файлы.
        В этом пакете есть файл verifiedCards.properties, в котором заданы карточки с пинами.

        1. В LoginCommand добавь поле private ResourceBundle validCreditCards.
        При объявлении инициализируй это поле данными из файла verifiedCards.properties.
        Почитай в инете, как это делается для ResourceBundle.

        2. Замени хардкоженные данные кредитной карточки и пина на проверку наличия данных в ресурсе verifiedCards.properties.

        3. Добавь обработку команды LoginCommand в начало нашего main внутрь блока try-catch*/
