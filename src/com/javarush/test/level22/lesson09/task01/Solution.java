package com.javarush.test.level22.lesson09.task01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException
    {
        String file_name;
        Map<String,Integer> map1 = new HashMap<>();
        ArrayList<String> str = new ArrayList<>();
        ArrayList<String> str_reverse = new ArrayList<>();


        try ( BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)))
        {
            file_name =  bf.readLine();
        }

        try (BufferedReader read = new BufferedReader(new InputStreamReader(new FileInputStream(file_name))))
        {
            while (read.ready())
            {


                str.addAll(Arrays.asList(read.readLine().split(" ")));
            }
        }

        for (int i = 0; i <str.size() ; i++)
        {
            StringBuilder sb = new StringBuilder();
           sb.append(str.get(i));
            str_reverse.add(sb.reverse().toString());
        }


        for (int i = 0; i <str.size() ; i++)
        {
            for (int j =i; j< str_reverse.size();j++ )
            {
                if (str.get(i).equals(str_reverse.get(j)) && i!=j)
                {
                    Pair pair = new Pair();
                    pair.first = str.get(i);

                    pair.second  = str.get(j);
                    result.add(pair);
                }

            }
        }

        for (Pair pair: result)
        {
            System.out.println(pair.toString());
        }



    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
