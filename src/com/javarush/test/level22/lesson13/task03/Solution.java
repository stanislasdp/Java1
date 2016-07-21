package com.javarush.test.level22.lesson13.task03;


import java.util.HashMap;
import java.util.Map;

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
    		//System.out.println("telNumber contains characters");
    		return false;
    	}
    	
    	if (telNumber.matches(".*[^\\d]$"))
    	{
    		//System.out.println("telNumbel is not ended by a digit");
    		return false;
    	}
    	
    	if (telNumber.matches("^\\+.*"))// number is started from "+"
    	{
    	//	System.out.println("1");
    		if (telNumber.replaceAll("\\D","").length()!=12)// number length equals to 12
        	{
        	//	System.out.println("1    "+telNumber.replaceAll("\\D","").length());
        		return false;
        	}
    	}

    	else if (telNumber.matches("[\\d[(]].*"))// number is started from digit or "("
    	{
    	//	System.out.println("2");
    		if (telNumber.replaceAll("\\D","").length()!=10)// number length is equal to 10
    		{
    			
    		//	System.out.println("2  "+telNumber);
        		return false;
    		}
    	}
        System.out.println(telNumber);
        if (telNumber.matches("\\+?\\d*(\\(\\d{3}\\))?\\d?-?\\d+-?\\d.*"))
        {
            return true;
        }

        return false;


   
    	
}
    public static void main (String...a)
    {
        String test1 = "+38(050)12-34-567";
        System.out.println(checkTelNumber(test1));


    	String tel1 = "+380501234567";
    	String tel2 = "+38(050)1234567";
    	String tel3 = "+38050123-45-67";
        String tel4 = "050123-4567";
    	String tel5 = "38)050(123456";
    	String tel6 = "+38(050)1-23-45-6-7";
    	String tel7 = "050ххх4567";
    	String tel8 = "050123456";
    	String tel9 = "(0)501234567";
    	//System.out.println(checkTelNumber(tel9));


        /*Map<String,Boolean> test = new HashMap<>();
        test.put("+380501234567",true);
        test.put("+38(050)1234567-",false);
        test.put("++380501234567",true);
        test.put("(380)501234567",false);
        test.put("+38050123--4567",false);
        test.put("050123--4567",false);
        test.put(" 0-50123-4567",true);
        test.put("+38)050(1234567",false);
        test.put("+38(050)1-23-45-6-7",false);
        test.put("050���4567",false);
        test.put("050123456",false);
        test.put("(0)501234567",false);
        test.put("+38-(050)1234567",false);
        test.put("+38((050)1234567",false);
        test.put("+5(0--5)1234567",false);
        test.put(" 1-23456789-0",true);
        test.put("+38051202(345)-7",true);

        for (Map.Entry<String,Boolean> pair:test.entrySet() )
        {
            if (!pair.getValue().equals(checkTelNumber(pair.getKey())))
            {
                System.out.println(pair.getKey()+"  "+ checkTelNumber(pair.getKey()));
            }
        }*/



    //	System.out.println(tel1.replaceAll("\\D[^=//+]", ""));


      /*  +380501234567=true
                +38(050)1234567-=false
            +38050(123)(456)7=false
            ++380501234567=true
        (380)501234567=false
            +38050123--4567=false
        050123--4567=false
        0-50123-4567=true
                +38)050(1234567=false
            +38(050)1-23-45-6-7=false
        050���4567=false
        050123456=false
        (0)501234567=false
            +38-(050)1234567=false
            +38((050)1234567=false
            +5(0--5)1234567=false
        1-23456789-0=true
                +38051202(345)-7=true
            +38051202(345)7=true
        (345)0512027=true
            +-313450531202=true
            +313450--531202=false
        38xx501A34567=false
        3805012345=true
                +38(0501234567=false
            +38(050)1234567=true
            +38(05)1234567=false
        (3)80501234567=false
        380-50123-45=true
        (380)501-234567=false
        (38-0)501234567=false
        380-(501)234567=false
        380(50-1)234567=false
        380(501)(23)4567=false
            +38050123(456)7=true
            +38050123(456)76=false
            +380501234(567)=false
        3-805-0123-45=false
                -3805-012345=true
        3805-012345-=false
                +38(05)01234567=false
            +38(0501)234567=false
            +38050123-45-67=true
        050123-4567=true
        7-4-4123689-5=false
                +313450--531202�=false
        AB=false
        1AB1=false
        ab=false
        1ab1=false
        aB=false
        1aB1=false
        12345678910=false
                +38=false
                -12345678910=true*/
    }
}
