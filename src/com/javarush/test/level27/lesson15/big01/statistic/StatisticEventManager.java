package com.javarush.test.level27.lesson15.big01.statistic;
;
import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.statistic.event.CookedOrderEventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventType;
import com.javarush.test.level27.lesson15.big01.statistic.event.VideoSelectedEventDataRow;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by stas on 9/11/16.
 */
public class StatisticEventManager
{
    private static StatisticEventManager ourInstance = new StatisticEventManager();
    private final StatisticStorage storage = new StatisticStorage();


   // private Set<Cook> cookSet = new HashSet<Cook>();




    // List<Advertisement> videos= StatisticAdvertisementManager.getInstance().getAdvertisementStorage();

    public static StatisticEventManager getInstance()
    {
        return ourInstance;
    }

    private StatisticEventManager() {}

    public void register(EventDataRow data)
    {
        storage.put(data);
    }

 /*   public void register(Cook cook)
    {
        cookSet.add(cook);
    }

    public Set<Cook> getCookSet()
    {
        return cookSet;
    }*/


    public Map<Date,Double> getVideoSelectedProfit()
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        List<EventDataRow> list = storage.get(EventType.SELECTED_VIDEOS);
        Map<Date,Double> maps = new TreeMap<>(Collections.reverseOrder());

        for (EventDataRow er: list)
        {
            VideoSelectedEventDataRow vr = (VideoSelectedEventDataRow)er;
            Date dt = null;
            try
            {
                dt = dateFormat.parse(dateFormat.format(vr.getDate()));
            }
            catch (ParseException pe) {}


            if (!maps.containsKey(dt))
            {
                maps.put(dt,(double)vr.getAmount()* 0.01d);
            }
            else
            {
                maps.put(dt,maps.get(dt) +  vr.getAmount()* 0.01d);
            }
        }
        return maps;
    }


    public Map<Date,Map<String,Integer>> getCookWorkLoad()
    {
        List<EventDataRow> list = storage.get(EventType.COOKED_ORDER);
        Map<Date,Map<String,Integer>> map = new TreeMap<>(Collections.reverseOrder());

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        for (EventDataRow er: list)
        {
            Date dt = null;
            CookedOrderEventDataRow cr = (CookedOrderEventDataRow) er;
            if (cr.getTime() == 0)
                continue;
            int roundedTime = (cr.getTime() + 59) / 60;
            try
            {
                dt = dateFormat.parse(dateFormat.format(er.getDate()));
            }
            catch (ParseException pe) {}

            if (!map.containsKey(dt))
            {
                Map<String,Integer> cookInfo = new TreeMap<>();
                cookInfo.put(cr.getCookName(),roundedTime);
                map.put(dt,cookInfo);
            }
            else
            {
                Map<String,Integer> cookInfo = map.get(dt);

                if (!cookInfo.containsKey(cr.getCookName()))
                {
                    cookInfo.put(cr.getCookName(),roundedTime);
                }
                else
                {
                    cookInfo.put(cr.getCookName(),cookInfo.get(cr.getCookName()) + roundedTime);
                }
                map.put(dt,cookInfo);
            }
        }
        return map;
    }


    private static class StatisticStorage
    {
        private  Map<EventType,List<EventDataRow>> map;

        public StatisticStorage()
        {
            map = new HashMap<>();
            for (EventType event: EventType.values())
            {
                map.put(event,new ArrayList<EventDataRow>());
            }
        }

        private void put(EventDataRow data)
        {
            map.get(data.getType()).add(data);
        }

        private List<EventDataRow> get(EventType eventType )
        {
            return map.get(eventType);
        }

    }
}