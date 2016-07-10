package com.javarush.test.level22.lesson09.task02;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution {

    public static StringBuilder getCondition(Map<String, String> params)
    {
        StringBuilder sb = new StringBuilder();
        boolean add_and = true;
        int and_count = 0;
        int null_count = 0;

       for (Map.Entry<String,String> pair: params.entrySet())
        {


            if (pair.getValue()!=null && pair.getKey()!=null)
            {

                if (!add_and)
                {
                    sb.append(" and ");

                }
                sb.append(pair.getKey());
                sb.append(" = '");
                sb.append(pair.getValue());
                sb.append("'");
                add_and = false;

            }
            else
            {
                null_count++;
            }

        }


        return sb;
    }

    public static void main(String[] args)
    {
        Map<String,String> map_test = new LinkedHashMap<>();
        map_test.put("1","1");
        map_test.put("2","2");
        map_test.put("3","3");
        map_test.put("4","4");


        System.out.println(getCondition(map_test).toString());
    }
}
