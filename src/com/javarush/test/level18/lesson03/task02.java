package lesson03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class task02 
{
	public static void main(String[] args) throws Exception 
    {
    	InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);
        String filename =reader.readLine();
        in.close();
        
        FileInputStream fi = new FileInputStream(filename);
        
        int min = fi.read();
    
        while (fi.available()>0)
        {
        	int i =fi.read();
        	if (i<min)
        	{
        		min=i;
        	}
        }
        fi.close();
        System.out.println(min);
        
    }
}
