package com.javarush.test.level31.lesson02.home02;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/* Находим все файлы
Реализовать логику метода getFileTree, который должен в директории root найти список всех файлов включая вложенные.
Используйте очередь, рекурсию не используйте.
Верните список всех путей к найденным файлам, путь к директориям возвращать не надо.
Путь должен быть абсолютный.
*/
public class Solution
{
    public static List<String> getFileTree(String root) throws IOException
    {
        LinkedList<File> qu = new LinkedList<>();
        List<String> result = new LinkedList<>();
        File file = new File(root);
        qu.add(file);
        //add rooyt file to the queue
        do
        {                //get first element from the queue
            for (File f: qu.peekFirst().listFiles())
            {
                if (f.isFile())
                {
                    result.add(f.getAbsolutePath());
                }

                else
                {
                    qu.offer(f);
                    //add directory to the tail of queue
                }
            }
            file = qu.remove();
            //retrieves and removes first element from queue
            //
        }
        while (!qu.isEmpty());
        return result;
    }

    public static void main(String[] args) throws IOException
    {
        List<String> list = getFileTree("/home/stas/test");

        for (String el: list)
        {
            System.out.println(el);
        }
    }
}
