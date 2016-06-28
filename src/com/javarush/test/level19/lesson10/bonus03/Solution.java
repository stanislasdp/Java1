package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution
{
    static String tag;
    public static void main(String[] args)
    {
        tag = args[0];

        try
        {
            BufferedReader bf  = new BufferedReader(new InputStreamReader(System.in));
            String filename = bf.readLine();
            bf.close();
            FileReader fi = new FileReader(filename);

            StringBuilder sb = new StringBuilder();

            while (fi.ready())
            {
                int ch = fi.read();

                    sb.append((char) ch);

            }
            String all_str = sb.toString();
            List<Integer> start_indexes =new ArrayList<Integer>();
            List<Integer> end_indexes = new ArrayList<Integer>();

            for (int i = 0; i < all_str.toCharArray().length ; i++)
            {
                if (all_str.toCharArray()[i]=='<')
                {
                    start_indexes.add(i);
                    end_indexes.add(null);
                }
                if (all_str.toCharArray()[i]=='>')
                {
                    end_indexes.set(end_indexes.lastIndexOf(null),i);
                }
            }

            for (int k =0;k<start_indexes.size();k++)
            {
                String sub_between_tags = all_str.substring(start_indexes.get(k),end_indexes.get(k)+1);

                System.out.println(sub_between_tags);
            }


        }
        catch (IOException ie)
        {
            ie.printStackTrace();
        }

        String start_tag = "<"+tag;
        String end_tag = "/<"+tag+">";





    }
}
