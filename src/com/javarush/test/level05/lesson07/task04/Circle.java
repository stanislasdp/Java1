package com.javarush.test.level05.lesson07.task04;

/* Создать класс Circle
Создать класс (Circle) круг, с тремя инициализаторами:
- centerX, centerY, radius
- centerX, centerY, radius, width
- centerX, centerY, radius, width, color
*/

public class Circle
{
    int CenterX;
    int CenterY;
    int Radius;
    int width;
    String Color;

    public void initialize(int CenterX,int CenterY,int Radius)
    {
        this.CenterX=CenterX;
        this.CenterY=CenterY;
        this.Radius=Radius;
    }

    public void initialize(int CenterX,int CenterY,int Radius, int width)
    {
        this.CenterX=CenterX;
        this.CenterY=CenterY;
        this.Radius=Radius;
        this.width=width;

    }

    public void initialize(int CenterX,int CenterY,int Radius, int width,String Color)
    {
        this.CenterX=CenterX;
        this.CenterY=CenterY;
        this.Radius=Radius;
        this.width=width;
        this.Color=Color;

    }

}
