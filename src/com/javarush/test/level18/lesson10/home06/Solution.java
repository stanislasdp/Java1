package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args)  throws FileNotFoundException,IOException
    {
        FileInputStream fi = new FileInputStream(args[0]);
        TreeMap<Byte, Integer> resultMap = new TreeMap<>();

        if (fi.available()>0)
        {
            byte [] buffer = new byte[fi.available()];
            fi.read(buffer);
            fi.close();

            for (int i = 0; i <buffer.length ; i++)
            {
                if (!resultMap.containsKey(buffer[i]))
                {
                    resultMap.put(buffer[i],1);
                }
                else
                {
                    resultMap.put(buffer[i],resultMap.get(buffer[i])+1);
                }
            }

            for (Map.Entry<Byte,Integer> pair:resultMap.entrySet())
            {
               byte symb = pair.getKey();
                System.out.println((char)symb+" "+pair.getValue());
            }

        }



    }
}
