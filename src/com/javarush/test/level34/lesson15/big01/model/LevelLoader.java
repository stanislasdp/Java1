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
       Player player = new Player(Model.FIELD_SELL_SIZE /2 *5, Model.FIELD_SELL_SIZE /2 * 6);
       Set<Home> home = new HashSet<>();
       home.add(new Home(Model.FIELD_SELL_SIZE /2 * 2 ,Model.FIELD_SELL_SIZE /2 * 3));
       Set<Box> box = new HashSet<Box>();
       box.add(new Box(Model.FIELD_SELL_SIZE/2 * 4,Model.FIELD_SELL_SIZE /2 ));
       Set<Wall> walls = new HashSet<Wall>();
       walls.add(new Wall(Model.FIELD_SELL_SIZE /2 * 2, Model.FIELD_SELL_SIZE /2));
       walls.add(new Wall(Model.FIELD_SELL_SIZE /2 , Model.FIELD_SELL_SIZE /2 * 2));
       return new GameObjects(walls,box,home,player);
   }
}
