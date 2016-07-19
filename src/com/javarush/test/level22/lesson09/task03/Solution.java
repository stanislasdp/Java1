package com.javarush.test.level22.lesson09.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
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

            for (int i = 0; i <for_shuffling.size() ; i++)
            {
                char end_word = for_shuffling.get(i).toLowerCase().charAt(for_shuffling.get(i).length()-1);
                String to_compare = null;
                if (i!=for_shuffling.size()-1)
                {
                    to_compare = for_shuffling.get(i+1).toLowerCase();
                }
                else
                {
                    to_compare = for_shuffling.get(0).toLowerCase();
                }
                char begin_word = to_compare.charAt(0);

                if (begin_word==end_word)
                {

                    count++;
                    //sorted.add(for_shuffling.get(i));
                    //System.out.println(sorted.get(i));
//                    sorted.add(for_shuffling.get(i+1));
                    //for_shuffling.remove(i+1);
                    //for_shuffling.trimToSize();
                }

            }
            if (count>=for_shuffling.size())
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
