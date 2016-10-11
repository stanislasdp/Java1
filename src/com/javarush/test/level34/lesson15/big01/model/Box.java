package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;

/**
 * Created by stas on 10/10/16.
 */
public class Box extends CollisionObject implements Movable
{
    public Box (int x, int y)
    {
        super(x,y);
    }

    @Override
    public void draw(Graphics graphics)
    {
        graphics.setColor(Color.BLUE);
        graphics.fillRect(getX()-getWidth()/2,getY()-getHeight()/2,getWidth(),getHeight());
    }

    @Override
    public void move(int x, int y)
    {
        super.setX(super.getX() + x);
        super.setY(super.getY() + y);
    }
}
