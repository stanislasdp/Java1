package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bf = new BufferedReader(inputStreamReader);
        String filename=bf.readLine();



        OutputStream outStream = new FileOutputStream (filename);

        while(true)
        {
            String str =bf.readLine();
            outStream.write((str+"\n").getBytes());
            if ("exit".equals(str))
            {
                break;
            }
        }
        bf.close();
        outStream.close();

    }
}
