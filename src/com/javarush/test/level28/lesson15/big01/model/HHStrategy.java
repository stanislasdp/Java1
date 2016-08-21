package com.javarush.test.level28.lesson15.big01.model;

/**
 * Created by stas on 8/21/16.
 */
public class HHStrategy implements Strategy
{
    private static final String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%d";

    @Override
    public void getVacancies(String searchString)
    {

    }
}
