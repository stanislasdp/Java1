package com.javarush.test.level17.lesson10.bonus01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static
    {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args)
    {
        SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        SimpleDateFormat outputformat  = new SimpleDateFormat("dd-MMM-yyyy",Locale.ENGLISH);

        try
        {
            if (args[0].equals("-c") )
            {
                if (args.length==4)
                {
                    if (args[2].equals("м"))
                    {
                        allPeople.add(Person.createMale(args[1], dateformat.parse(args[3])));
                    }
                    else if (args[2].equals("ж"))
                    {
                        allPeople.add(Person.createFemale(args[1],dateformat.parse(args[3])));
                    }

                    System.out.println(allPeople.size()-1);
                }
            }
            else if (args[0].equals("-u") && args.length==5)
            {

                    if (allPeople.size()-1>=Integer.parseInt(args[1]))
                    {

                        Person person = allPeople.get(Integer.parseInt(args[1]));

                            person.setName(args[2]);
                            if (args[3].equals("м"))
                            {
                                person.setSex(Sex.MALE);
                            }
                            else if (args[3].equals("ж"))
                            {
                                person.setSex(Sex.FEMALE);
                            }
                            person.setBirthDay(dateformat.parse(args[4]));

                    }

            }
            else if (args[0].equals("-d") && args.length==2)
            {
                if (allPeople.size()-1>=Integer.parseInt(args[1]))
                {
                    Person person = allPeople.get(Integer.parseInt(args[1]));
                    person.setName(null);
                    person.setSex(null);
                    person.setBirthDay(null);
                }
            }
            else if (args[0].equals("-i"))
            {
                if (allPeople.size()-1>=Integer.parseInt(args[1]))
                {
                    Person person = allPeople.get(Integer.parseInt(args[1]));
                    System.out.println(person.getName()+" "+((person.getSex().equals(Sex.MALE))?"м":"ж")+" "+outputformat.format(person.getBirthDay()));
                }
            }

        }
        catch (ParseException pe)
        {
            pe.printStackTrace();
        }

    }
}
