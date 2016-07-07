package com.javarush.test.level22.lesson05.task02;

import java.util.ArrayList;
import java.util.StringTokenizer;

/* Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {

        if (string==null)
        {
            throw  new TooShortStringException();
        }
       int first_tab = string.indexOf('\t');
       int second_tab = string.indexOf('\t',first_tab+1);

        if (second_tab==-1)
        {
            throw new TooShortStringException();
        }
        return string.substring(first_tab+1,second_tab);



      //  return string.substring(tabs.get(0)-1,tabs.get(1));

    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
     //   System.out.println(getPartOfString("tab0\ttab\ttab1\t"));  +     //tab
      // System.out.println(getPartOfString("\t\t"));                    //
       // System.out.println(getPartOfString("123\t123"));                //Exception
        //System.out.println(getPartOfString(null));                      //Exception
    }
}
