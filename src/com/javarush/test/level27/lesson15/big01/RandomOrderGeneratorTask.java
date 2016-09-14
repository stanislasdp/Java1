package com.javarush.test.level27.lesson15.big01;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stas on 9/13/16.
 */
public class RandomOrderGeneratorTask implements Runnable
{
   private List<Tablet> tablets = new ArrayList<>();
    private int timeout;

    public RandomOrderGeneratorTask(List<Tablet> tablets, int timeout)
    {
        this.tablets =  tablets;
        this.timeout  = timeout;
    }

    @Override
    public void run()
    {
        while (!Thread.currentThread().isInterrupted())
        {
            int randomTablet =(int)(Math.random() * tablets.size());
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
