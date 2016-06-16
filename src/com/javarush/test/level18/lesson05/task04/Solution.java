package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);
        String first_file =reader.readLine();
        String second_file =reader.readLine();
        reader.close();
        in.close();

        FileInputStream fi = new FileInputStream(first_file);
        FileOutputStream fo = new FileOutputStream(second_file);

        int first_file_cnt = fi.available();
        byte [] buffer = new byte[first_file_cnt];
        fi.read(buffer);

        for (int i=buffer.length-1;i>=0;i--)
        {
            fo.write(buffer[i]);
        }
        fi.close();
        fo.close();


    }
}
