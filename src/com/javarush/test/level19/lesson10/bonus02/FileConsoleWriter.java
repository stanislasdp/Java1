package com.javarush.test.level19.lesson10.bonus02;

/* Свой FileWriter
Реализовать логику FileConsoleWriter
Должен наследоваться от FileWriter
При записи данных в файл, должен дублировать эти данные на консоль
*/

import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter extends FileWriter
{

    public FileConsoleWriter(String fileName) throws IOException
    {
        super(fileName);
    }

    @Override
    public void write(int c) throws IOException
    {
        System.out.println((char)c);
        super.write(c);

    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException
    {

        StringBuilder sb = new StringBuilder();
        for (char c:cbuf)
        {
            sb.append(c);
        }
        String s= sb.toString();
        System.out.println(s.substring(off,off+len));
        super.write(cbuf, off, len);
    }

    @Override
    public void write(String str, int off, int len) throws IOException
    {
        System.out.println(str.substring(off,len-off));
        super.write(str, off, len);
    }


    public static void main(String[] args) throws IOException
    {
        FileConsoleWriter fc = new FileConsoleWriter("/home/stas/test/output.txt");
        fc.write("str");
        fc.write("stringgg",1,5);
        fc.write(46);
        char [] ch = new  char[]{88,89,90,91,92,93,94,95};
        fc.write(ch);
        fc.write(ch,1,3);
        fc.close();
    }

}
