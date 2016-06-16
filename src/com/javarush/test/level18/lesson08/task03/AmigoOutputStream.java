package com.javarush.test.level18.lesson08.task03;

import java.io.*;
import java.nio.channels.FileChannel;

/* AmigoOutputStream
1 Измените класс AmigoOutputStream так, чтобы он стал Wrapper-ом для класса FileOutputStream. Используйте наследование.
2 При вызове метода close() должны выполняться следующая последовательность действий:
2.1 вызвать метод flush()
2.2 дописать следующий текст [JavaRush © 2012-2013 All rights reserved.], используйте метод getBytes()
2.3 закрыть поток методом close()
*/

public class AmigoOutputStream extends FileOutputStream
{
    public static String fileName = "/home/stas/workspace/3.txt";

    private FileOutputStream fi;

    public AmigoOutputStream(FileOutputStream fi) throws IOException
    {
        super(fileName);
        this.fi=fi;


    }


    @Override
    public void write(int b) throws IOException
    {
        fi.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException
    {
        fi.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException
    {
        fi.write(b, off, len);
    }

    @Override
    public FileChannel getChannel()
    {
        return fi.getChannel();
    }

    @Override
    protected void finalize() throws IOException
    {
        super.finalize();
    }

    @Override
    public void close() throws IOException
    {
            fi.flush();
            fi.write("JavaRush © 2012-2013 All rights reserved.".getBytes());
            fi.close();
    }


    public static void main(String[] args) throws FileNotFoundException,IOException
    {
       // new AmigoOutputStream(new FileOutputStream(fileName));
        AmigoOutputStream am = new AmigoOutputStream(new FileOutputStream(fileName));
        am.close();
    }

}

