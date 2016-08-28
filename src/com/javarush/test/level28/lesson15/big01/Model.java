package com.javarush.test.level28.lesson15.big01;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stas on 8/24/16.
 */
public class Model
{
    View view;
    Provider[] providers;

    public Model(View view, Provider[] providers)
    {

        if (view == null || providers == null || providers.length == 0)
            throw new IllegalArgumentException();
        this.view = view;
        this.providers = providers;
    }

    public void selectCity(String city)
    {
        List vacancies = new ArrayList();

        for (Provider provider : providers)
        {
            vacancies.addAll(provider.getJavaVacancies(city));
        }
        view.update(vacancies);
    }
}


