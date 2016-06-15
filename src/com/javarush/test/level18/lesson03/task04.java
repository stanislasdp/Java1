package lesson03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class task04 
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
        
        Integer minValue =1;
        for (int value: hmap.values())
        {
        	if (value<=minValue)
        	{
        		minValue=value;
        	}
        }
        
	       for (Map.Entry<Integer, Integer> entry : hmap.entrySet())
	       {
	    	  
	    	   	if (minValue.equals(entry.getValue()))
	    	   		System.out.print(entry.getKey()+ " ");
	       }   
    }
}
