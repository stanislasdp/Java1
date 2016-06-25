package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by stas on 6/22/16.
 */
public class Test
{

    public static List<LineItem> lines = new ArrayList<LineItem>();



    public static void main(String[] args) throws IOException
    {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String first_file_name = bf.readLine();
        String second_file_name = bf.readLine();
        ArrayList<String> old_file_strings = ReadFiles(first_file_name);
        ArrayList<String>  new_file_strings = ReadFiles(second_file_name);
        bf.close();

        boolean same_flag = true;


        while(true)
        {
            if (old_file_strings.size()==0 || new_file_strings.size()==0)
            {
                break;
            }
            else
            {
                if (old_file_strings.get(0).equals(new_file_strings.get(0)))
                {
                    lines.add(new LineItem(Type.SAME, old_file_strings.get(0)));
                    old_file_strings.remove(0);
                    new_file_strings.remove(0);
                    same_flag =true;
                }
                else if ((old_file_strings.get(0).equals(new_file_strings.get(1))) && same_flag)
                {
                    lines.add(new LineItem(Type.ADDED, new_file_strings.get(0)));
                    new_file_strings.remove(0);
                    same_flag = false;
                }
                else if (old_file_strings.get(1).equals(new_file_strings.get(0))&& same_flag)
                {
                    lines.add(new LineItem(Type.REMOVED, old_file_strings.get(0)));
                    old_file_strings.remove(0);
                    same_flag = false;
                }
                else
                {
                    break;
                }
            }

            old_file_strings.trimToSize();
            new_file_strings.trimToSize();

            if (old_file_strings.size()==0 && new_file_strings.size()!=0)
            {
                lines.add(new LineItem(Type.ADDED, new_file_strings.get(0)));
            }
            if (new_file_strings.size()==0 && old_file_strings.size()!=0)
            {
                lines.add(new LineItem(Type.REMOVED, old_file_strings.get(0)));
            }



        }
        for (LineItem item : lines)
        {
            System.out.println(item.line+" "+item.type);
        }

    }




    public static enum Type
    {
        ADDED,        //added new line
        REMOVED,      //removed line
        SAME          //no changes
    }

    public static class LineItem
    {
        public Type type;
        public String line;

        public LineItem(Type type, String line)
        {
            this.type = type;
            this.line = line;
        }
    }


    public static ArrayList<String> ReadFiles(String filename) throws IOException
    {
        BufferedReader br_file1 = new BufferedReader(new FileReader(filename));
        ArrayList<String> list_of_strings = new ArrayList<>();
        while (br_file1.ready())
        {
            list_of_strings.add(br_file1.readLine());
        }
        br_file1.close();
        return list_of_strings;
    }


}
