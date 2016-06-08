package com.javarush.test.level14.lesson08.home05;

/**
 * Created by stas on 6/8/16.
 */
public class Computer
{
    private Keyboard keyboard=null;
    private Mouse mouse=null;
    private Monitor monitor =null;

    public Computer()
    {
        this.keyboard = new Keyboard();
        this.mouse = new Mouse();
        this.monitor = new Monitor();
    }

    public Mouse getMouse()
    {
        return mouse;
    }

    public Keyboard getKeyboard()
    {
        return keyboard;
    }

    public Monitor getMonitor()
    {
        return monitor;
    }
}