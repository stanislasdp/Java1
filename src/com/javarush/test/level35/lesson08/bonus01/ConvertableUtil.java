package com.javarush.test.level35.lesson08.bonus01;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertableUtil {

    public static Map convert(List<? extends Convertable> list)
    {

        Map<Object,Convertable> result = new HashMap<Object,Convertable>();

        for (Convertable el: list)
        {
                result.put(el.getKey(),el);
        }

        return result;
    }
}
