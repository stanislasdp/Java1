package com.javarush.test.level29.lesson15.big01.human;

import java.util.ArrayList;
import java.util.List;

public class University
{

    private List<Student> students = new ArrayList<>();
    private String name;
    private int age;

    public University(String name, int age)
    {

        this.name = name;
        this.age = age;
    }


    public void setStudents(List<Student> students)
    {
        this.students = students;
    }

    public  List<Student> getStudents()
    {
        return students;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }


    public Student getStudentWithAverageGrade( double value)
    {
        Student matchStudent = null;
        for (Student st:students)
        {
            if (Double.compare(st.getAverageGrade(),value)==0)
            {
                matchStudent=st;
                break;
            }
        }
        //TODO:
        return matchStudent;
    }

    public Student getStudentWithMaxAverageGrade()
    {   double maxAverageValue = students.get(0).getAverageGrade();
        Student studentWithMaxValue = students.get(0);
        for (Student st: students)
        {
          if (st.getAverageGrade() > maxAverageValue)
          {
              maxAverageValue = st.getAverageGrade();
              studentWithMaxValue = st;
          }
        }
        return studentWithMaxValue;
    }

    public Student getStudentWithMinAverageGrade()
    {
        double minAverageValue = students.get(0).getAverageGrade();
        Student studentWithMinValue = students.get(0);
        for (Student st: students)
        {
            if (st.getAverageGrade() < minAverageValue)
            {
                minAverageValue = st.getAverageGrade();
                studentWithMinValue = st;
            }
        }
        return studentWithMinValue;
    }

    public void expel(Student student)
    {
        students.remove(student);
    }


}
