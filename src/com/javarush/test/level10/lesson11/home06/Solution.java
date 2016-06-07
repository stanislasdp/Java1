package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
       String fname;
        String lname;
        boolean sex;
        int age;
        String race;
        String religion;

        public Human(String fname)
        {
            this.fname=fname;
            this.lname="Stas";
            this.sex=true;
            this.age=15;
            this.race="1";
            this.religion="Orthodoxal";
        }

        public Human(String fname,String lname)
        {
            this.fname=fname;
            this.lname=lname;
            this.sex=true;
            this.age=15;
            this.race="1";
            this.religion="Orthodoxal";
        }

        public Human(String fname,String lname, int age)
        {
            this.fname=fname;
            this.lname=lname;
            this.sex=true;
            this.age=age;
            this.race="1";
            this.religion="Orthodoxal";
        }

        public Human(String fname,String lname, int age,String race)
        {
            this.fname=fname;
            this.lname=lname;
            this.sex=true;
            this.age=age;
            this.race=race;
            this.religion="Orthodoxal";
        }

        public Human(String fname,String lname, int age,String race,String religion)
        {
            this.fname=fname;
            this.lname=lname;
            this.sex=true;
            this.age=age;
            this.race=race;
            this.religion=religion;
        }

        public Human(String fname,String lname, int age,String race,String religion,boolean sex)
        {
            this.fname=fname;
            this.lname=lname;
            this.sex=sex;
            this.age=age;
            this.race=race;
            this.religion=religion;
        }

        public Human(String fname,int age)
        {
            this.fname=fname;
            this.lname="Stas";
            this.sex=false;
            this.age=age;
            this.race="White";
            this.religion="Catholic";
        }

        public Human(String fname,boolean sex)
        {
            this.fname=fname;
            this.lname="Stas";
            this.sex=false;
            this.age=14;
            this.race="White";
            this.religion="Catholic";
        }

        public Human(String fname,boolean sex,int age)
        {
            this.fname=fname;
            this.lname="Stas";
            this.sex=sex;
            this.age=age;
            this.race="White";
            this.religion="Catholic";
        }

        public Human(String fname,boolean sex,int age,String lname)
        {
            this.fname=fname;
            this.lname=lname;
            this.sex=sex;
            this.age=age;
            this.race="White";
            this.religion="Catholic";
        }













    }
}
