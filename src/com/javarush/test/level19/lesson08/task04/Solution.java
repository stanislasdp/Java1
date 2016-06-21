package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args)
    {
        PrintStream old_stream = System.out;
        ByteArrayOutputStream bi  =new ByteArrayOutputStream();
        PrintStream pi=new PrintStream(bi);
        System.setOut(pi);
        testString.printSomething();
        String init = bi.toString();
        Integer r = 0;


        if (init.contains("+"))
        {

            r=Integer.parseInt(init.substring(0,init.indexOf("+")-1))+Integer.parseInt(init.substring(init.lastIndexOf("+")+2,init.indexOf("=")-1));
        }
        else if (init.contains("-"))
        {
            r=Integer.parseInt(init.substring(0,init.indexOf("-")-1))-Integer.parseInt(init.substring(init.lastIndexOf("-")+2,init.indexOf("=")-1));
        }
        else if (init.contains("*"))
        {
            r=Integer.parseInt(init.substring(0,init.indexOf("*")-1))*Integer.parseInt(init.substring(init.lastIndexOf("*")+2,init.indexOf("=")-1));
        }

      //  bi.reset();
        System.out.println(r);
        String result = bi.toString();

        System.setOut(old_stream);

        System.out.println(result);


    }

    public static class TestString {
        public void printSomething() {
            System.out.println("6 * 9 = ");
        }
    }
}

