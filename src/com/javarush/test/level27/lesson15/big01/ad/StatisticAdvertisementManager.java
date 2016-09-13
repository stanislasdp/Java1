package com.javarush.test.level27.lesson15.big01.ad;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by stas on 9/13/16.
 */
public class StatisticAdvertisementManager
{
    private static StatisticAdvertisementManager ourInstance = new StatisticAdvertisementManager();

    private AdvertisementStorage as  =  AdvertisementStorage.getInstance();

    public static StatisticAdvertisementManager getInstance()
    {
        return ourInstance;
    }

    private StatisticAdvertisementManager()
    {
    }

    public AdvertisementStorage getAdvertisementStorage()
    {
        return AdvertisementStorage.getInstance();
    }

    public Set<Advertisement> getVideo ()
    {
        List<Advertisement> allVideos = as.list();
        Set<Advertisement> allVideoSet = new TreeSet<Advertisement>(new Comparator<Advertisement>()
        {
            @Override
            public int compare(Advertisement o1, Advertisement o2)
            {
                String firstName = o1.getName();
                String secondName = o2.getName();

                return firstName .compareToIgnoreCase(secondName);
            }
        });

        for (Advertisement ad: allVideos)
        {
            allVideoSet.add(ad);
        }

        return allVideoSet;
    }
}
