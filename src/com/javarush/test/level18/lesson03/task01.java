

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class task01 

{
	 public static void main(String[] args) throws Exception 
	    {
	    	InputStreamReader in = new InputStreamReader(System.in);
	        BufferedReader reader = new BufferedReader(in);
	        String filename =reader.readLine();
	        in.close();
	        
	        FileInputStream fi = new FileInputStream(filename);
	        
	        int max = fi.read();
	    
	        while (fi.available()>0)
	        {
	        	int i =fi.read();
	        	if (i>max)
	        	{
	        		max=i;
	        	}
	        }
	        fi.close();
	        System.out.println(max);
	        
	    }
}
