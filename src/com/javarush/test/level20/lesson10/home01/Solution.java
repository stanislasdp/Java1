package com.javarush.test.level20.lesson10.home01;

import java.io.*;

/* Минимум изменений
Используя минимум изменений кода сделайте так, чтобы сериализация класса C стала возможной.
*/
public class Solution
{

    public static class A implements Serializable
    {
        String name = "A";

        public A(String name) {
            this.name += name;
        }

       /* @Override
        public String toString() {
            return name;
        }*/
    }

    public static class B extends A {
        String name = "B";

        public B(String name) {
            super(name);
            this.name += name;
        }
    }

    public static class C extends B
    {
        String name = "C";

        public C(String name) {
            super(name);
            this.name = name;
        }
    }

    public static void main(String[] args) throws Exception
    {
     /*  FileOutputStream fo = new FileOutputStream("/home/stas/test/output.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fo);

        C c = new C("name1");
        objectOutputStream.writeObject(c.name);
        objectOutputStream.close();
        fo.close();*/


        FileInputStream fi = new FileInputStream("/home/stas/test/output.txt");
        ObjectInputStream obi= new ObjectInputStream(fi);
            C c= new C(null);
           c.name= (String) obi.readObject();
        System.out.println(c.name);

    }
}
