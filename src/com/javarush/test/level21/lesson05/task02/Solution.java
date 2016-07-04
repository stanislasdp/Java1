package com.javarush.test.level21.lesson05.task02;

import java.util.HashSet;
import java.util.Set;

/* Исправить ошибку
Сравнение объектов Solution не работает должным образом. Найти ошибку и исправить.
Метод main не участвует в тестировании.
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public boolean equals(Object o)
    {

        if (o==this)
        {
            return true;
        }
        else if (o==null || o.getClass() != this.getClass())
        {
            return false;
        }

        else
        {
            Solution n = (Solution)o;
            boolean firstPart = (first!=null?first.equals(n.first):n.first==null);
            boolean secondpart = (last!=null?last.equals(n.last):n.last==null);

            return  firstPart&&secondpart;

        }
    }

    @Override
    public int hashCode()
    {
        return 31 + (first==null?0:first.hashCode())+(last==null?0:last.hashCode());
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }
}
