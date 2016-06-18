package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first_file_name =br.readLine();
        String second_file_name = br.readLine();
        br.close();

        FileInputStream fi1 = new FileInputStream(first_file_name);
        FileInputStream fi2 = new FileInputStream(second_file_name);
        byte [] buffer1 = new byte[fi1.available()];
        byte [] buffer2 = new byte[fi2.available()];
        fi1.read(buffer1);
        fi2.read(buffer2);
        FileOutputStream fo1 = new FileOutputStream(first_file_name);

        fo1.write(buffer2);
        fo1.write(buffer1);

        fi1.close();
        fi2.close();
        fo1.close();



    }
}
