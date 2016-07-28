package com.javarush.test.level25.lesson02.task02;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/* Машину на СТО не повезем!
Инициализируйте поле wheels используя данные из loadWheelNamesFromDB.
Обработайте некорректные данные.
Подсказка: если что-то не то с колесами, то это не машина!
Сигнатуры не менять.
*/
public class Solution 
{
    public static enum Wheel 
    {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() 
        {
        //	wheels = new ArrayList<>();
        	try
        	{
        		for (String st : loadWheelNamesFromDB()) 
            	{
    				wheels.add(Wheel.valueOf(st));
    			}
        	}
        	catch (IllegalArgumentException ie)
        	{
        		return;
        	}
        	
        	for (Wheel wheel : wheels) 
        	{
        		System.out.println(wheel);
				
			}
        	
            //init wheels here
        }

        protected String[] loadWheelNamesFromDB() 
        {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
        
}
    
    public static void main(String...args)
    {
    	Solution.Car car = new Solution.Car();
    }
	
}
