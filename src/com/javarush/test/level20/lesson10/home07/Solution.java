package com.javarush.test.level20.lesson10.home07;

import java.io.*;

/* Переопределение сериализации в потоке
Сериализация/десериализация Solution не работает.
Исправьте ошибки не меняя сигнатуры методов и класса.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать экземпляр класса Solution+
2) записать в него данные  - writeObject+
3) сериализовать класс Solution  - writeObject(ObjectOutputStream out)
4) десериализовать, получаем новый объект
5) записать в новый объект данные - writeObject
6) проверить, что в файле есть данные из п.2 и п.5
*/
public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
    public String fileName;

    public Solution(String fileName) throws FileNotFoundException
    {   this.fileName = fileName;
        this.stream = new FileOutputStream(fileName);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeObject(fileName);

    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        fileName = (String)in.readObject();
        stream =new FileOutputStream(fileName,true);
    }

    @Override
    public void close() throws Exception
    {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws IOException,ClassNotFoundException
    {
       // FileOutputStream fo = new FileOutputStream("/home/stas/test/output.txt");
       // ObjectOutputStream ob = new ObjectOutputStream(fo);

        Solution sol = new Solution("/home/stas/test/output.txt");
        sol.writeObject("test_string");

        FileOutputStream fo = new FileOutputStream("/home/stas/test/outputtest.txt");
        ObjectOutputStream ob = new ObjectOutputStream(fo);
        ob.writeObject(sol);
        ob.close();

        FileInputStream fi = new FileInputStream("/home/stas/test/outputtest.txt");
        ObjectInputStream oi  = new ObjectInputStream(fi);
        Solution sol1;
      sol1=  (Solution) oi.readObject();
        sol1.writeObject("string2");



        ///ob.writeObject(sol);

    }
}
