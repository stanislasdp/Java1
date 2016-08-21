package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.Provider;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by stas on 8/21/16.
 */
public class Controller
{

    private Provider[] providers;


    public Controller(Provider...providers)
    {
        if (providers==null || providers.length==0)
        {
            throw new IllegalArgumentException();
        }
        this.providers = providers;
    }

    @Override
    public String toString()
    {
        return "Controller{" +
                "providers=" + Arrays.toString(providers) +
                '}';
    }

    public void scan()
    {
        List<Vacancy> vacancies = new ArrayList<>();

            for (int i = 0; i< providers.length;i++)
            {
                try
                {
                    vacancies.addAll(providers[i].getJavaVacancies("SOME TEXT"));
                }
                catch (NullPointerException ne)
                {

                }

            }
        System.out.println(vacancies.size());

    }
}
