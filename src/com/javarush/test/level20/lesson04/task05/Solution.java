package com.javarush.test.level20.lesson04.task05;

import java.io.*;

/* Как сериализовать что-то свое?
Сделайте так, чтобы сериализация класса Object была возможной
*/
public class Solution {
    public static class Object1 implements Serializable
    {
        public String string1;
        public String string2;
    }

    public static int countStrings;

    public static class String1 implements Serializable {
        private final int number;

        public String1() {
            number = ++countStrings;
        }

        public void print() {
            System.out.println("string #" + number);
        }
    }


    public static void main(String[] args) throws IOException,ClassNotFoundException
    {
        FileOutputStream fo = new FileOutputStream("file.tmp");
        FileInputStream fi = new FileInputStream("file.tmp");

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fo);
        ObjectInputStream objectInputStream = new ObjectInputStream(fi);

        String1 original_object = new String1();
        original_object.print();
        objectOutputStream.writeObject(original_object);

        Object restored_object = objectInputStream.readObject();
      String1 string_res = (String1)restored_object;
        string_res.print();

    }
}
