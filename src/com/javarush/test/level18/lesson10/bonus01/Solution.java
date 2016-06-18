package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        String fileName =args[1];
        String fileOutputName = args[2];
        if (args[0].equals("-e"))
        {
            EnCode(fileName,fileOutputName);
        }
        else if (args[0].equals("-d"))
        {
            Decode(fileName,fileOutputName);
        }
    }


    public static void EnCode(String fileName,String fileOutputName) throws IOException
    {
        FileInputStream fi = new FileInputStream(fileName);
        FileOutputStream fo = new FileOutputStream(fileOutputName);

        byte[] buffer = new byte[fi.available()];
        fi.read(buffer);
        fi.close();

        for (int i = 0; i <buffer.length ; i++)
        {
            buffer[i]=(byte)(buffer[i]+1);
        }
        System.out.println("works");
        fo.write(buffer);
        fo.close();

    }

    public  static void Decode(String fileName,String fileOutputName) throws IOException
    {
        FileInputStream fi = new FileInputStream(fileName);
        FileOutputStream fo = new FileOutputStream(fileOutputName);

        byte[] buffer = new byte[fi.available()];
        fi.read(buffer);
        fi.close();

        for (int i = 0; i <buffer.length ; i++)
        {
            buffer[i]=(byte)(buffer[i]-1);
        }
        fo.write(buffer);
        fo.close();

    }

}
