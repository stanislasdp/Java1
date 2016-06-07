package com.javarush.test.level06.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Comparator;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.
Пример ввода:
3
2
15
6
17
Пример вывода:
2
3
6
15
17
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));

        int first_digit = Integer.parseInt(reader.readLine());
        int second_digit = Integer.parseInt(reader.readLine());
        int third_digit = Integer.parseInt(reader.readLine());
        int fourth_digit = Integer.parseInt(reader.readLine());
        int fifth_digit = Integer.parseInt(reader.readLine());

        ArrayList<Integer> arr1 = new ArrayList<Integer>();
        arr1.add(first_digit);
        arr1.add(second_digit);
        arr1.add(third_digit);
        arr1.add(fourth_digit);
        arr1.add(fifth_digit);

arr1.sort(new Comparator<Integer>()
{
@Override
public int compare(Integer o1, Integer o2)
{
   int flag =o1.compareTo(o2);
    return flag;

}
});


        System.out.println(arr1.get(0));
        System.out.println(arr1.get(1));
        System.out.println(arr1.get(2));
        System.out.println(arr1.get(3));
        System.out.println(arr1.get(4));






    }


}
