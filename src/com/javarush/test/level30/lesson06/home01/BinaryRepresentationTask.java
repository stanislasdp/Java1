package com.javarush.test.level30.lesson06.home01;

import java.util.concurrent.RecursiveTask;

/**
 * Created by stas on 8/31/16.
 */
public class BinaryRepresentationTask extends RecursiveTask<String>
{
    final int x;

    public BinaryRepresentationTask(int x)
    {
        this.x = x;
    }

    @Override
    protected String compute()
    {
        int a = x % 2;
        int b = x / 2;
        String result = String.valueOf(a);
        if (b > 0)
        {
            BinaryRepresentationTask binRepTask = new BinaryRepresentationTask(b);
            binRepTask.fork();
            return binRepTask.join() + result;
        }
        return result;
    }
}
