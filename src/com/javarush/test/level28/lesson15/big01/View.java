package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.util.List;

/**
 * Created by stas on 8/24/16.
 */
public interface View
{
    void update(List<Vacancy> vacancies);

    void setController(Controller controller);
}

