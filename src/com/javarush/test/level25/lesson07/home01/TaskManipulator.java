package com.javarush.test.level25.lesson07.home01;

public class TaskManipulator implements Runnable, CustomThreadManipulator
{
    Thread thread;
    String threadname;
    @Override
    public void run()
    {
        try
        {
            while (!thread.isInterrupted())
            {
                Thread.sleep(0);
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(90);

            }

        }
        catch (InterruptedException e)
        {

        }

        }



    @Override
    public void start(String threadName)
    {
        thread = new Thread(this,threadName);
        thread.start();
    }

    @Override
    public void stop()
    {
        thread.interrupt();
    }
}
