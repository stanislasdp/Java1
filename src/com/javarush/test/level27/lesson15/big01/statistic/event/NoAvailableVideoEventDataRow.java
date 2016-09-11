package com.javarush.test.level27.lesson15.big01.statistic.event;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by stas on 9/11/16.
 */
public class NoAvailableVideoEventDataRow implements EventDataRow
{
    private Date currentDate;
    private int totalDuration;

   public NoAvailableVideoEventDataRow(int totalDuration)
    {
     currentDate = new Date();
        this.totalDuration = totalDuration;
    }

    @Override
    public EventType getType()
    {
        return EventType.NO_AVAILABLE_VIDEO;
    }

    @Override
    public Date getDate()
    {
        return currentDate;
    }

    @Override
    public int getTime()
    {
        return totalDuration;
    }
}
