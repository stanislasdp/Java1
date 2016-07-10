package com.javarush.test.level22.lesson09.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

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
    public static void main(String[] args) throws IOException
    {
        String file_name;
        String [] arr =null; ;
        ArrayList<String> words = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in)))
        {
            file_name =  br.readLine();
        }

        try (BufferedReader read = new BufferedReader(new InputStreamReader(new FileInputStream(file_name))))
        {
            while (read.ready())
            {

                arr = read.readLine().split(" ");
            }
        }

        System.out.println(getLine(arr).toString());
        //...

        StringBuilder result = getLine();
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length ; i++)
        {
            sb.append(words[i]);

        }
          return null;
    }
}
