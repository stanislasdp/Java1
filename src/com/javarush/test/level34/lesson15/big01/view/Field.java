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
		KeyHandler keyHandler = new KeyHandler();
		this.addKeyListener(keyHandler);
		setFocusable(true);
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
	
	
	public  class KeyHandler extends KeyAdapter
	{
		@Override
		public void keyPressed(KeyEvent e) 
		{
			if (e.getKeyCode() == KeyEvent.VK_LEFT)
			{
				eventListener.move(Direction.LEFT);
			}
			else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			{
				eventListener.move(Direction.RIGHT);
			}
			else if (e.getKeyCode() == KeyEvent.VK_UP)
			{
				eventListener.move(Direction.UP);
			}
			else if (e.getKeyCode() == KeyEvent.VK_DOWN)
			{
				eventListener.move(Direction.DOWN);
			}
			else if (e.getKeyCode() == KeyEvent.VK_R)
			{
				eventListener.restart();
			}
		}
	}
}
