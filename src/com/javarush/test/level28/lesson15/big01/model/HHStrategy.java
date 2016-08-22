package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;

/**
 * Created by stas on 8/21/16.
 */
public class HHStrategy implements Strategy
{
   // private static final String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%d";
    private static final String URL_FORMAT = "http://javarush.ru/testdata/big28data.html";
    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String REFFERER = "https://hh.ua/search/vacancy?text=java+%D0%BA%D0%B8%D0%B5%D0%B2";

    @Override
    public List<Vacancy> getVacancies(String searchString)
    {
        try
        {
          Document  document = Jsoup.connect(URL_FORMAT).userAgent(USER_AGENT).referrer("google.ru").get();


        }
        catch (IOException ie)
        {

        }

        return null;
    }

  protected  Document getDocument(String searchString, int page) throws IOException
    {
      return null;
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
