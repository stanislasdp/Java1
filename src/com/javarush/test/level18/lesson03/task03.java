package lesson03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class task03 
{
	    public static void main(String[] args) throws Exception 
	    {
	    	InputStreamReader in = new InputStreamReader(System.in);
	        BufferedReader reader = new BufferedReader(in);
	        String filename =reader.readLine();
	        in.close();
	        
	        FileInputStream fi = new FileInputStream(filename);
	       Map<Integer, Integer> hmap = new HashMap<Integer,Integer>();
	        while (fi.available()>0)
	        {
	        	int i = fi.read();
	        	if (hmap.containsKey(i))
	        	{
	        		hmap.put(i, hmap.get(i)+1);
	        	
	        	}
	        	else
	        	{
	        		hmap.put(i, 1);	
	        	}
	        }
	        fi.close();
	        
	        Integer maxValue =0;
	        for (int value: hmap.values())
	        {
	        	if (value>=maxValue)
	        	{
	        		maxValue=value;
	        	}
	        }
	        
		       for (Map.Entry<Integer, Integer> entry : hmap.entrySet())
		       {
		    	  
		    	   	if (maxValue.equals(entry.getValue()))
		    	   		System.out.println(entry.getKey()+ " ");
		       }   
	    }
}
