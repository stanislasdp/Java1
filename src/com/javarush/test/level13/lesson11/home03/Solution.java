package com.javarush.test.level13.lesson11.home03;

/* Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть освободить ресурсы. Закрыть поток чтения с файла и поток ввода с клавиатуры.
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
        bf.close();

        InputStream instr =new FileInputStream(filename);
        while(instr.available()>0)
        {
            System.out.print((char)instr.read());
        }
        instr.close();


    }
}
