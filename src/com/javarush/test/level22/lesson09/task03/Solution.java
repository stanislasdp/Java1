package com.javarush.test.level22.lesson09.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution {
    public static void main(String[] args)
    {

        ArrayList<String> arr1 = new ArrayList<String>();
        String file_name= null;
        try
        {
            BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
            file_name = rd.readLine();
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file_name)));
            rd.close();
            while (reader.ready())
            {
                String tmp = reader.readLine();
                arr1.addAll(Arrays.asList(tmp.split(" ")));
            }
            reader.close();
        }
        catch (IOException ie)
        {
            ie.printStackTrace();
        }
        String[] arr_for_method = new String [arr1.size()];

        StringBuilder result = getLine(arr1.toArray(arr_for_method));
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words)
    {
        if (words == null || words.length==0)
        {
            return new StringBuilder();
        }
        if (words.length==1)
        {
            StringBuilder sb = new StringBuilder();
            sb.append(words[0]);
            return  sb;
        }

        ArrayList<String> for_shuffling = new ArrayList<String>();
        ArrayList<String> sorted = new ArrayList<>();
        Collections.addAll(for_shuffling,words);



        while (true)
        {
            int count = 0;

            for (int i = 1; i <for_shuffling.size() ; i++)
            {
                char begin_word = for_shuffling.get(i).toLowerCase().charAt(0);
                char end_word = for_shuffling.get(i-1).toLowerCase().charAt(for_shuffling.get(i-1).length()-1);
                if (begin_word==end_word)
                {
                    count++;
                }

            }
            if (count>=for_shuffling.size()-1)
            {
                break;
            }
            Collections.shuffle(for_shuffling);
        }
          StringBuilder sb = new StringBuilder();

        for (String s: for_shuffling)
        {
            sb.append(s);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return  sb;
    }
}
