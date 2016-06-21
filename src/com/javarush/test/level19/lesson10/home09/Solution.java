package com.javarush.test.level19.lesson10.home09;

/* Контекстная реклама
В методе main подмените объект System.out написанной вами реадер-оберткой
Ваша реадер-обертка должна выводить на консоль контекстную рекламу после каждого второго println-а
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Рекламный текст: "JavaRush - курсы Java онлайн"

Пример вывода:
first
second
JavaRush - курсы Java онлайн
third
fourth
JavaRush - курсы Java онлайн
fifth
*/

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args)
    {
        PrintStream old_stream = System.out;
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        PrintStream pi = new PrintStream(new PrintContext(bo));
        System.setOut(pi);
        testString.printSomething();
        String result = bo.toString();
        System.setOut(old_stream);
        System.out.println(result);



    }

    public static class TestString
    {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }

    public static class PrintContext extends OutputStream
    {
        OutputStream oi;
        String context = "JavaRush - курсы Java онлайн";
        int counter=1;

        public PrintContext(OutputStream out)
        {
            this.oi = out;
        }

        @Override
        public void write(int b) throws IOException
        {

            oi.write(b);
            if (b==10)
            {
                counter++;
            }

            if (counter%3==0)
            {
                counter=1;
                oi.write(context.getBytes());
                oi.write(10);
            }

        }
    }
}
