package com.javarush.test.level19.lesson10.home04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words
Закрыть потоки. Не использовать try-with-resources

Пример: words содержит слова А, Б, В
Строки:
В Б А Д  //3 слова из words, не подходит
Д А Д    //1 слово из words, не подходит
Д А Б Д  //2 слова - подходит, выводим
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader console_reader = new BufferedReader(new InputStreamReader(System.in));
        String file_name = console_reader.readLine();
        console_reader.close();
        BufferedReader br =new BufferedReader(new FileReader(file_name));
        int counter =0;

        while (br.ready())
        {
            String curr_line =br.readLine();
            counter++;
            int amount=0;

            for (int i = 0; i <words.size() ; i++)
            {
                if (curr_line.contains(words.get(i)))
                {
                    amount++;
                }
            }
            if (amount==2)
            {
                System.out.println(curr_line);
            }
        }
        br.close();

    }
}
