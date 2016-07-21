package com.javarush.test.level22.lesson13.task03;


/* Проверка номера телефона
Метод checkTelNumber должен проверять, является ли аргумент telNumber валидным номером телефона.
Критерии валидности:
1) если номер начинается с '+', то он содержит 12 цифр +
2) если номер начинается с цифры или открывающей скобки, то он содержит 10 цифр +
3) может содержать 0-2 знаков '-', которые не могут идти подряд
4) может содержать 1 пару скобок '(' и ')'  , причем если она есть, то она расположена левее знаков '-'
5) скобки внутри содержат четко 3 цифры
6) номер не содержит букв +
7) номер заканчивается на цифру+
Примеры:
+380501234567 - true
+38(050)1234567 - true
+38050123-45-67 - true
050123-4567 - true
+38)050(1234567 - false
+38(050)1-23-45-6-7 - false
050ххх4567 - false
050123456 - false
(0)501234567 - false
*/
public class Solution {

    public static boolean checkTelNumber(String telNumber)
    {
    	if (telNumber==null)
    	{
    		return false;
    	}
    	if (telNumber.matches(".*[\\w&&[^\\d]].*"))
    	
    	{
    		System.out.println("telNumber contains characters");
    		return false;
    	}
    	
    	if (telNumber.matches(".*[^\\d]$"))
    	{
    		System.out.println("telNumbel is not ended by a digit");
    		return false;
    	}
    	
    	if (telNumber.matches("^\\+.*"))// number is started from "+"
    	{
    	//	System.out.println("1");
    		if (telNumber.replaceAll("\\D","").length()!=12)// number length equals to 12
        	{
        		System.out.println("1    "+telNumber.replaceAll("\\D","").length());
        		return false;
        	}
    	}
    	else if (telNumber.matches("[\\d[(]].*"));// number is started from digit or "("
    	{
    		System.out.println("2");
    		if (telNumber.replaceAll("\\D","").length()!=10)// number length is equal to 10
    		{
    			
    			System.out.println("2  "+telNumber);
        		return false;
    		}
    	}
    	
    	
    	
    	
    	
    	
    	return true;
   
    	
}
    public static void main (String...a)
    {
    	String tel1 = "+380501234567";
    	String tel2 = "+38(050)1234567";
    	String tel4 = "050123-4567";
    	String tel5 = "38)050(123456";
    	String tel6 = "(050)1234567";
    	String tel7 = "+38050123456-";
    	String tel8 = "0504567";
    	String tel9 = "38501234567";
    	System.out.println(checkTelNumber(tel1));
    	
    //	System.out.println(tel1.replaceAll("\\D[^=//+]", ""));
    }
}
