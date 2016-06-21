package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args)  throws IOException
    {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String first_file = bf.readLine();
        String second_file = bf.readLine();
        bf.close();

        FileReader read1 = new FileReader(first_file);
        FileWriter write1 = new FileWriter(second_file);

        while (read1.ready())
        {
            int data = read1.read();
            if (data==46)
            {
                write1.write(33);
            }
            else
            {
                write1.write(data);
            }
        }

        read1.close();
        write1.close();
        }


}
