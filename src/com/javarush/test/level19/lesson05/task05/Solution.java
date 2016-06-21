package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, включая символы новой строки. Результат вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String first_file = bf.readLine();
        String second_file = bf.readLine();
        bf.close();
        Scanner sc = new Scanner(new FileReader(first_file));
        FileWriter write1 = new FileWriter(second_file);

        StringBuffer sb = new StringBuffer();
        while (sc.hasNext())
        {
            sb.append(sc.next());
        }
        String result = sb.toString();
        result=result.replaceAll("[^A-Za-z0-9]","");
        System.out.println(result);

        write1.write(result);
        sc.close();
        write1.close();
    }
}
