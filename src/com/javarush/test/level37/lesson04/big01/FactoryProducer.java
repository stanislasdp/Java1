package com.javarush.test.level37.lesson04.big01;

import com.javarush.test.level37.lesson04.big01.female.FemaleFactory;
import com.javarush.test.level37.lesson04.big01.male.MaleFactory;

/**
 * Created by stas on 10/16/16.
 */
public class FactoryProducer
{
    public enum HumanFactoryType
    {
        MALE, FEMALE;
    }

    public static AbstractFactory getFactory(HumanFactoryType humanFactoryType)
    {
        AbstractFactory concreteFactory = null;
        switch (humanFactoryType)
        {
            case MALE:
                concreteFactory =  new MaleFactory();
            break;
            case FEMALE:
                concreteFactory = new FemaleFactory();
            break;
        }
        return concreteFactory;
    }
}
