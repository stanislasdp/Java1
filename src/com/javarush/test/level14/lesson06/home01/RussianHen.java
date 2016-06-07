package com.javarush.test.level14.lesson06.home01;

/**
 * Created by stas on 6/6/16.
 */
public class RussianHen extends  Hen
{
    int N;
    @Override
    int getCountOfEggsPerMonth()
    {
        return 2;
    }
    @Override
    String getDescription()
    {
        return super.getDescription()+" Моя страна - "+Country.RUSSIA+". Я несу "+getCountOfEggsPerMonth()+" яиц в месяц.";
    }
}
