package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br_file1 =new BufferedReader(new FileReader(args[0]));
        BufferedWriter br_file2 =new BufferedWriter(new FileWriter(args[1]));

        while (br_file1.ready())
        {
            String[] curr_string_words = br_file1.readLine().split(" ");


            for (int i = 0; i <curr_string_words.length ; i++)
            {

                if (curr_string_words[i].matches("(.)*(\\d)(.)*"))
                {
                    br_file2.write(curr_string_words[i] +" ");
                }
            }
        }
        br_file1.close();
        br_file2.close();
    }
}
