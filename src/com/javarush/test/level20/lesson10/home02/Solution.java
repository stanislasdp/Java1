package com.javarush.test.level20.lesson10.home02;


import java.io.*;

/* Десериализация
На вход подается поток, в который записан сериализованный объект класса A либо класса B.
Десериализуйте объект в методе getOriginalObject предварительно определив, какого именно типа там объект.
Реализуйте интерфейс Serializable где необходимо.
*/
public class Solution implements Serializable {
    public A getOriginalObject(ObjectInputStream objectStream) throws ClassNotFoundException,IOException
    {

        Object obj = objectStream.readObject();
            if (obj instanceof B)
            {
                return  (B)obj;
            }
            else

            {
                return (A)obj;
            }


    }



    public class  A implements Serializable  {
    }

    public class B extends A  implements Serializable {
        public B() {
            System.out.println("inside B");
        }
    }


    public static void main(String[] args) throws Exception
    {
        Solution sol = new Solution();
        Solution.B b =sol.new B();
        FileOutputStream fo = new FileOutputStream("/home/stas/test/output.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fo);

        objectOutputStream.writeObject(b);
        objectOutputStream.close();


        FileInputStream fi = new FileInputStream("/home/stas/test/output.txt");
        ObjectInputStream obi= new ObjectInputStream(fi);

        System.out.println(sol.getOriginalObject(obi).getClass().getCanonicalName());



    }
}
