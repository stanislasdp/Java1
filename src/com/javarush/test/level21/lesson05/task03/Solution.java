package com.javarush.test.level21.lesson05.task03;

import java.util.Date;

/* Ошибка в equals/hashCode
Исправьте ошибки реализаций методов equals и hashCode для класса Solution
*/
public class Solution {
    private int anInt;
    private String string;
    private double aDouble;
    private Date date;
    private Solution solution;

    public Solution(int anInt, String string, double aDouble, Date date, Solution solution) {
        this.anInt = anInt;
        this.string = string;
        this.aDouble = aDouble;
        this.date = date;
        this.solution = solution;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Solution)) return false;

        Solution solution1 = (Solution) o;

        if (anInt != solution1.anInt) return false;
        if (Double.compare(solution1.aDouble, aDouble) != 0) return false;
        System.out.println("String "+string.equals(solution1.string));
        if (string != null ? !string.equals(solution1.string) : solution1.string == null) return false;
        System.out.println("Date "+date.equals(solution1.date));
        if (date != null ? !date.equals(solution1.date) : solution1.date == null) return false;
            System.out.println("Solution "+solution.equals(solution1.solution));
        if (solution != null ? !solution.equals(solution1.solution) : solution1.solution == null) return false;




        return true;
    }

    @Override
    public int hashCode()
    {
        int result;
        long temp;
        result = anInt;
        result = 31*result+(string!=null?string.hashCode():0);
        temp = aDouble != +0.0d ? Double.doubleToLongBits(aDouble) : 0L;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31*result+(date!=null?date.hashCode():0);
        result = 31 * result + (solution != null ? solution.hashCode() : 0);
        return result;
    }

    public static void main(String[] args)
    {
        Solution so = new Solution(14,"13",13.0,new Date(),new Solution(14,"13",13.0,new Date(),null));
        Solution sol = new Solution(14,"13",13.0,new Date(),new Solution(14,"13",13.0,new Date(),null));
        Solution sol1 = new Solution(14,"13",13.0,new Date(),sol);
        Solution sol2 = new Solution(14,"13",13.0,new Date(),sol);

        System.out.println(sol1.equals(sol2));
       System.out.println(sol1.hashCode());
        System.out.println(sol2.hashCode());
    }


}
