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
    Controller controller;
    private String filePath = "./src/" +this.getClass().getPackage().getName()+ File.separator + "vacancies.html";
//            Задание 13
//
//    Смотри, в пакете view появились два новых файла:
//    vacancies.html - будешь в него записывать данные
//    backup.html - дубликат vacancies.html для восстановления, вдруг данные в vacancies.html сотрутся
//
//    Стань слева в дереве проекта на vacancies.html, нажми правой клавишой мыши, далее "Open in Browser".
//    Так будешь смотреть результат своего парсинга.
//
//    Пора заняться отображением вакансий.
//        1. В методе update класса HtmlView реализуй следующую логику:
//        1.1. сформируй новое тело файла vacancies.html, которое будет содержать вакансии
//    1.2. запиши в файл vacancies.html его обновленное тело
//    1.3. Все исключения должны обрабатываться в этом методе - выведи стек-трейс, если возникнет исключение.
//
//    2. Для реализации п.1 создай два пустых private метода:
//    String getUpdatedFileContent(List<Vacancy>), void updateFile(String)
//    Реализовывать их логику будем в следующих заданиях.
//
//    3. Чтобы добраться до файла vacancies.html, сформируй относительный путь к нему
//    В классе HtmlView создай приватное строковое final поле filePath, присвой ему относительный путь к vacancies.html.
//    Путь должен быть относительно корня проекта JavaRushHomeWork.
//    Формируй путь динамически используя this.getClass().getPackage() и разделитель "/"
//    Подсказка: путь должен начинаться с "./"

    @Override
    public void update(List<Vacancy> vacancies)
    {
        System.out.println(vacancies.size());
        System.out.println(filePath);
        File file = new File(filePath);
        System.out.println(file.exists());
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

    public void updateFile(String s)
    {

    }


}
