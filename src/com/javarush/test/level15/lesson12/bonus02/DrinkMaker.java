package com.javarush.test.level15.lesson12.bonus02;

/**
 * Created by stas on 6/11/16.
 */
public abstract class DrinkMaker
{
    abstract void getRightCup();
    abstract void putIngredient();
    abstract void pour();

    void makeDrink()
    {
        getRightCup();
        putIngredient();
        pour();
    }



}
