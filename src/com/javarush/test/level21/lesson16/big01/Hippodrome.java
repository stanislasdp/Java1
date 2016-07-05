package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by stas on 7/5/16.
 */
public class Hippodrome
{
    public static Hippodrome game;
    ArrayList<Horse> horses = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException
    {
        game = new Hippodrome();
        Horse horse1 = new Horse("name1",3,0);
        Horse horse2 = new Horse("name2",3,0);
        Horse horse3 = new Horse("name3",3,0);

        game.getHorses().add(horse1);
        game.getHorses().add(horse2);
        game.getHorses().add(horse3);

        game.run();
        game.printWinner();


    }

    public ArrayList<Horse> getHorses()
    {
        return horses;
    }

    public void run() throws InterruptedException
    {
        for (int i = 0; i <100 ; i++)
        {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public  void move()
    {
        for (int i = 0; i <getHorses().size() ; i++)
        {
            getHorses().get(i).move();
        }
    }

    public void print()
    {
        for (int i = 0; i <getHorses().size() ; i++)
        {
            getHorses().get(i).print();
        }

        System.out.println();
        System.out.println();
    }

    public Horse getWinner()
    {
        Horse winner = getHorses().get(0);

        for (int i = 0; i < getHorses().size(); i++)
        {
            if (getHorses().get(i).distance > winner.distance)
            {
                winner = getHorses().get(i);
            }
        }
        return winner;


    }

    public void printWinner()
    {
        System.out.println("Winner is "+getWinner().name+"!");
    }
}
