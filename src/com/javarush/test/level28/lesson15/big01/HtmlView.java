package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.*;
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
       // System.out.println(vacancies.size());
        try
        {
            Document document = getDocument();
           // System.out.println(document.toString());
            Element element = document.getElementsByClass("template").first();
           // System.out.println(element.text());
            Element cloneElement = element.clone();
            cloneElement.removeAttr("style");
            cloneElement.removeClass("template");
            //System.out.println(cloneElement.toString());
            document.select("tr[class=vacancy]").remove();

            for (Vacancy vacancy: vacancies)
            {
                Element forNewVacancy = cloneElement.clone();
               // System.out.println(forNewVacancy.toString());
                forNewVacancy.getElementsByClass("city").first().text(vacancy.getCity());
                //System.out.println(vacancy.getTitle()+" "+vacancy.getSalary()+"  "+vacancy.getUrl());
                forNewVacancy.getElementsByClass("companyName").first().text(vacancy.getCompanyName());
                forNewVacancy.getElementsByClass("salary").first().text(vacancy.getSalary());
                Element forTitle = forNewVacancy.getElementsByTag("a").first();
                forTitle.text(vacancy.getTitle());
                forTitle.attr("href",vacancy.getUrl());
                element.before(forNewVacancy.outerHtml());
            }
            return document.html();
        }
        catch (IOException ie)
        {
            ie.printStackTrace();
            return "Some exception occurred";
        }



    }


    public void updateFile(String string)
    {
        try
        {
            FileWriter fileWriter = new FileWriter(new File(filePath));
            fileWriter.write(string);
            fileWriter.flush();
            fileWriter.close();
        }
        catch (IOException ie)
        {
            ie.printStackTrace();
        }

    }

    protected Document getDocument() throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        StringBuilder sb = new StringBuilder();
        while (br.ready())
        {
            sb.append(br.readLine());
        }
        br.close();
        return Jsoup.parse(sb.toString(),"UTF-8");
    }

}
