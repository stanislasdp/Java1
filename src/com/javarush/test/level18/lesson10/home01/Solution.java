package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args)  throws IOException
    {
        FileInputStream fi = new FileInputStream(args[0]);
        int eng_letters_counter = 0;
        Character curr_letter =null;

        while (fi.available()>0)
        {
            curr_letter=(char)fi.read();
            if (curr_letter.toString().matches("[a-zA-Z]"))
            {
                eng_letters_counter++;
            }
        }
        fi.close();
        System.out.println(eng_letters_counter);

    }
}
