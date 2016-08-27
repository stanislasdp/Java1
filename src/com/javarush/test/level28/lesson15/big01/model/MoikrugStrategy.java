package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by stas on 8/27/16.
 */
public class MoikrugStrategy implements Strategy
{
    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?page=%d&q=java+%s";


    @Override
    public List<Vacancy> getVacancies(String searchString)
    {
        ArrayList<Vacancy> vacancies = new ArrayList<>();
        try
        {
            int page = 1;

            while (true)
            {
                Document document = getDocument(searchString,page++);
                if (document==null)
                    break;
                Elements elements = document.getElementsByClass("job");
                ;
                if (elements.size()==0)
                {
                    break;
                }

                for (Element element: elements)
                {
                    Vacancy vacancy = new Vacancy();
                    vacancy.setTitle(element.getElementsByClass("title").text());
                    String salary =   element.getElementsByClass("count").text();
                    vacancy.setSalary(salary!=null?salary:"");
                    vacancy.setCity(element.getElementsByClass("location").text());
                    vacancy.setCompanyName(element.getElementsByClass("company_name").select("a[href]").text());
                    vacancy.setUrl(element.getElementsByClass("title").select("a").attr("abs:href"));
                    vacancy.setSiteName("https://moikrug.ru");
                    vacancies.add(vacancy);
                }
            }

        }
        catch (IOException io)
        {
            io.printStackTrace();
        }

        return vacancies;
    }


    protected Document getDocument(String searchString, int page) throws IOException
    {
        String USER_AGENT = "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:48.0) Gecko/20100101 Firefox/48.0";
        String Url = String.format(URL_FORMAT,page,searchString);
        System.out.println(Url);
       // String Url = "http://javarush.ru/testdata/big28data2.html";
        //https://moikrug.ru/vacancies?page=2&q=java+Dnepropetrovsk
        return Jsoup.connect(Url).userAgent(USER_AGENT).referrer("google.ru").get();
    }
}
