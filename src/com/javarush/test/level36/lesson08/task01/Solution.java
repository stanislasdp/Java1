package com.javarush.test.level36.lesson08.task01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* Использование TreeSet
Первым параметром приходит имя файла: файл1.
файл1 содержит только буквы латинского алфавита, пробелы, знаки препинания, тире, символы перевода каретки.
Отсортировать буквы по алфавиту и вывести на экран первые 5 различных букв в одну строку без разделителей.
Если файл1 содержит менее 5 различных букв, то вывести их все.
Буквы различного регистра считаются одинаковыми.
Регистр выводимых букв не влияет на результат.
Закрыть потоки.

Пример 1 данных входного файла:
zBk yaz b-kN
Пример 1 вывода:
abkny

Пример 2 данных входного файла:
caAC
A, aB? bB
Пример 2 вывода:
abc

Подсказка: использовать TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException
    {
        String fileName = args[0];
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(fileName))))
        {
            Pattern p = Pattern.compile("[a-zA-Z ]");
            TreeSet<Character> characterSet = new TreeSet<>();

            while (bufferedReader.ready())
            {

                String readLine = bufferedReader.readLine().replaceAll("[^a-zA-Z ]|\\s","").toLowerCase().trim();
                for (Character character: readLine.toCharArray())
                {
                    characterSet.add(character);
                }
            }

            for (int i = 0; i <5 ; i++)
            {
                Character character = characterSet.pollFirst();
                if (character != null)
                System.out.print(character);
            }

        }
        catch (IOException io)
        {
            io.printStackTrace();
        }
    }
}
