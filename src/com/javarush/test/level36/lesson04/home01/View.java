package com.javarush.test.level36.lesson04.home01;

import java.util.List;

/**
 * Created by stas on 10/14/16.
 */
public class View
{
   Controller controller = new Controller();

    public void fireEventShowData() {
        System.out.println(controller.onDataListShow());
    }

}
