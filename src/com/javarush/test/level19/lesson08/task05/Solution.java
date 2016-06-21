package com.javarush.test.level19.lesson08.task05;

/* Дублируем текст
Считайте с консоли имя файла
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна дублировать вывод всего текста в файл, имя которого вы считали
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток
Закройте поток файла

Пример вывода на экран:
it's a text for testing

Пример тела файла:
it's a text for testing
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException
    {

        PrintStream old_stream = System.out;
        ByteArrayOutputStream bi  =new ByteArrayOutputStream();
        PrintStream pi=new PrintStream(bi);
        System.setOut(pi);
        testString.printSomething();
        String to_file =bi.toString();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String file_name = bf.readLine();
        bf.close();
        FileWriter fw = new FileWriter(file_name);
        fw.write(to_file);
        fw.close();
        System.setOut(old_stream);
        System.out.println(to_file);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

