package com.javarush.test.level28.lesson15.big01.view;

import com.javarush.test.level28.lesson15.big01.Controller;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.io.File;
import java.util.List;

/**
 * Created by stas on 8/24/16.
 */
public class HtmlView implements View
{
  private Controller controller;
    private final String filePath = "./src/" + this.getClass().getPackage().getName().replace('.', '/') + "/vacancies.html";


    @Override
    public void update(List<Vacancy> vacancies)
    {
        try
        {
            updateFile(getUpdatedFileContent(vacancies));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
}

    @Override
    public void setController(Controller controller)
    {
        this.controller = controller;
    }


   public void userCitySelectEmulationMethod()
   {
       controller.onCitySelect("Odessa");
   }

   public String getUpdatedFileContent(List<Vacancy> vacancies)
    {
        return null;
    }


   public void updateFile(String string)
    {

    }

}
