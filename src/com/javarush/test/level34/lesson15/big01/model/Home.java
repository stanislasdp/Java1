package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;

/**
 * Created by stas on 10/10/16.
 */
public class Home extends GameObject
{
    public Home(int x, int y)
    {
        super(x,y,2,2);
    }
    @Override
    public void draw(Graphics graphics)
    {
        graphics.setColor(Color.GREEN);
        graphics.drawArc(getX(),getY(),super.getWidth(),getHeight(),0,360);
    }
}
