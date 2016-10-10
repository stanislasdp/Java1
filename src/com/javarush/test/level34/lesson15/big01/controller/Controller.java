package com.javarush.test.level34.lesson15.big01.controller;

import com.javarush.test.level34.lesson15.big01.model.Direction;
import com.javarush.test.level34.lesson15.big01.model.Model;
import com.javarush.test.level34.lesson15.big01.view.View;

/**
 * Created by stas on 10/10/16.
 */
public class Controller implements EventListener
{
    private View view;
    private Model model;

    public Controller()
    {
        view = new View(this);
        view.init();
        model = new Model();
    }

    public static void main(String[] args)
    {
        Controller controller = new Controller();
    }

    @Override
    public void move(Direction direction)
    {

    }

    @Override
    public void restart()
    {

    }

    @Override
    public void startNextLevel()
    {

    }

    @Override
    public void levelCompleted(int level)
    {

    }
}
