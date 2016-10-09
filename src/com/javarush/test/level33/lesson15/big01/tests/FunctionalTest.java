package com.javarush.test.level33.lesson15.big01.tests;

import com.javarush.test.level33.lesson15.big01.Shortener;
import com.javarush.test.level33.lesson15.big01.strategies.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by stas on 10/9/16.
 */
public class FunctionalTest
{

    public void testStorage(Shortener shortener)
    {
        String firstString = "12345";
        String secondString = "Test";
        String thirdString = "12345";
        long firstID = shortener.getId(firstString);
        long secondID = shortener.getId(secondString);
        long thirdID = shortener.getId(thirdString);
        Assert.assertNotEquals(secondID,firstID);
        Assert.assertNotEquals(secondID,thirdID);
        Assert.assertEquals(firstID,thirdID);
        String retFirstString =  shortener.getString(firstID);
        String retSecondString = shortener.getString(secondID);
        String retThirdString = shortener.getString(thirdID);
        Assert.assertEquals(retFirstString,firstString);
        Assert.assertEquals(retSecondString,secondString);
        Assert.assertEquals(retThirdString,thirdString);
    }

    @Test
   public void testHashMapStorageStrategy()
    {
        StorageStrategy strategy = new HashMapStorageStrategy();
        Shortener shortener = new Shortener(strategy);
        testStorage(shortener);
    }

    @Test
    public void testOurHashMapStorageStrategy()
    {
        StorageStrategy strategy = new OurHashMapStorageStrategy();
        Shortener shortener = new Shortener(strategy);
        testStorage(shortener);
    }

    @Test
    public void testFileStorageStrategy()
    {
        StorageStrategy strategy = new FileStorageStrategy();
        Shortener shortener = new Shortener(strategy);
        testStorage(shortener);
    }

    @Test
    public void testHashBiMapStorageStrategy()
    {
        StorageStrategy strategy = new HashBiMapStorageStrategy();
        Shortener shortener = new Shortener(strategy);
        testStorage(shortener);
    }
    @Test
    public void testDualHashBidiMapStorageStrategy()
    {
        StorageStrategy strategy = new DualHashBidiMapStorageStrategy();
        Shortener shortener = new Shortener(strategy);
        testStorage(shortener);
    }

    @Test
    public void testOurHashBiMapStorageStrategy()
    {
        StorageStrategy strategy = new OurHashMapStorageStrategy();
        Shortener shortener = new Shortener(strategy);
        testStorage(shortener);
    }



}
