package com.javarush.test.level20.lesson07.task05;

import java.io.*;

/* Переопределение сериализации
Сделайте так, чтобы после десериализации нить runner продолжила работать.
Ключевые слова объекта runner менять нельзя.
Hint/Подсказка:
Конструктор не вызывается при сериализации, только инициализируются все поля.
*/
public class Solution implements Serializable, Runnable {
    transient private Thread runner;
    private int speed;

    public Solution(int speed) {
        this.speed = speed;
        runner = new Thread(this);
        runner.start();
    }

    public void run()
    {

        while(true)
        {
            try
            {
                System.out.println("works");
                Thread.sleep(5000);
            }
            catch (InterruptedException ie)
            {
                ie.printStackTrace();
            }

        }
    }

    /**
     Переопределяем сериализацию.
     Для этого необходимо объявить методы:
     private void writeObject(ObjectOutputStream out) throws IOException
     private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
     Теперь сериализация/десериализация пойдет по нашему сценарию :)
     */
    private void writeObject(ObjectOutputStream out) throws IOException
    {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
    {
        in.defaultReadObject();
        startThead();//invoking restart current thread
    }


    // method for recreating and restart of current thread
    private void startThead()
    {
        runner=new Thread(this);
        runner.start();
    }

    public static void main(String[] args) throws Exception
    {
        FileOutputStream fo = new FileOutputStream("/home/stas/test/output.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fo);


        Solution sol = new Solution(4);

        fo.close();

     //   FileInputStream fi = new FileInputStream("/home/stas/test/output.txt");
    //    ObjectInputStream obi= new ObjectInputStream(fi);
     //   sol.readObject(obi);
      //  fo.close();


    }
}
