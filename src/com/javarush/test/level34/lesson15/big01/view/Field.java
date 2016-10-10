package com.javarush.test.level34.lesson15.big01.view;

import com.javarush.test.level34.lesson15.big01.controller.EventListener;
import com.javarush.test.level34.lesson15.big01.model.Player;

import javax.swing.*;
import java.awt.*;

/**
 * Created by stas on 10/10/16.
 */
public class Field extends JPanel
{

    private View view;
    private EventListener eventListener;
    public Field (View view)
    {
        this.view = view;
    }

    @Override
    public void paint(Graphics g)
    {
      //  new Player(3,3).draw(g);
    }

    public void setEventListener(EventListener eventListener)
    {
        this.eventListener = eventListener;
    }
}
