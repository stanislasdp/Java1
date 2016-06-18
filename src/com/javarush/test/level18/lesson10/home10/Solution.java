package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer,String> files = new TreeMap<Integer,String>();
        String file_assebled="";
        boolean get_file_assembled_name=false;

        while (true)
        {
            String file_part = bf.readLine();
            if (!files.containsValue(file_part) && !file_part.equals("end") )
            {
               int file_int = Integer.parseInt(file_part.substring(file_part.lastIndexOf("part")+4,file_part.length()));//getting file part number
                files.put(file_int,file_part);// put to Treemap file part_number and file_aprt name

                if (!get_file_assembled_name)
                {
                    file_assebled=file_part.substring(0,file_part.lastIndexOf("."));
                    get_file_assembled_name = true;
                }
            }
            else
            {
                break;
            }
        }
        bf.close();


        FileOutputStream fo = new FileOutputStream(file_assebled);

        for (Map.Entry<Integer,String> pair:files.entrySet())
        {
            FileInputStream fi = new FileInputStream(pair.getValue());
            byte [] buff = new byte [fi.available()];
            fi.read(buff);
            fi.close();
            fo.write(buff);
        }

        fo.close();
    }
}
