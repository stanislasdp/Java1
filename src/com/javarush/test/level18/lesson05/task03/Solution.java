package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);
        String file_first =reader.readLine();
        String file_second =reader.readLine();
        String file_third =reader.readLine();
        reader.close();
        in.close();

        FileInputStream file_first_stream =new FileInputStream(file_first);
        FileOutputStream file_second_stream =new FileOutputStream(file_second);
        FileOutputStream file_third_stream =new FileOutputStream(file_third);
        int counter = file_first_stream.available();

        if (counter>0)
        {
            byte [] buffer = new byte[counter];
            System.out.println(counter);
            System.out.println(counter-(counter/2+1));
            file_first_stream.read(buffer);
            if (counter%2==0)
            {
                file_second_stream.write(buffer,0,counter/2);
                file_third_stream.write(buffer,counter/2,counter/2);

            }
            else
            {
                file_second_stream.write(buffer,0,counter/2+1);
                file_third_stream.write(buffer,counter/2+1,counter-(counter/2+1));
            }
        }
           file_first_stream.close();
           file_second_stream.close();
           file_third_stream.close();

    }
}
