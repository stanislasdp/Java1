package com.javarush.test.level27.lesson15.big01;

import java.util.ArrayList;

/**
 * Created by stas on 9/13/16.
 */
public class RandomOrderGeneratorTask implements Runnable
{
   private ArrayList<Tablet> tablets = new ArrayList<>();
    private int timeout;

    public RandomOrderGeneratorTask(ArrayList<Tablet> tablets, int timeout)
    {
        this.tablets =  tablets;
        this.timeout  = timeout;
    }

    @Override
    public void run()
    {
        while (!Thread.currentThread().isInterrupted())
        {
            int randomTablet =(int)(Math.random() * tablets.size())-1;
            tablets.get(randomTablet).createTestOrder();
            try
            {
                Thread.sleep(timeout);
            }
            catch (InterruptedException ie)
            {
                break;
            }

        }
    }
}
