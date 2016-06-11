package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str=reader.readLine();

        String url = str.substring(str.indexOf("?")+1,str.length());

        String [] objarray = url.split("\\&");
        String str1="";
        String[] outarray = new String[objarray.length];
        String [] outobjarray= new String [objarray.length];

        for (int i = 0; i <objarray.length ; i++)
        {
            if (!objarray[i].isEmpty())
            {
                if (!objarray[i].contains("="))
                {

                    str1+=objarray[i]+" ";
                }
                else
                {

                    str1+=objarray[i].substring(0,objarray[i].indexOf("="))+" ";
                }
            }


        }


        System.out.print(str1.trim());
        System.out.println();

        for (int i = 0; i <objarray.length ; i++)
        {

            if (objarray[i].startsWith("obj"))
            {
                outobjarray[i]=objarray[i].substring(objarray[i].indexOf("=")+1,objarray[i].length());
                try
                {
                    alert(Double.parseDouble(outobjarray[i].trim()));


                }
                catch (Exception e)
                {   if (!outobjarray[i].toString().isEmpty())
                    alert(outobjarray[i].trim());
                }

            }


        }


    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
