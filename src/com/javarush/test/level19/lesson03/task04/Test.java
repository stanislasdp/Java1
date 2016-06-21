package com.javarush.test.level19.lesson03.task04;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by stas on 6/19/16.
 */
public class Test
{
    public static void main(String[]args) throws IOException
    {


        PersonScanner personScanner = new Solution.PersonScannerAdapter(new Scanner(new FileReader("/home/stas/workspace/CRUD.txt")));
        Person person = personScanner.read();
        Person person2 =personScanner.read();
        System.out.println(person);
        System.out.println(person2);
    }
}
