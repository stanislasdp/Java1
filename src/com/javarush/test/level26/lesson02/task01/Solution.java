package com.javarush.test.level26.lesson02.task01;

import java.util.Arrays;
import java.util.Comparator;

/* Почитать в инете про медиану выборки
Реализовать логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы
Вернуть отсортированный массив от минимального расстояния до максимального
Если удаленность одинаковая у нескольких чисел, то выводить их в порядке возрастания
*/
public class Solution {
    public static Integer[] sort(Integer[] array)
    {

       for (int i=0;i< array.length;i++)
        {
            for (int j=0;j<array.length-i-1;j++)
            {
                if (array[j]>array[j+1])
                {
                    int tmp=array[j+1];
                    array[j+1]=array[j];
                   array[j]=tmp;

        }
    }
        }
        final double med;
        if (array.length%2 ==0)
        {
            med = (array[array.length/2-1] + array[array.length/2])/2.0;
            System.out.println(med);

        }
        else
        {
            med =  array[array.length/2];
            System.out.println(med);

        }

        Comparator<Integer> comp = new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                int result =  (int)(Math.abs(med-o1)-Math.abs(med-o2));
                if (result!=0)
                {
                    return result;
                }
              return  result = o1 - o2;
            }
        };

        Arrays.sort(array,comp);

        return array;
    }

    public static void main(String[] args)
    {
        Integer[] array = {3,4,7,6,5,2,1,11,5,48,49,56,92,94};
       //  Integer[] array = {3,4,7,-1,5,2,1,-18,11,5,48,49,-23,92,94};
        sort(array);

        for (Integer i:array)
        {
            System.out.print(i+" ");
        }
    }
}
