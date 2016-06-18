package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Solution
{   static String id;
    static String productName;
    static String price;
    static String quantity;
    static String fileName;
    static ArrayList<String> file_strings = new ArrayList<>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        fileName = bf.readLine();
        bf.close();
        file_strings = new ArrayList<>();
        Scanner sc = new Scanner(new FileReader(fileName));

        while (sc.hasNext())
        {
            String str = sc.nextLine();
            file_strings.add(str);
        }
        sc.close();


        if (args[0].equals("-u"))
        {
            StringBuilder build = new StringBuilder();
            for (int i = 2; i <= args.length - 3; i++)
            {
                build.append(args[i]);
                build.append(" ");
            }
            id =args[1];
            System.out.println(id);
            productName = build.toString();
            price = args[args.length - 2];
            quantity = args[args.length - 1];
            FileUpdate();

        }
        else if (args[0].equals("-d"))
        {
            id =args[1];
            FileDelete();
        }

    }

    public static void FileUpdate() throws IOException
    {

        for (int i = 0; i <file_strings.size() ; i++)
        {
            String curr_id =file_strings.get(i).substring(0,8);
            if (curr_id.trim().equals(id))
            {
                String curr_string = curr_id+format(productName,30)+format(price,8)+format(quantity,4);
                file_strings.set(i,curr_string);
            }
        }
        WriteToFile();


        }

    public static void FileDelete() throws IOException
    {
        Iterator<String> it =file_strings.iterator();

        while (it.hasNext())
        {
            String curr_id =  it.next().substring(0,8);
            if (curr_id.trim().equals(id))
            {
                it.remove();
            }
        }
        WriteToFile();
    }

    public static void WriteToFile() throws IOException
    {
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileName, false)));
        printWriter.print("");
        for (String i :file_strings)
        {
            printWriter.println(i);
        }
        printWriter.close();
    }


    public static String format(String prevname,int count)
    {
        if (prevname.length()<count)
        {
            for (int i=prevname.length();i<count;i++)
            {
                prevname+=" ";
            }
        }
        else if (prevname.length()>count)
        {
            prevname=prevname.substring(0,count);
        }
        return prevname;
    }




}
