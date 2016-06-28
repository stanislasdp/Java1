package com.javarush.test.level20.lesson10.home09;

/**
 * Created by stas on 6/28/16.
 */
public class test

{
    public static void main(String[] args)
    {
        int a = Integer.MAX_VALUE;
        StringBuilder s = new StringBuilder();
        System.out.println(a);
        while(a>0) {
            s.insert(0, a%10);
            a = a / 10;
        }
        System.out.println(s.toString());
    }
}
