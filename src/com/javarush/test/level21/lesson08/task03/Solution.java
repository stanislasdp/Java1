package com.javarush.test.level21.lesson08.task03;

/* Запретить клонирование
Разрешите клонировать класс А
Запретите клонировать класс B
Разрешите клонировать класс C
Метод main не участвует в тестировании.
*/
public class Solution

{
    public static void main(String[] args)
    {
        A a = new A(3,4);
        A clone = null;

        try
        {
            clone = (A)a.clone();
        }
        catch (CloneNotSupportedException ce)
        {
            ce.printStackTrace();
        }

        System.out.println("A "+a);
        System.out.println("Clone A "+clone);

        B b = new B(3,4,"test");
        B cloneb= null;

        try
        {
            cloneb= (B)b.clone();
        }
        catch (CloneNotSupportedException ce)
        {
            ce.printStackTrace();
        }

        C c = new C(3,4,"test");
        C cloneC = null;

        try
        {
            cloneC = (C)c.clone();
        }
        catch (CloneNotSupportedException ce)
        {
            ce.printStackTrace();
        }

        System.out.println(c);
        System.out.println(cloneC);
    }
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j)
        {
            this.i = i;
            this.j = j;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException
        {
            return super.clone();
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
    }

    public static class B extends A implements Cloneable
    {

        private String name;

        @Override
        protected Object clone() throws CloneNotSupportedException
        {
            throw  new CloneNotSupportedException();
        }

        public B(int i, int j, String name)
        {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class C extends B implements Cloneable {


        public C(int i, int j, String name)
        {
            super(i, j, name);

        }

        @Override
        protected C clone() throws CloneNotSupportedException
        {
            return new C(super.getI(),super.getJ(),super.getName());

        }


    }


}
