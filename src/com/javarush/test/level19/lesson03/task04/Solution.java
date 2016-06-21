package com.javarush.test.level19.lesson03.task04;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.
*/

public class Solution {
    public static class PersonScannerAdapter implements PersonScanner
    {
        private Scanner sc;

        public PersonScannerAdapter(Scanner sc)
        {
            this.sc = sc;

        }

        @Override
        public Person read() throws IOException
        {
            String s ="";

            if (sc.hasNextLine())
            {
                s=sc.nextLine();
            }
            String [] splitted_name = s.split(" ");
            Calendar cal = new GregorianCalendar(Integer.parseInt(splitted_name[5]), Integer.parseInt(splitted_name[4])-1, Integer.parseInt(splitted_name[3]));
            Date birthdate = cal.getTime();
            SimpleDateFormat sm = new SimpleDateFormat("dd-MM-YYYY");

            return new Person(splitted_name[1],splitted_name[2],splitted_name[0],birthdate);
        }

        @Override
        public void close() throws IOException
        {
            sc.close();
        }
    }
}
