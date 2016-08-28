package com.javarush.test.level28.lesson15.big01;

/**
 * Created by stas on 8/21/16.
 */
public class Aggregator
{
    public static void main(String[] args)
    {
        Provider provider = new Provider(new HHStrategy());

        Provider provider2 = new Provider(new MoikrugStrategy());
        Provider[] providers = {provider,provider2};
        HtmlView view = new HtmlView();//создал view
        Model model = new Model(view,providers);
        Controller controller = new Controller(model);//создал controller
        view.setController(controller);
        view.userCitySelectEmulationMethod();


/*
        3.1. Создай вью, модель, контроллер.
        3.2. Засэть во вью контроллер.*/

    }
}
