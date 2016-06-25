package com.javarush.test.level20.lesson07.task01;

import java.io.*;

/* Externalizable для апартаментов
Реализуйте интерфейс Externalizable для класса Apartment
Подумайте, какие поля не нужно сериализовать.
*/
public class Solution
{
    public static class Apartment implements Externalizable
    {

        private String address;
        private int year;

        /**
         * Mandatory public no-arg constructor.
         */
        public Apartment() { super(); }

        public Apartment(String adr, int y) {
            address = adr;
            year = y;
        }

        /**
         * Prints out the fields. used for testing!
         */
        public String toString() {
            return("Address: " + address + "\n" + "Year: " + year);
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException
        {
            out.writeObject(address);
            out.writeObject(year);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
        {
            address = (String)in.readObject();
            year =(int)in.readObject();
        }
    }

    public static void main(String[] args) throws IOException,ClassNotFoundException
    {
        Apartment ap = new Apartment();
        ap.address="Adress1";
        ap.year = 34;

        System.out.println();
        FileInputStream fi = new FileInputStream("file.tmp");
        FileOutputStream fo = new FileOutputStream("file.tmp");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fo);
        ObjectInputStream objectInputStream = new ObjectInputStream(fi);
        System.out.println(ap.toString());
        ap.writeExternal(objectOutputStream);
        ap.address=null;
        ap.year= 0;
        ap.readExternal(objectInputStream);
        System.out.println(ap.toString());

    }
}
