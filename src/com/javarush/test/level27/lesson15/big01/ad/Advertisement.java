package com.javarush.test.level27.lesson15.big01.ad;

/**
 * Created by stas on 8/18/16.
 */
public class Advertisement
{
   private Object content;
    private String name;
    private long initialAmount;
    private int hits;
    private int duration;
    private long amountPerOneDisplaying;

    public Advertisement(Object content,String name, long initialAmount, int hits, int duration)
    {
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        this.content = content;
        amountPerOneDisplaying =initialAmount/hits;
    }

    public String getName()
    {
        return name;
    }

    public int getDuration()
    {
        return duration;
    }

    public long getAmountPerOneDisplaying()
    {
        return amountPerOneDisplaying;
    }
}
