package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String file_name_first = bf.readLine();
        String file_name_second = bf.readLine();
        bf.close();
        StringBuffer sb = new StringBuffer();
        FileReader fi = new FileReader(file_name_first);
        FileWriter fw = new FileWriter(file_name_second);

        while (fi.ready())
        {
            char ch = (char) fi.read();
            sb.append(ch);


        }
        fi.close();
        String result = sb.toString();
        String [] splitted = result.split("\\s");

        ArrayList<String> arr1 = new ArrayList<String>();

        for (int i = 0; i <splitted.length ; i++)
        {
            if (splitted[i].matches("[0-9]+"))
            {
                arr1.add(splitted[i]+(i==splitted.length-1?"":" "));
            }
        }

        for (String i: arr1)
        {
            fw.write(i);
        }
        fw.close();




    }
}
