package com.javarush.test.level27.lesson04.task02;

/* Второй вариант дедлока
В методе secondMethod в синхронизированных блоках расставьте локи так,
чтобы при использовании класса Solution нитями образовывался дедлок
*/
public class Solution {
    private final Object lock = new Object();

    public synchronized void firstMethod()
    {
        synchronized (lock)
        {
            doSomething();
        }
    }

    public  void secondMethod()
    {    synchronized (lock)
    {
        synchronized (this)
        {
            doSomething();
        }
    }
        {
        }

    }

    private void doSomething()
    {
        System.out.println("works");
    }

    public static void main(String[] args)
    {
        final Solution sol1 = new Solution();
        final Solution sol2 = new Solution();

        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                sol1.firstMethod();
            }
        }).start();

        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                sol2.firstMethod();
            }
        }).start();


    }
}