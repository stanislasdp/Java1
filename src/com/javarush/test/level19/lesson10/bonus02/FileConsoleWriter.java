package com.javarush.test.level19.lesson10.bonus02;

/* Свой FileWriter
Реализовать логику FileConsoleWriter
Должен наследоваться от FileWriter
При записи данных в файл, должен дублировать эти данные на консоль
*/

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter extends FileWriter
{
    FileWriter fw;
    FileDescriptor fd;



    public FileConsoleWriter(String fileName, FileWriter fw) throws IOException
    {
        super(fileName);
        this.fw = fw;
    }

    @Override
    public void write(int c) throws IOException
    {
        super.write(c);
        System.out.println(c);
    }
}
