package com.javarush.test.level26.lesson08.task01;

/* Вежливость - это искусственно созданное хорошее настроение.
В классе Solution создайте public static класс IntegerHolder.
IntegerHolder должен быть для типа int, быть нитебезопасным и изменяемым.
В этом классе должны быть два public метода get и set
*/
public class Solution {
    public static void main(String[] args)
    {
        final IntegerHolder ih = new IntegerHolder();
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                ih.set(8);
            }

        }).start();
        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException ie)
        {
            ie.printStackTrace();
        }


        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                ih.set(7);
            }
        }).start();

        System.out.println(ih.get());


    }
    public static class IntegerHolder
    {
        private int value;


        public synchronized int get()
        {
            return value;
        }

        public synchronized void set(int value)
        {
            this.value = value;
        }

    }

}
