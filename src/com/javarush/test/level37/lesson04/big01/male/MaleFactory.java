package com.javarush.test.level37.lesson04.big01.male;

import com.javarush.test.level37.lesson04.big01.AbstractFactory;
import com.javarush.test.level37.lesson04.big01.Human;
import com.javarush.test.level37.lesson04.big01.male.KidBoy;
import com.javarush.test.level37.lesson04.big01.male.Man;
import com.javarush.test.level37.lesson04.big01.male.TeenBoy;

/**
 * Created by stas on 10/16/16.
 */
public class MaleFactory implements AbstractFactory
{
    public Human getPerson (int age )
    {
        Human human = null;
        if (age <= KidBoy.MAX_AGE)
        {
            human = new KidBoy();
        }
        else if (age <= TeenBoy.MAX_AGE)
        {
            human = new TeenBoy();
        }
        else
        {
            human = new Man();
        }
        return human;
    }
}
