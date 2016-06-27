package com.javarush.test.level20.lesson10.home05;

import java.io.*;
import java.util.logging.Logger;

/* Сериализуйте Person
Сериализуйте класс Person стандартным способом. При необходимости поставьте полям модификатор transient.
*/
public class Solution {

    public static class Person implements Serializable{
        String firstName;
        String lastName;
      transient  String fullName;
       transient final String greetingString;
        String country;
        Sex sex;
         transient PrintStream outputStream;
         transient Logger logger;

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greetingString = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }
    }

    enum Sex
    {
        MALE,
        FEMALE
    }


    public static void main(String[] args) throws IOException,ClassNotFoundException
    {
        FileOutputStream fileOutput = new FileOutputStream("/home/stas/test/output.txt");
        Person person1 = new Person("Stas","Kiryan","Ukraine",Sex.MALE);

        ObjectOutputStream ou = new ObjectOutputStream(fileOutput);
        ou.writeObject(person1);
        ou.close();

        Person p2;
        FileInputStream fileInputStream = new FileInputStream("/home/stas/test/output.txt");
        ObjectInputStream oi = new ObjectInputStream(fileInputStream);
        p2 = (Person) oi.readObject();
        System.out.println(p2.firstName);
        System.out.println(p2.country);
    }


}
