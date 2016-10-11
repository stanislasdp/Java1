package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;

/**
 * Created by stas on 10/10/16.
 */
public class Player extends CollisionObject implements Movable
{
    public Player(int x, int y)
    {
        super(x,y);
    }

    @Override
    public void draw(Graphics graphics)
    {
        graphics.setColor(Color.RED);
        graphics.fillArc(getX()-getWidth()/2,getY()-getHeight()/2,getWidth(),getHeight(),0,360);
    }

    @Override
    public void move(int x, int y)
    {
        super.setX(super.getX() + x);
        super.setY(super.getY() + y);
    }
}
