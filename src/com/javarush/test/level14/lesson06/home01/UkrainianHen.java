package com.javarush.test.level14.lesson06.home01;

/**
 * Created by stas on 6/6/16.
 */
public class UkrainianHen extends Hen
{
    int N;
    @Override
    int getCountOfEggsPerMonth()
    {
        return 1;
    }
    @Override
   String getDescription()
    {
        return super.getDescription()+" Моя страна - "+Country.UKRAINE+". Я несу "+getCountOfEggsPerMonth()+" яиц в месяц.";
    }
}
