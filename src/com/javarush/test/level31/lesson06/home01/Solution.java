package com.javarush.test.level31.lesson06.home01;

import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.*;

/* Добавление файла в архив
В метод main приходит список аргументов.
Первый аргумент - полный путь к файлу fileName.
Второй аргумент - путь к zip-архиву.
Добавить файл (fileName) внутрь архива в директорию 'new'.
Если в архиве есть файл с таким именем, то заменить его.

Пример входных данных:
C:/result.mp3
C:/pathToTest/test.zip

Файлы внутри test.zip:
a.txt
b.txt

После запуска Solution.main архив test.zip должен иметь такое содержимое:
new/result.mp3
a.txt
b.txt

Подсказка: нужно сначала куда-то сохранить содержимое всех энтри,
а потом записать в архив все энтри вместе с добавленным файлом.
Пользоваться файловой системой нельзя.
*/
public class Solution
{
    public static void main(String[] args) throws IOException
    {
        String fileToAdd = args[0];
        FileInputStream fi = new FileInputStream(fileToAdd);
        ZipFile zip = new ZipFile(args[1]);

        Map<String,byte[]> zipMap = new HashMap<>();

        Enumeration<? extends ZipEntry> zipEntries = zip.entries();
        while (zipEntries.hasMoreElements())
        {
            ZipEntry currentEntry = zipEntries.nextElement();
            InputStream is = zip.getInputStream(currentEntry);
            byte [] buffer = new byte[is.available()];
            is.read(buffer);
            is.close();
            zipMap.put(currentEntry.getName(),buffer);
        }

        if (zipMap.containsKey(fileToAdd.substring(fileToAdd.lastIndexOf("/")+1)))
        {
            FileOutputStream fo = new FileOutputStream(args[1]);

            for (Map.Entry<String,byte[]> pair:zipMap.entrySet())
            {
                fo.write(pair.getValue());
            }
            fo.close();
        }

        ZipOutputStream zOutStream = new ZipOutputStream(new FileOutputStream(args[1]));
        zOutStream.putNextEntry(new ZipEntry(fileToAdd));
        zOutStream.close();






     ;



    }
}
