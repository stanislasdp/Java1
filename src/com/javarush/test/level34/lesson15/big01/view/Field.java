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
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getParent().getWidth(), getParent().getHeight());	
		for(GameObject go : view.getGameObjects().getAll())
		{
			go.draw(g);
		}
	}

	public void setEventListener(EventListener eventListener)
	{
		
		this.eventListener = eventListener;
	}
}
