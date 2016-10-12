package com.javarush.test.level34.lesson15.big01.model;

import java.io.*;
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
        int tmpLevel = level % 60;
        if (tmpLevel == 0)
        {
            tmpLevel = 60;
        }
        int cellSize = Model.FIELD_SELL_SIZE;
        int x0 = cellSize / 2;
        int y0 = cellSize / 2;

        Set<Wall> walls = new HashSet<>();
        Set<Box> boxes = new HashSet<>();
        Set<Home> homes = new HashSet<>();
        Player player = null;


        try (BufferedReader bf = new BufferedReader(new FileReader(levels.toFile()));)
        {

            while (!bf.readLine().contains("Maze: " + tmpLevel));

            bf.readLine();
            bf.readLine();
            //skip redundant lines with offset
            String lineWithHeigth = bf.readLine();
            int length = Integer.parseInt(lineWithHeigth.substring(lineWithHeigth.lastIndexOf(" ")+1));
            bf.readLine();
            bf.readLine();
            bf.readLine();
            for (int i=0;i<length;i++)
            {
                String read = bf.readLine();
                for (int j=0; j <read.length(); j++)
                {
                    switch (read.charAt(j))
                    {
                        case 'X':
                            walls.add(new Wall(x0+j * cellSize, y0 + i* cellSize));
                            break;
                        case '*':
                            boxes.add(new Box(x0+ j * cellSize, y0 + i*cellSize));
                            break;
                        case '.':
                            homes.add(new Home(x0 + j * cellSize, y0 + i *cellSize));
                            break;
                        case '&':
                            boxes.add(new Box(x0+ j * cellSize, y0 + i * cellSize));
                            homes.add(new Home(x0 + j * cellSize, y0 + i *cellSize));
                            break;
                        case '@':
                            player = new Player(x0 + j * cellSize, y0 + i *cellSize);
                            break;
                    }
                }
            }

        }
        catch (IOException ie)
        {
            ie.printStackTrace();
        }
        return new GameObjects(walls,boxes,homes,player);


    }

}
