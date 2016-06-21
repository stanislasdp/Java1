package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args)  throws IOException
    {

        BufferedReader br =new BufferedReader(new FileReader(args[0]));
        Map<String,Double> treeMap = new TreeMap<>();

        while (br.ready())
        {
            String tmp =br.readLine();
            String name =tmp.substring(0,tmp.indexOf(" "));
            double value = Double.parseDouble(tmp.substring(tmp.lastIndexOf(" ")+1,tmp.length()));

            if (!treeMap.containsKey(name))
            {
                treeMap.put(name,value);
            }
            else
            {
                treeMap.put(name,treeMap.get(name)+value);
            }
        }
        br.close();


        double max_value =0;
        for (Map.Entry<String,Double> pair: treeMap.entrySet())
        {
            if (pair.getValue()>max_value)
            {
                max_value=pair.getValue();
            }
        }

        for (Map.Entry<String,Double> pair: treeMap.entrySet())
        {
            if (pair.getValue().equals(max_value))
            {
                System.out.println(pair.getKey());
            }
        }



    }
}
