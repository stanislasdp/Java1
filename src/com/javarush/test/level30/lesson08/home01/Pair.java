package com.javarush.test.level30.lesson08.home01;

public class Pair {
    private int x;
    private int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("x=%d, y=%d", x, y);
    }

    public void swap()
    {
        //x=4 y=5
        //x =100
        //y = 101
        x=x^y;//XOR excluding or
        //x=001
        //y=101
        y=y^x;
        //x=001
        //y=101
        x = x^y;
        //x=100
        //y=101
    }
}
