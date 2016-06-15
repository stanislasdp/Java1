package com.javarush.test.level17.lesson10.home09;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines
4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args)
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String firstfilename = reader.readLine();
            String secondfilename = reader.readLine();

            BufferedReader first_file_reader = new BufferedReader(new FileReader(firstfilename));
            String line = first_file_reader.readLine();
            while (line!=null)
            {
                allLines.add(line);
                line = first_file_reader.readLine();
            }
            first_file_reader.close();

            BufferedReader second_file_reader = new BufferedReader(new FileReader(secondfilename));
            line = second_file_reader.readLine();

            while (line!=null)
            {
                forRemoveLines.add(line);
                line = second_file_reader.readLine();
            }
            second_file_reader.close();

            Solution sol = new Solution();
            sol.joinData();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }


    public void joinData () throws CorruptedDataException
    {
        if (allLines.containsAll(forRemoveLines))
        {
            allLines.removeAll(forRemoveLines);
        }
        else
        {
            for (String string : forRemoveLines)
            {
                if (!allLines.contains(string))
                {
                    allLines.clear();
                    throw new CorruptedDataException();
                }
            }
        }
    }
}
