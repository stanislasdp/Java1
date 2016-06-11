package com.javarush.test.level15.lesson12.home05;

/**
 * Created by stas on 6/11/16.
 */
public class SubSolution extends Solution
{
    public SubSolution(String s)
    {
        super(s);
    }

    public SubSolution(Integer i)
    {
        super(i);
    }

    public SubSolution(Double d)
    {
        super(d);
    }

    SubSolution(Short s)
    {
        super(s);
    }

    SubSolution(Byte b)
    {
        super(b);
    }

     SubSolution(Long l)
    {
        super(l);
    }

    protected SubSolution(Object s)
    {
        super(s);
    }

    protected SubSolution(Boolean b)
    {
        super(b);
    }

    protected SubSolution(Number numb)
    {
        super(numb);
    }

    private SubSolution (Character ch){super(ch);}
    private SubSolution (char ch){ super( ch);}
    private SubSolution (int i){super(i);}
}
