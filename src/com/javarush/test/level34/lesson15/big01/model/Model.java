package com.javarush.test.level34.lesson15.big01.model;

import com.javarush.test.level34.lesson15.big01.controller.EventListener;

import javax.swing.*;
import java.nio.file.Paths;
import java.util.Set;

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

	public void move(Direction direction)
	{
		Player player  = gameObjects.getPlayer();

		if (checkWallCollision(player,direction))
		{
			return;
		}
		if (checkBoxCollision(direction))
		{
			return;
		}
		switch (direction)
		{
			case LEFT:
				player.move(-Model.FIELD_SELL_SIZE, 0);
				break;
			case RIGHT:
				player.move(Model.FIELD_SELL_SIZE, 0);
				break;
			case UP:
				player.move(0, -Model.FIELD_SELL_SIZE);
				break;
			case DOWN:
				player.move(0, Model.FIELD_SELL_SIZE);
		}
		checkCompletion();
	}

	public boolean checkWallCollision(CollisionObject gameObject, Direction direction)
	{
		for (Wall wall : gameObjects.getWalls())
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

		GameObject collided = null;

		for (GameObject go : gameObjects.getAll())
		{
			if (!(go instanceof Player) && player.isCollision(go, direction))
			{
				collided = go;
			}
			if (collided != null && collided instanceof Box)
			{
				Box stopBox = (Box) collided;
				if (checkWallCollision(stopBox, direction))
				{
					return true;
				}

				for (Box boxes : gameObjects.getBoxes())
				{
					if (stopBox.isCollision(boxes, direction))
					{
						return true;
					}
				}

				switch (direction)
				{
					case LEFT:
						stopBox.move(-Model.FIELD_SELL_SIZE, 0);
						break;
					case RIGHT:
						stopBox.move(Model.FIELD_SELL_SIZE, 0);
						break;
					case UP:
						stopBox.move(0, -Model.FIELD_SELL_SIZE);
						break;
					case DOWN:
						stopBox.move(0, Model.FIELD_SELL_SIZE);
				}
			}
		}
		return false;
	}

	public void checkCompletion()
	{
		int boxesOnHomesCount = 0;

		for (Home home: gameObjects.getHomes())
		{
			for (Box box: gameObjects.getBoxes())
			{
				if (box.getX() == home.getX() && box.getY()==home.getY())
				{
					boxesOnHomesCount++;
				}
			}

		}

		if (boxesOnHomesCount == gameObjects.getHomes().size())
		{
          eventListener.levelCompleted(currentLevel);
		}
	}
}
