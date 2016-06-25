package com.javarush.test.level20.lesson07.task03;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Externalizable Person
Класс Person должен сериализоваться с помощью интерфейса Externalizable.
Подумайте, какие поля не нужно сериализовать.
Исправьте ошибку сериализации.
Сигнатуры методов менять нельзя.
*/
public class Solution {
    public static class Person implements Externalizable {
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public Person(){}

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(mother);
            out.writeObject(father);
            out.writeObject(firstName);
            out.writeObject(lastName);
            out.writeInt(age);
            out.writeObject(children);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            mother = (Person)in.readObject();
            father = (Person)in.readObject();
            firstName = (String) in.readObject();
            lastName = (String) in.readObject();
            age = in.readInt();
            children = (List)in.readObject();
        }
    }

    public static void main(String[] args) throws Exception
    {
   /*     FileOutputStream fo = new FileOutputStream("/home/stas/test/output.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fo);
        Person p = new Person("Stas","Kirtan",12);
        p.setMother(new Person("MotherF","MotherL",95));
        p.setFather(new Person("FatherF","FatherL",56));

        Person child_1 = new Person("Child1f","Child1l",1);
        List<Person> listchildren = new ArrayList<Person>();
        listchildren.add(child_1);
        p.setChildren(listchildren);

        p.writeExternal(objectOutputStream);
        objectOutputStream.close();
*/

       FileInputStream fi = new FileInputStream("/home/stas/test/output.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fi);
        Person p1 = new Person();
        p1.readExternal(objectInputStream);
        objectInputStream.close();
    }
}
