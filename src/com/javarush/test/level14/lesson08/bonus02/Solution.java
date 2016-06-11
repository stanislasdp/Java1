package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer a = Integer.parseInt(reader.readLine());
        Integer b = Integer.parseInt(reader.readLine());
        NOD(a,b);


    }

    public static void NOD(Integer a,Integer b)
    {
        if (b<a)
        {
            Integer tmp1=a;
            a=b;
            b=tmp1;
        }
        while (b!=0)
        {
            Integer tmp2=a%b;
            a=b;
            b=tmp2;
        }
        System.out.println(a);
    }
}
