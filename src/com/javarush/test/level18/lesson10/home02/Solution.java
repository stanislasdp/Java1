package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        FileInputStream fi = new FileInputStream(args[0]);
        int space_countter = 0;
        if (fi.available()>0)
        {
            byte [] buffer = new byte[fi.available()];
            int  symbols_counter =buffer.length;
            fi.read(buffer);
            fi.close();
            for (int i = 0; i <buffer.length ; i++)
            {

                if (buffer[i]==32)
                {
                    space_countter++;
                }
            }

            double result = (double)(space_countter)/symbols_counter*100;
            System.out.println(Math.round(result*100.00)/100.00);

        }

    }
}
