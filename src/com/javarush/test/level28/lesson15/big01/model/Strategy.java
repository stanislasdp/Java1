package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.util.List;

/**
 * Created by stas on 8/21/16.
 */
public interface Strategy
{
     List<Vacancy> getVacancies(String searchString);
}
