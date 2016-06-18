package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first_file_name =br.readLine();
        String second_file_name = br.readLine();
        String third_file_name = br.readLine();
        br.close();

        FileInputStream fi2 = new FileInputStream(second_file_name);
        FileInputStream fi3 = new FileInputStream(third_file_name);
        FileOutputStream fo1 = new FileOutputStream(first_file_name);

        if ((fi2.available())>0 || fi3.available()>0)
        {
            byte[] buffer2 = new byte[fi2.available()];
            byte[] buffer3 = new byte[fi3.available()];
            fi2.read(buffer2);
            fi3.read(buffer3);
            fo1.write(buffer2);
            fo1.write(buffer3);
            fi2.close();
            fi3.close();
            fo1.close();


        }






    }
}
