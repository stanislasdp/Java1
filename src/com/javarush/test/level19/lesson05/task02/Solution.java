package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String first_file = bf.readLine();
        bf.close();

        FileReader fi = new FileReader(first_file);

        String read_string="";
        while (fi.ready())
        {
            read_string+=(char)fi.read();
        }
        fi.close();

        //Pattern pattern = Pattern.compile("!\\w+");

        String [] splitted =read_string.split("[^\\w']+");
        int world_counter =0;
        for (int i = 0; i <splitted.length ; i++)
        {
            if (splitted[i].equals("world"))
            {
                world_counter++;
            }
        }
        System.out.println(world_counter);


    }
}
