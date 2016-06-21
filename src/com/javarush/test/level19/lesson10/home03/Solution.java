package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException,ParseException
    {
        BufferedReader br =new BufferedReader(new FileReader(args[0]));
        SimpleDateFormat sf = new SimpleDateFormat("dd MM yyyy");



        while (br.ready())
        {
            String person_not_parsed =br.readLine();
            String person_name =person_not_parsed.replaceAll("[\\d]","").trim();
            String person_date_all = person_not_parsed.replaceAll("[\\D]"," ").trim();

            System.out.println(person_date_all);
            PEOPLE.add(new Person(person_name,sf.parse(person_date_all)));
        }
        br.close();

       for (Person p:PEOPLE)
        {
            System.out.println(p.getName()+" "+p.getBirthday());
        }
    }

}
