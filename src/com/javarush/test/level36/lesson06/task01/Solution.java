package com.javarush.test.level36.lesson06.task01;


import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* Найти класс по описанию
1. Реализует интерфейс List
2. Является приватным статическим классом внутри популярного утилитного класса
3. Доступ по индексу запрещен - кидается исключение IndexOutOfBoundsException
4. Используйте рефлекшн, чтобы добраться до искомого класса
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass()
    {

       // return Collections.
        try
        {
            for (Class clazz: Collections.class.getDeclaredClasses())
            {
                if (Modifier.isPrivate(clazz.getModifiers()) &&  Modifier.isStatic(clazz.getModifiers()) && (List.class.isAssignableFrom(clazz)))
                {

                    Constructor constructor = null;
                    try
                    {
                        //get declared constructor. for classes with do defult constructor defined, sim ply ignored
                        constructor = clazz.getDeclaredConstructor();
                        constructor.setAccessible(true);

                    }
                    catch (Exception ex)
                    {
                        continue;
                        //just ignore
                    }


                    //get instance of founded constructor
                    List list = (List) constructor.newInstance();
                    try
                    {
                        ///get all class methods
                        Method[] methods = clazz.getMethods();;

                        for (Method method: methods)
                        {
                            //find get method
                            if (method.getName().equals("get"))
                            {
                                //try to invoke get method
                                list.get(0);
                            }
                        }
                    }
                    catch (IndexOutOfBoundsException ie)
                    {
                        //if get method invokation causes indexofBounds excprion - it's our class!
                        return list.getClass();
                    }
                }
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
}
