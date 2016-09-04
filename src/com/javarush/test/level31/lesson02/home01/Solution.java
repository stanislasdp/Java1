package com.javarush.test.level31.lesson02.home01;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* Проход по дереву файлов
1. На вход метода main подаются два параметра.
Первый - path - путь к директории, второй - resultFileAbsolutePath - имя файла, который будет содержать результат.
2. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
2.1. Если у файла длина в байтах больше 50, то удалить его.
2.2. Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
2.2.1. отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке
2.2.2. переименовать resultFileAbsolutePath в 'allFilesContent.txt'
2.2.3. в allFilesContent.txt последовательно записать содержимое всех файлов из п. 2.2.1. Тела файлов разделять "\n"
2.3. Удалить директории без файлов (пустые).
Все файлы имеют расширение txt.
*/
public class Solution
{

    public static void main(String[] args)
    {
        String directoryPath = args[0];
        File resultFile = new File(args[1]);

        File reNamedFile = new File(resultFile.getParent()+"/allFilesContent.txt");
        resultFile.renameTo(reNamedFile);

        ArrayList<String> fileNames = new ArrayList<>();

        removeFilesWithConditions(directoryPath);
        Collections.sort(fileNames, new Comparator<String>()
        {
            @Override
            public int compare(String o1, String o2)
            {
                return o1.substring(o1.lastIndexOf("/")).compareTo(o2.substring(o2.lastIndexOf("/")));
            }
        });

        try
        {
            FileWriter fileWriter = new FileWriter(reNamedFile);
            for (String toFile: fileNames)
            {
                File file = new File(toFile);
                FileReader fileRead = new FileReader(file);
                while (!fileRead.ready())
                {
                   fileWriter.write();
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }



      /*  for (String str: fileNames)
        {
            System.out.println(str);
        }*/



    }

    public static void removeFilesWithConditions(String filePath)
    {
        File file = new File(filePath);

        if (file.isDirectory())
        {
            for (File f: file.listFiles())
            {
                if (f.isDirectory())
                {
                    removeFilesWithConditions(f.getAbsolutePath());
                }
                if (f.length()>50)
                {
                   f.delete();
                }
                else
                {
                    fileNames.add(f.getAbsolutePath());
                }
            }
        }

    }
}
