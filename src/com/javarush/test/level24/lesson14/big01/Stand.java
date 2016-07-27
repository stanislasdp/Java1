package com.javarush.test.level24.lesson14.big01;

/**
 * Created by stas on 7/26/16.
 */

  public class Stand extends BaseObject
	{
	    private double speed;
	    private double direction;

	    protected Stand(double x, double y)
	    {
	        super(x, y, 3);
	        speed = 1;
	        direction = 0;
	    }

	    public double getDirection()
	    {
	        return direction;
	    }

	    public double getSpeed()
	    {
	        return speed;
	    }


	    @Override
	    public void move()
	    {
	    	x+=direction * speed;
	    	checkBorders(radius, Arcanoid.game.getWidth(), radius, Arcanoid.game.getHeight());
	    	
	    }

	     @Override
	    public void draw (Canvas canvas )
	    {

	    }

	   /* Задание 16
	    И наконец "подставка"!
	    Ей понадобятся такие переменные
	    а) speed (скорость шарика) типа double
	    б) direction (направление движения по оси x: 1 - вправо, -1 - влево) типа double
	    в) создай для них геттеры
	    А еще с тебя конструктор, примерно вот такой:
	    public Stand(double x, double y)
	    {
	        super(x,y,3);
	        speed = 1;
	        direction = 0;
	    }*/
	   /* Задание 17
	    Но и это еще не все
	    Еще нужны методы:
	    а) move  - см. move в BaseObject
	    Движение доски осуществляется горизонтально, поэтому мы меняем только координату х.
	        Подумай, как координата х зависит от направления (direction) и скорости (speed). Реализуй зависимость.
	    б) draw  - см. draw в BaseObject
	    Его кодом я займусь сам.
	        в) moveLeft() - задает постоянное движение "подставки" влево
	    Просто присвой правильное значение переменной direction и все.
	    г) moveRight() - задает постоянное движение "подставки" вправо
	    Просто присвой правильное значение переменной direction и все.*/
	
}
