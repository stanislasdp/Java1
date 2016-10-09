package com.javarush.test.level33.lesson15.big01.strategies;



import java.io.Serializable;
import java.util.Objects;

/**
 * Created by stas on 9/28/16.
 */
public class Entry implements Serializable
{
    Long key;
    String value;
    Entry next;
    int hash;

    public Entry(int hash, Long key, String value, Entry next)
    {
        this.hash = hash;
        this.next = next;
        this.value = value;
        this.key = key;
    }

    public Long getKey()
    {
        return key;
    }

    public String getValue()
    {
        return value;
    }




    @Override
    public int hashCode()
    {
        return hash ^ Objects.hashCode(value);
    }

    @Override
    public String toString()
    {
       return key+"=" + value;
    }
}
