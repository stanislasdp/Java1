package com.javarush.test.level12.lesson04.task04;

/* Три метода возвращают минимальное из двух переданных в него чисел
Написать public static методы: int min(int, int), long min(long, long), double min(double, double).
Каждый метод должен возвращать минимальное из двух переданных в него чисел.
*/

public class Solution
{
    public static void main(String[] args)
    {
        System.out.println(Solution.min(1.4,2.4));
    }

    public static int min(int a,int b)
    {
        int result=Math.min(a,b);
        return result;
    }

    public static long min(long a,long b)
    {
        long result=Math.min(a,b);
        return result;
    }

    public static double min(double a,double b)
    {
        double result=Math.min(a,b);
        return result;
    }


{}
}
