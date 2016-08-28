package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by stas on 8/21/16.
 */
public class HHStrategy implements Strategy
{
    private static final String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%d";
  //  private static final String URL_FORMAT = "http://javarush.ru/testdata/big28data.html/search/vacancy?text=java+%s&page=%d";


    @Override
    public List<Vacancy> getVacancies(String searchString)
    {
        ArrayList<Vacancy> vacancies = new ArrayList<>();
        try
        {

            int page = 0;

            while (true)
            {
                Document document = getDocument(searchString,page++);
                if (document==null)
                    break;
                Elements elements = document.getElementsByAttributeValue("data-qa","vacancy-serp__vacancy");
                if (elements.size()==0)
                {
                    break;
                }

                for (Element element: elements)
                {
                    Vacancy vacancy = new Vacancy();
                    vacancy.setTitle(element.getElementsByAttributeValue("data-qa","vacancy-serp__vacancy-title").text());
                    String salary =   element.getElementsByAttributeValue("data-qa","vacancy-serp__vacancy-compensation").text();
                    vacancy.setSalary(salary!=null?salary:"");
                    vacancy.setCity(element.getElementsByAttributeValue("data-qa","vacancy-serp__vacancy-address").text());
                    vacancy.setCompanyName(element.getElementsByAttributeValue("data-qa","vacancy-serp__vacancy-employer").text());
                    vacancy.setUrl(element.getElementsByAttributeValue("data-qa","vacancy-serp__vacancy-title").attr("href"));
                    vacancy.setSiteName("http://hh.ua");
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

  protected  Document getDocument(String searchString, int page) throws IOException
    {
        String USER_AGENT = "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:48.0) Gecko/20100101 Firefox/48.0";
        String Url = String.format(URL_FORMAT,searchString,page);
        return Jsoup.connect(Url).userAgent(USER_AGENT).referrer("google.ru").get();
    }

      /* Задание 8

        Запусти снова программу в дебаг моде.
        Скопируй полученное значение document.html() в созданный ранее html файл.
            Отформатируй его и найди теги с вакансиями.

        Почитай в Сообществе дополнительный материал к лекции про селекторы атрибута.

        ВНИМАНИЕ: ОСОБЕННОСТИ ТЕСТИРОВАНИЯ!
            HTML код странички ХэдХантера может меняться, чтобы эта задача продолжила работать стабильно не меняя тесты
        воспользуйся закешированной версией http://javarush.ru/testdata/big28data.html
        Это только для этого пункта, в следующих заданиях используй реальные страницы.

        1. В классе HHStrategy создай protected метод Document getDocument(String searchString, int page) throws IOException.

        2. Реализуй следующую логику метода getVacancies в классе HHStrategy:
        2.1. Приконнекться к закешированной страничке ХэдХантера используя метод getDocument, нумерация начинается с 0.
        2.2. Получи список элементов с атрибутом "vacancy-serp__vacancy". Должно быть до 20 вакансий на странице.
        2.3. Если данные в списке из п.2.2. есть, то для каждого элемента:
    2.3.1. создать вакансию и заполнить все ее данные, получив данные из текущего элемента.
        Если тег с зарплатой присутствует, то заполнить и поле salary, иначе инициализировать поле пустой строкой.
        2.4. Выполнить п.2.1-2.3 для следующей страницы ХэдХантера.
        2.5. Если закончились страницы с вакансиями, то выйти из цикла.

            Исключения игнорировать.
            Все вакансии добавить в общий список и вернуть в качестве результата метода.

            Подсказка по зарплате:
        Поиграйся с URL_FORMAT, добавь туда еще один параметр, чтобы получить вакансии с зарплатами.
        Проанализируй полученный html и найди тег для зарплат*/
}
