package com.javarush.test.level33.lesson15.big01;

import com.javarush.test.level33.lesson15.big01.strategies.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by stas on 9/28/16.
 */
public class Solution
{
   public static Set<Long> getIds(Shortener shortener, Set<String> strings)
   {
       Set<Long> resultSet = new HashSet<>();

       for (String s : strings)
       {
           resultSet.add(shortener.getId(s));
       }
       return resultSet;

   }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys)
    {
        Set<String> strings = new HashSet<>();

        for (Long key: keys)
        {
            strings.add(shortener.getString(key));
        }
        return strings;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber)
    {
        Helper.printMessage(strategy.getClass().getSimpleName());
        Set<String> testSetStrings = new TreeSet<>();

        for (int i = 0; i < elementsNumber; i++)
        {
            testSetStrings.add(Helper.generateRandomString());
        }

        Shortener testShortener = new Shortener(strategy);
        Date dateBeforeId = new Date();

        Set<Long> ids = getIds(testShortener,testSetStrings);

        Date dateAfterId = new Date();
        Long timeforId = dateAfterId.getTime() - dateBeforeId.getTime();
        Helper.printMessage(timeforId+ "");


        Date dateBeforeString = new Date();
        Set<String> strings = getStrings(testShortener,ids);
        Date dateAfterString = new Date();
        Long timeforString = dateAfterString.getTime() - dateBeforeString.getTime();
        Helper.printMessage(timeforString+"");

        if (testSetStrings.equals(strings))
        {
            Helper.printMessage("Тест пройден.");
        }
        else
        {
            Helper.printMessage("Тест не пройден.");
        }

    }

    public static void main(String[] args)
    {
        StorageStrategy HashMapstorageStrategy = new HashMapStorageStrategy();
        StorageStrategy OurHashBiMapStorageStrategy = new OurHashBiMapStorageStrategy();
        StorageStrategy HashBiMapStorageStrategy = new HashBiMapStorageStrategy();
        StorageStrategy DualHashBidiMapStorageStrategy = new DualHashBidiMapStorageStrategy();
      //  StorageStrategy ourHashMapStrategy = new OurHashMapStorageStrategy();
        //testStrategy(HashMapstorageStrategy,10000L);
     //   StorageStrategy FileStorageStrategy = new FileStorageStrategy();
        testStrategy(HashMapstorageStrategy,10000L);
        testStrategy(OurHashBiMapStorageStrategy,10000L);
        testStrategy(HashBiMapStorageStrategy,10000L);
        testStrategy(DualHashBidiMapStorageStrategy,10000L);

    }
}
