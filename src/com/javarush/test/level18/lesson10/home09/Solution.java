package com.javarush.test.level18.lesson10.home09;

/* Файлы и исключения
Читайте с консоли имена файлов
Если файла не существует (передано неправильное имя файла), то
перехватить исключение FileNotFoundException, вывести в консоль переданное неправильное имя файла и завершить работу программы.
Закрыть потоки. Не использовать try-with-resources
Не используйте System.exit();
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String wrong_file_name = "";
        try
        {
            while (true)
            {
                wrong_file_name = bf.readLine();
                FileInputStream fi = new FileInputStream(wrong_file_name);
            }

        }
        catch (FileNotFoundException fe)
        {
            System.out.println(wrong_file_name);
        }
        finally
        {
            bf.close();
        }


    }
}
