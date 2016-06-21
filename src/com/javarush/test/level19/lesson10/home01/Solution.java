package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException
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

        for (Map.Entry<String,Double> pair: treeMap.entrySet())
        {
            System.out.println(pair.getKey()+" "+pair.getValue());
        }


    }
}
