package com.javarush.test.level28.lesson15.big01;

/**
 * Created by stas on 8/21/16.
 */
public class Controller
{
    private Model model;

    public Controller(Model model)
    {
        if (model==null)
          throw new IllegalArgumentException();
        this.model = model;
    }

  public void onCitySelect(String cityName)
  {
      model.selectCity(cityName);

  }

}


