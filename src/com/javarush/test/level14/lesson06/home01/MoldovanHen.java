package com.javarush.test.level14.lesson06.home01;

/**
 * Created by stas on 6/6/16.
 */
public class MoldovanHen extends Hen
{
    int N;
    @Override
    int getCountOfEggsPerMonth()
    {
        return 3;
    }
    @Override
    String getDescription()
    {
        return super.getDescription()+" Моя страна - "+Country.MOLDOVA+". Я несу "+getCountOfEggsPerMonth()+" яиц в месяц.";
    }
}
