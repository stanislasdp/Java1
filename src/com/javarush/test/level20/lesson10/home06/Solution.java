package com.javarush.test.level20.lesson10.home06;

import java.io.*;

/* Запрет сериализации
Запретите сериализацию класса SubSolution используя NotSerializableException.
Сигнатуры классов менять нельзя
*/
public class Solution implements Serializable
{
    public static class SubSolution extends Solution
    {

        private void writeObject(ObjectOutputStream out) throws IOException
        {
           throw new NotSerializableException();
        }
        
        private void readObject(ObjectInputStream in) throws IOException
        {
        	throw new NotSerializableException();
        }

    }
    
    public static void main(String[] args) throws IOException,ClassNotFoundException
    {
    	//FileOutputStream fo = new FileOutputStream("D:\\test\\output.txt");
    	//ObjectOutputStream oi = new ObjectOutputStream(fi);
    	
    //	Solution.SubSolution sub = new Solution.SubSolution();
    	
    //	oi.writeObject(sub);
    	
    	FileInputStream fi  =new FileInputStream("D:\\test\\output.txt");
    	ObjectInputStream oi  = new ObjectInputStream(fi);
    	Solution.SubSolution test;
    	test = (Solution.SubSolution)oi.readObject();
    	
    }
