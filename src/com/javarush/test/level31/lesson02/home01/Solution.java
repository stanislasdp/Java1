package com.javarush.test.level31.lesson02.home01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

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
public class Solution {
    public static void main(String[] args)
    {
        String directoryPath = args[0];
        String resultFileName = args[1];

        ArrayList<String> fileList = new ArrayList<>();
        ArrayList<String> resultList = new ArrayList<>();
        processDirectories(directoryPath,fileList);

        for (String el :fileList)
        {
            File file = new File(el);
            if (file.length() > 50)
            {
                file.delete();
            }
            else
            {
                resultList.add(el);
            }
        }

        Collections.sort(resultList, new Comparator<String>()
        {
            @Override
            public int compare(String o1, String o2)
            {
                return o1.substring(o1.lastIndexOf("/")).compareTo(o2.substring(o2.lastIndexOf("/")));
            }
            //sorting array by file names excluding preceeded path
        });

        FileOutputStream fileOutputStream;
        try
        {
            File renamedFile = renameFile(new File(resultFileName));
            fileOutputStream = new FileOutputStream(renamedFile);

            for (String el: resultList)
            {
                FileInputStream fileInput = new FileInputStream(new File(el));
                byte [] buffer = new byte[fileInput.available()];
                fileInput.read(buffer);
                fileOutputStream.write(buffer);
                fileOutputStream.write('\n');
                fileInput.close();
            }

        }
        catch (IOException ie)
        {
            ie.printStackTrace();
        }

    }

    //recursive file search
    public static void processDirectories(String directoryPath, List<String> fileNames)
    {
        File file = new File(directoryPath);

        for (File f: file.listFiles())
        {
            if (f.isDirectory())
            {
                if (f.list().length == 0)
                {
                    f.delete();
                }
                else
                {
                    processDirectories(f.getAbsolutePath(),fileNames);
                }
            }
            else
            {
                fileNames.add(f.getAbsolutePath());
            }
        }
    }


    public static File renameFile(File file) throws IOException
    {
        String newFilePath = file.getParentFile().getAbsolutePath()+"/allFilesContent.txt";
        File renamedFile = new File(newFilePath);
        if (renamedFile.exists())
        {
            throw new IOException("file exists");
        }
        file.renameTo(renamedFile);
        return renamedFile;
    }
}
