package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа+.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution+.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution
{
    public Solution(String s)
    {

    }

    public Solution(Integer i)
    {

    }

    public Solution (Double d)
    {

    }

    Solution(Short s)
    {

    }

    Solution(Byte b)
    {

    }

     Solution (Long l)
    {

    }

   protected Solution(Object s)
    {

    }

     protected Solution(Boolean b)
    {

    }

     protected Solution (Number numb)
    {

    }

    private Solution (Character ch){}
    private Solution (char ch){}
    private Solution (int i){}
}

