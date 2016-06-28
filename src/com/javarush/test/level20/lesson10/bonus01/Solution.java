package com.javarush.test.level20.lesson10.bonus01;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution {
    public static int[] getNumbers(int N)
    {
        List<Integer> digits = new ArrayList<Integer>();
        int M;

        int result;

        for (int S =1;S<N;S++)
        {
            M = (S+"").length();
            result =0;
            int tmp = S;
            int counter=0;
            int length =(S+"").length();
            do
            {
                counter=tmp%10;
                result+=pow(counter,length);
            }
            while((tmp/=10)>0);

            if (result==S)
            {
                digits.add(S);
                System.out.println(result);
            }
        }
        int[] intArray = new int[digits.size()];
        for (int i = 0; i < digits.size() ; i++)
        {
            intArray[i] =digits.get(i);
        }
        return intArray;

    }

    static int pow(int a, int n) {
        if (n == 0) return 1;
        if (n % 2 == 0) {
            int ans = pow(a, n / 2);
            return ans * ans;
        } else {
            return a * pow(a, n - 1);
        }
    }

    public static void main(String[] args)
    {
        long start = Runtime.getRuntime().totalMemory();
        long timeStart = (new Date()).getTime();
        for (int i: getNumbers(Integer.MAX_VALUE))
        {
            System.out.println(i);
        }
        long timeEnd = (new Date()).getTime();
        long end = Runtime.getRuntime().freeMemory();
        System.out.println("Time: " + (timeEnd - timeStart) + " ms");
        System.out.println("Memory: " + (start-end)/1024+ " KByte");
    }
}
