package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file_first_name =br.readLine();
        String file_second_name =br.readLine();
        br.close();

        FileInputStream fi1 = new FileInputStream(file_first_name);

        ArrayList<String> arr1 = new ArrayList<String>();

        String str = "";
        while (fi1.available()>0)
        {
            str+= (char)fi1.read();
        }
        fi1.close();

        String[] digits =str.split(" ");

        for (int i = 0; i <digits.length ; i++)
        {

           double digit = Double.parseDouble(digits[i]);
           arr1.add(Math.round(digit)+" ");
        }

        FileWriter writer = new FileWriter(file_second_name);

        for (String wr:arr1)
        {
            writer.write(wr);
        }

        writer.close();

    }


}
