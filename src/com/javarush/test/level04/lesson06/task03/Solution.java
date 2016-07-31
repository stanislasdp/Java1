package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int first_digit =  Integer.parseInt(reader.readLine());
        int second_digit =  Integer.parseInt(reader.readLine());
        int third_digit =  Integer.parseInt(reader.readLine());
        reader.close();

        if (first_digit>second_digit && first_digit>third_digit && second_digit>third_digit)
        {
            System.out.println(first_digit);
            System.out.println(second_digit);
            System.out.println(third_digit);

        }
        else if (first_digit>second_digit &&  first_digit>third_digit && second_digit<third_digit)
        {
            System.out.println(first_digit);
            System.out.println(third_digit);
            System.out.println(second_digit);
        }
        else if (first_digit<second_digit &&  first_digit<third_digit && second_digit>third_digit)
        {
            System.out.println(second_digit);
            System.out.println(third_digit);
            System.out.println(first_digit);
        }
        else if (first_digit<second_digit &&  first_digit<third_digit && second_digit<third_digit)
        {
            System.out.println(third_digit);
            System.out.println(second_digit);
            System.out.println(first_digit);
        }
        else if (first_digit<third_digit &&  first_digit>second_digit && second_digit<third_digit)
        {
            System.out.println(third_digit);
            System.out.println(first_digit);
            System.out.println(second_digit);
        }





    }
}
