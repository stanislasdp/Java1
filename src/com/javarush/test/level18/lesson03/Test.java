package lesson03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Test 
{

	public static void main(String[] args) throws Exception 
    {
    	InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);
        String filename =reader.readLine();
        in.close();
        
        FileInputStream fi = new FileInputStream(filename);
        
       
    
        while (fi.available()>0)
        {
        	System.out.println(fi.read()+ " ");
        	
        }
        fi.close();
     
        
    }
}
