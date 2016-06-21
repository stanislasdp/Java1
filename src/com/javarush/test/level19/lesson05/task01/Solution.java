package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String first_file = bf.readLine();
        String second_file = bf.readLine();
        bf.close();

        FileReader fi = new FileReader(first_file);
        FileWriter fw = new FileWriter(second_file);
        int counter=0;
        while (fi.ready())
        {

            int curr_byte =fi.read();
            counter++;
            if (counter%2==0)
            {
                fw.write(curr_byte);
            }

        }
        fi.close();
        fw.close();


    }
}
