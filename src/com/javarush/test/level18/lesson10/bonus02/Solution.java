package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

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
import java.util.Scanner;


public class Solution
{
    static String productName;
    static String price;
    static String quantity;

    public static void main(String[] args) throws Exception
    {
        if (args[0].equals("-c"))
        {
            StringBuilder build= new StringBuilder();

            for (int i =1;i<=args.length-3;i++)
            {
                build.append(args[i]);
                build.append(" ");
            }
            productName=build.toString();
            price = args[args.length-2];
            quantity= args[args.length-1];
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            String file_name = bf.readLine();
            bf.close();
            FileWrite(file_name);
        }
    }

    public static int NextId(String filename) throws IOException
    {
        Scanner scan = new Scanner(new FileReader(filename));
        ArrayList<String> strokes = new ArrayList<String>();

        while (scan.hasNext())
        {
            strokes.add(scan.nextLine());
        }
       scan.close();
        int mx_id=Integer.parseInt(strokes.get(0).substring(0,8).trim());
        for (String s:strokes)
        {
            if (Integer.parseInt(s.substring(0,8).trim())>mx_id)
            {
                mx_id=Integer.parseInt(s.substring(0,8).trim());
            }
        }
        mx_id++;
        return mx_id;
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

    public static void FileWrite(String fileName) throws IOException
    {
        String id=NextId(fileName)+"";
        id=format(id,8);
        productName=format(productName,30);
        price=format(price,8);
        quantity = format(quantity,4);
        String result_str = id+productName+price+quantity;
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true)));
        printWriter.println(result_str);
        printWriter.close();
    }




}
