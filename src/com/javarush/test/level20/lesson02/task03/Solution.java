package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap()
    {
        try
        {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            String file_name = bf.readLine();
            bf.close();
            InputStream inputStream = new FileInputStream(file_name);
            load(inputStream);

        }
        catch (Exception ie)
        {
            ie.printStackTrace();
        }


    }

    public void save(OutputStream outputStream)
    {
        try
        {
            BufferedWriter bf = new BufferedWriter( new OutputStreamWriter(outputStream));
            Properties prop = new Properties();
            for (Map.Entry<String,String> pair: properties.entrySet() )
            {
                prop.setProperty(pair.getKey(),pair.getValue());
            }
            prop.store(bf,null);
            bf.close();
        }
        catch (IOException ie)
        {
            ie.printStackTrace();
        }


    }

    public void load(InputStream inputStream)
    {
        try
        {
            BufferedReader bf_file_reader = new BufferedReader(new InputStreamReader(inputStream));
            Properties prop = new Properties();
            prop.load(bf_file_reader);
            bf_file_reader.close();
            Enumeration<?> e = prop.propertyNames();
            while (e.hasMoreElements())
            {
                String key = (String) e.nextElement();
                String value = prop.getProperty(key);
                properties.put(key,value);
            }
        }
        catch (IOException ie)
        {
            ie.printStackTrace();
        }



    }

}
