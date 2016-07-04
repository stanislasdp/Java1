package com.javarush.test.level21.lesson05.task01;

import java.util.HashSet;
import java.util.Set;

/* Equals and HashCode
В классе Solution исправить пару методов equals/hashCode в соответствии с правилами реализации этих методов.
Метод main не участвует в тестировании.
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public boolean equals(Object ob)
    {
        if (ob==this)
        {
            return true;
        }
        else if (ob==null || ob.getClass() != this.getClass())
        {
            return false;
        }

        else
        {
            Solution n = (Solution)ob;
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

    public static void main(String[] args)
    {
     //  Set<Solution> s = new HashSet<>();
   //     s.add(new Solution(null, "dd"));
    //  System.out.println(s.contains(new Solution(null, "dd")));
        Solution s1 = new Solution("Donald",null);
        Solution s2 = new Solution("Donald",null);
        System.out.println(s1.equals(s2));
       System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

      /*  eturn id == guest.id && (firstName == guest.firstName || (firstName != null && firstName.equals(guest.getFirstName()))) && (lastName == guest.lastName || (lastName != null && lastName .equals(guest.

            Read more: http://javarevisited.blogspot.com/2011/02/how-to-write-equals-method-in-java.html#ixzz4DSTSr3yC*/
    }
}
