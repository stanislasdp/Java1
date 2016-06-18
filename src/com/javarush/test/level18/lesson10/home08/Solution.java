package com.javarush.test.level18.lesson10.home08;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws Exception
    {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String filename = bf.readLine();


        while (!filename.equals("exit"))
        {
            Thread tr =new ReadThread(filename);
            tr.start();
            filename = bf.readLine();
        }
        bf.close();

        for (Map.Entry<String,Integer> i: resultMap.entrySet())
        {
            System.out.println("Filename "+i.getKey()+ " Max byte "+i.getValue());
        }
    }

    public static class ReadThread extends Thread
    {       private String filename;
        HashMap<Integer,Integer> hashMap = new HashMap<Integer, Integer>();
        FileInputStream fi;
                ;
        public ReadThread(String fileName)  throws IOException
        {
            this.filename=fileName;
          fi=  new FileInputStream(filename);
        }


        @Override
        public void run()
        {

            try
            {
                while (fi.available()>0)
                {
                    int key =fi.read();
                    if (!hashMap.containsKey(key))
                    {
                        hashMap.put(key,1);
                    }
                    else
                    {
                        hashMap.put(key,hashMap.get(key)+1);
                    }
                }
                int max_byte_count=0;
                int corres_byte=0;


                for (Map.Entry<Integer,Integer> pair: hashMap.entrySet())
                {
                    if (pair.getValue()>max_byte_count)
                    {
                        max_byte_count=pair.getValue();
                        corres_byte=pair.getKey();
                    }
                }
                resultMap.put(filename,corres_byte);
            }
            catch (IOException ie)
            {

            }

        }
    }
}
