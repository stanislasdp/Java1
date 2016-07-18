package com.javarush.test.level22.lesson13.task01;

import java.util.ArrayList;
import java.util.StringTokenizer;

/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
*/
public class Solution {
    public static String [] getTokens(String query, String delimiter)
    {
        StringTokenizer st = new StringTokenizer(query,delimiter);
        ArrayList<String> arr= new ArrayList<>();
        while (st.hasMoreElements())
        {
            arr.add((String)(st.nextElement()));
        }
        return arr.toArray(new String[arr.size()]);


    }


    public static void main(String[] args)
    {
        String[] tst =getTokens("level22.lesson13.task01", ".");
        System.out.println(tst[1]);
    }
}
