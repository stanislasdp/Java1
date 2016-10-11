package com.javarush.test.level34.lesson15.big01.model;

import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by stas on 10/10/16.
 */
public class LevelLoader
{
    private Path levels;

    public LevelLoader(Path levels)
    {
        this.levels = levels;
    }

   public GameObjects getLevel(int level)
   {
       Player player = new Player(80,60);
       Set<Home> home = new HashSet<>();
       home.add(new Home(80,100));
       Set<Box> box = new HashSet<Box>();
       box.add(new Box(80,80));
       Set<Wall> walls = new HashSet<Wall>();
       walls.add(new Wall(20,20));
       walls.add(new Wall(20,40));
       return new GameObjects(walls,box,home,player);
   }
}
