package com.javarush.test.level27.lesson15.big01.statistic;

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
public class StatisticManager
{
    private static StatisticManager ourInstance = new StatisticManager();
    private final StatisticStorage storage = new StatisticStorage();
    private Set<Cook> cookSet = new HashSet<Cook>();

    public static StatisticManager getInstance()
    {
        return ourInstance;
    }

    private StatisticManager() {}

    public void register(EventDataRow data)
    {
        storage.put(data);
    }

    public void register(Cook cook)
    {
        cookSet.add(cook);
    }

    public Map<Date,Double> getVideoSelectedProfit()
    {
        List<EventDataRow> list = storage.get(EventType.SELECTED_VIDEOS);
        Map<Date,Double> maps = new TreeMap<>(Collections.reverseOrder());

        for (EventDataRow er: list)
        {
            VideoSelectedEventDataRow vr = (VideoSelectedEventDataRow)er;
            if (!maps.containsKey(vr.getDate()))
            {
                maps.put(vr.getDate(),(double)vr.getAmount()* 0.01);
            }
            else
            {
                maps.put(vr.getDate(),maps.get(vr.getDate()) + (double)vr.getAmount()* 0.01);
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
            try
            {
                dt = dateFormat.parse(dateFormat.format(er.getDate()));
            }
            catch (ParseException pe) {}

            CookedOrderEventDataRow cr = (CookedOrderEventDataRow) er;
            if (!map.containsKey(dt))
            {
                Map<String,Integer> cookInfo = new TreeMap<>();
                cookInfo.put(cr.getCookName(),cr.getTime());
                map.put(cr.getDate(),cookInfo);

            }
            else
            {
                Map<String,Integer> cookInfo = map.get(dt);

                if (!cookInfo.containsKey(cr.getCookName()))
                {;

                    cookInfo.put(cr.getCookName(),cr.getTime());
                }
                else
                {
                    cookInfo.put(cr.getCookName(),cookInfo.get(cr.getCookName() + cr.getTime()));
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
