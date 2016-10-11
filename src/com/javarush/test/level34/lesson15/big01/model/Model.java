package com.javarush.test.level34.lesson15.big01.model;

import com.javarush.test.level34.lesson15.big01.controller.EventListener;

import java.nio.file.Paths;

/**
 * Created by stas on 10/10/16.
 */
public class Model
{
 private EventListener eventListener;
	private GameObjects gameObjects;
	private int currentLevel = 1;
	private LevelLoader levelLoader = new LevelLoader(Paths.get("..\\res\\levels.txt"));
	public static int FIELD_SELL_SIZE = 20;

	public void setEventListener(EventListener eventListener)
	{
		this.eventListener = eventListener;
	}

	public GameObjects getGameObjects()
	{
		return gameObjects;
	}

	public void restartLevel(int level)
	{
		gameObjects = levelLoader.getLevel(level);
	}

	public void restart()
	{
		restartLevel(currentLevel);
	}

	public void startNextLevel()
	{
		restartLevel(++currentLevel);
	}
	
	public void move (Direction direction)
	{
	}
	
	public boolean checkWallCollision(CollisionObject gameObject, Direction direction)
	{
			for (Wall wall: gameObjects.getWalls())
			{
				if (gameObject.isCollision(wall, direction))
				{
					return true;
				}
			}
			return false;
	}
	
	public boolean checkBoxCollision(Direction direction)
	{
		Player player = gameObjects.getPlayer();
		Set<Wall> walls = gameObjects.getWalls();
		Set<Box> boxes = gameObjects.getBoxes();
		
		return false;
	}
}
