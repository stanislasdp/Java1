package com.javarush.test.level10.lesson11.home04;

/* Большая зарплата
Вывести на экран надпись «Я не хочу изучать Java, я хочу большую зарплату» 40 раз по образцу.
Образец:
Я не хочу изучать Java, я хочу большую зарплату
 не хочу изучать Java, я хочу большую зарплату
не хочу изучать Java, я хочу большую зарплату
е хочу изучать Java, я хочу большую зарплату
 хочу изучать Java, я хочу большую зарплату
хочу изучать Java, я хочу большую зарплату
…
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        String s = "Я не хочу изучать Java, я хочу большую зарплату";
        ArrayList<Character> ch = new ArrayList<Character>();

        for (Character i:s.toCharArray())
        {
            ch.add(i);
        }


        for (int i=0;i<40;i++)
        {
          for(int j=0;j<ch.size();j++)
          {
              System.out.print(ch.get(j));

          }
            System.out.println("");


            ch.remove(0);
        }
    }

}
