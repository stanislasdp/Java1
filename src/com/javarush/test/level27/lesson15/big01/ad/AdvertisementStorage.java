package com.javarush.test.level27.lesson15.big01.ad;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stas on 9/10/16.
 */
 class AdvertisementStorage
{
    private final List<Advertisement> videos = new ArrayList<>();
    private static AdvertisementStorage ourInstance = new AdvertisementStorage();

    static AdvertisementStorage getInstance()
    {
        return ourInstance;
    }

    private AdvertisementStorage()
    {
        Object someContent = new Object();
     //  videos.add(new Advertisement(someContent, "1", 152, 3, 3 * 60));
    //  videos.add(new Advertisement(someContent, "2", 5, 2, 5 * 60));
     //   videos.add(new Advertisement(someContent, "3", 3, 2, 3 * 60));
     //   videos.add(new Advertisement(someContent, "4", 99, 10, 2 * 60));
      //  videos.add(new Advertisement(someContent, "X", 2000, 3, 6 * 60));
      //  videos.add(new Advertisement(someContent, "5", 150, 3, 3 * 60));
        videos.add(new Advertisement(someContent, "First Video", 5000, 1000, 3 * 60));
        videos.add(new Advertisement(someContent, "second Video", 100, 100, 15 * 60));
        videos.add(new Advertisement(someContent, "Third Video", 400, 2, 10 * 60));
        videos.add(new Advertisement(someContent, "first video", 5000, 100, 3 * 60)); // 3 min
        videos.add(new Advertisement(someContent, "Second Video", 100, 10, 15 * 60)); //15 min
        videos.add(new Advertisement(someContent, "четвертое видео", 400, 2, 10 * 60));   //10 min
        videos.add(new Advertisement(someContent, "пятое видео", 400, 1, 10 * 60));   //10 min
        videos.add(new Advertisement(someContent, "fourth video", 400, 1, 10 * 60));
        videos.add(new Advertisement(someContent, "fifth video", 400, 1, 10 * 60));//10 min*/
    }

    public  List<Advertisement>  list()
    {
        return videos;
    }

    public void add(Advertisement advertisement)
    {
        videos.add(advertisement);
    }
}
