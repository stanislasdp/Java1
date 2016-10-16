package com.javarush.test.level37.lesson04.big01.female;

import com.javarush.test.level37.lesson04.big01.AbstractFactory;
import com.javarush.test.level37.lesson04.big01.Human;
import com.javarush.test.level37.lesson04.big01.male.KidBoy;
import com.javarush.test.level37.lesson04.big01.male.Man;
import com.javarush.test.level37.lesson04.big01.male.TeenBoy;

/**
 * Created by stas on 10/16/16.
 */
public class FemaleFactory implements AbstractFactory
{
    public Human getPerson (int age )
    {
        Human human = null;
        if (age <= KidGirl.MAX_AGE )
        {
            human = new KidGirl();
        }
        else if (age <= TeenGirl.MAX_AGE)
        {
            human = new TeenGirl();
        }
        else
        {
            human = new Woman();
        }
        return human;
    }
}
