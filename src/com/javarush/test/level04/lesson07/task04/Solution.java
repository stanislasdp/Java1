package com.javarush.test.level04.lesson07.task04;

/* Положительные и отрицательные числа
Ввести с клавиатуры три целых числа. Вывести на экран количество положительных и количество отрицательных чисел в исходном наборе,
в следующем виде:
"количество отрицательных чисел: а", "количество положительных чисел: б", где а, б - искомые значения.
Пример для чисел 2 5 6:
количество отрицательных чисел: 0
количество положительных чисел: 3
Пример для чисел -2 -5 6:
количество отрицательных чисел: 2
количество положительных чисел: 1
*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        ArrayList<Integer> arr= new ArrayList<Integer>();
        arr.add(a);
        arr.add(b);
        arr.add(c);
        int counter_pos=0;
        int counter_neg=0;
        for (Integer i:arr)
        {
            if (i>0)
            counter_pos++;
            else
            counter_neg++;
        }

        System.out.println("количество отрицательных чисел: "+counter_neg);
        System.out.println("количество положительных чисел: "+counter_pos);








    }
}
