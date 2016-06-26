package com.javarush.test.level20.lesson10.home03;

import java.io.*;

/* Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найдите проблему и исправьте ее.
Класс A не должен реализовывать интерфейсы Serializable и Externalizable.
Сигнатура класса В не содержит ошибку :)
Метод main не участвует в тестировании.
*/
public class Solution implements Serializable {
    public static class A {
        protected String name = "A";

        public A(String name)
        {
            this.name += name;
        }
        public A()
        {}

    }

    public class B extends A implements Serializable
    {

        public B(String name)
        {
            super(name);
            this.name += name;
        }

        private void writeObject(ObjectOutputStream out) throws IOException
        {
            out.defaultWriteObject();
            //явно сохраняем поле родителя
            out.writeObject(this.name);
        }

        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
        {

            in.defaultReadObject();
            //явно присваиваивем полн родитед. после десериализации
            name =(String)in.readObject();

        }
    }

    public static void main(String[] args) throws IOException,ClassNotFoundException
    {
       /*   Solution sol = new Solution();
       Solution.B b = sol.new B("nameb");
        FileOutputStream fo = new FileOutputStream("/home/stas/test/output.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fo);
        objectOutputStream.writeObject(b);
        objectOutputStream.close();*/

    FileInputStream fi = new FileInputStream("/home/stas/test/output.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fi);
        Solution.B b1 = (B)objectInputStream.readObject();
        System.out.println(b1.name);
    }
}
