package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bf = new BufferedReader(inputStreamReader);
        String filename = bf.readLine();
        bf.close();

        ArrayList<Integer> arr_integer = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filename));

        String str = br.readLine();


        while (str != null)
        {
            int curr = Integer.parseInt(str);

            if (curr % 2 == 0)
            {
                arr_integer.add(curr);
            }
            str = br.readLine();
        }

        arr_integer=Solution.bubble_sorting(arr_integer);
        for (Integer i:arr_integer)
        {

            System.out.println(i);

        }
    }

        public static ArrayList<Integer> bubble_sorting(ArrayList<Integer> arr)
        {
            for (int i=0;i<arr.size();i++)
            {
                for (int j=0;j<arr.size()-i-1;j++)
                {
                    if (arr.get(j)>arr.get(j+1))
                    {
                        int tmp=arr.get(j+1);
                        arr.set(j+1,arr.get(j));
                        arr.set(j,tmp);

                    }
                }

            }
            return  arr;
        }




    }

