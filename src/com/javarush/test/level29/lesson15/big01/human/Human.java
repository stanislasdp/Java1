package com.javarush.test.level29.lesson15.big01.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Human implements Alive
{
    private static int nextId = 0;
    private int id;
    protected int age;
    protected String name;
    protected Size size;


    public static final int FIRST = 1;
    public static final int SECOND = 2;
    public static final int THIRD = 3;
    public static final int FOURTH = 4;
    private BloodGroup bloodGroup;

    private List<Human> children = new ArrayList<>();

    public void setBloodGroup(BloodGroup bloodGroup)
    {
      this.bloodGroup = bloodGroup;
    }
    public BloodGroup getBloodGroup()
    {
        return  bloodGroup;
    }

    public Human(String name, int age)
    {
        this.id = nextId;
        nextId++;
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void live()
    {

    }

    public int getId() {
        return id;
    }


    public void printSize()
    {
        System.out.println("Рост: " + size.height + " Вес: " + size.weight);
    }

    public List<Human> getChildren()
    {
        return  Collections.unmodifiableList(children);
    }


    public void addChild(Human human)
    {
        children.add(human);
    }

    public void removeChild(Human human)
    {
        children.remove(human);
    }

    public String getPosition()
    {
        return "Человек";
    }

    public void printData()
    {
        System.out.println(getPosition()+": " + name);
    }

    public class Size
    {
        public int height;
        public int weight;
    }

}
