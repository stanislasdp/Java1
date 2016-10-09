package com.javarush.test.level33.lesson15.big01.tests;

import com.javarush.test.level33.lesson15.big01.Helper;
import com.javarush.test.level33.lesson15.big01.Shortener;
import com.javarush.test.level33.lesson15.big01.strategies.HashBiMapStorageStrategy;
import com.javarush.test.level33.lesson15.big01.strategies.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by stas on 10/9/16.
 */
public class SpeedTest
{

    public long getTimeForGettingIds(Shortener shortener, Set<String> strings, Set<Long> ids)
    {

        Date dateBefore = new Date();
        for (String str: strings)
        {
            ids.add(shortener.getId(str));
        }

        Date dateAfter = new Date();
        return dateAfter.getTime() - dateBefore.getTime();
    }

    public long getTimeForGettingStrings(Shortener shortener, Set<Long> ids, Set<String> strings)
    {
        Date dateBefore = new Date();
        for (Long id: ids)
        {
            strings.add(shortener.getString(id));
        }
        Date dateAfter = new Date();
        return dateAfter.getTime() - dateBefore.getTime();
    }

    @Test
    public void testHashMapStorage()
    {
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());
        Set<String> origStrings = new TreeSet<String>();

        for (int i = 0; i < 10000; i++)
        {
            origStrings.add(Helper.generateRandomString());
        }
        Set<Long> ids = new TreeSet<>();
        long time1 = getTimeForGettingIds(shortener1,origStrings,ids);
        long time2 = getTimeForGettingIds(shortener2,origStrings,ids);
        Assert.assertTrue(time1 > time2);

        long time3 = getTimeForGettingStrings(shortener1,ids,new TreeSet<String>());
        long time4 = getTimeForGettingStrings(shortener2,ids,new TreeSet<String>());

        Assert.assertEquals(time3,time4,100);
    }
}
