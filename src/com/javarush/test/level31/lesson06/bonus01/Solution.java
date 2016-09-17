package com.javarush.test.level31.lesson06.bonus01;

import java.io.*;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* Разархивируем файл
В метод main приходит список аргументов.
Первый аргумент - имя результирующего файла resultFileName, остальные аргументы - имена файлов fileNamePart.
Каждый файл (fileNamePart) - это кусочек zip архива. Нужно разархивировать целый файл, собрав его из кусочков.
Записать разархивированный файл в resultFileName.
Архив внутри может содержать файл большой длины, например, 50Mb.
Внутри архива может содержаться файл с любым именем.

Пример входных данных. Внутри архива находится один файл с именем abc.mp3:
C:/result.mp3
C:/pathToTest/test.zip.003
C:/pathToTest/test.zip.001
C:/pathToTest/test.zip.004
C:/pathToTest/test.zip.002
*/
public class Solution {
    public static void main(String[] args)
    {
       ZipFilesContainer zipParts = getZipContainer();

        for (int i = 1; i <args.length ; i++)
        {
           zipParts.addFilePart(args[i]);
        }
        zipParts.sortFiles();

        try
        {
            Enumeration< ? extends InputStream> en = Collections.enumeration(Arrays.asList(zipParts.getInputStreams()));
            ZipInputStream so = new ZipInputStream(new SequenceInputStream(en));
            writeToFile(so,args[0]);

        }
        catch (IOException ie)
        {
            ie.printStackTrace();
        }

    }


    public static void writeToFile(ZipInputStream zi,String fileName) throws IOException
    {
        File file = new File(fileName);
        file.createNewFile();
        BufferedOutputStream bo = new BufferedOutputStream(new FileOutputStream(file));
        ZipEntry zipEntry = null;
        while ((zipEntry =zi.getNextEntry()) != null)
        {
            final int bufferSize = 1024;
            byte[] buffer = new byte[bufferSize];

            for (int readBytes = -1;(readBytes = zi.read(buffer,0,bufferSize)) > -1;)
            {
                bo.write(buffer,0,readBytes);
            }
        }
        zi.close();
        bo.close();
    }

    public static ZipFilesContainer getZipContainer()
    {
        return new ZipFilesContainer();
    }

    private static class ZipFilesContainer
    {
        private LinkedList<File> files = new LinkedList<>();

        private void sortFiles ()
        {
            Collections.sort(files, new Comparator<File>()
            {
                @Override
                public int compare(File o1, File o2)
                {
                    String firstName = o1.getName();
                    String secondName = o2.getName();
                    return firstName.substring(firstName.lastIndexOf(".")).compareTo(secondName.substring(secondName.lastIndexOf(".")));
                }
            });
        }

        private void addFilePart(String filePartName)
        {
            files.add(new File(filePartName));

        }

        private FileInputStream[] getInputStreams () throws IOException
        {
            FileInputStream[] fisArr = new FileInputStream[files.size()];

            for (int i = 0; i <files.size() ; i++)
            {
                fisArr[i] = new FileInputStream(files.get(i));
            }

            return  fisArr;
        }


    }
}
