package com.javarush.test.level22.lesson05.task01;



import java.util.ArrayList;
import java.util.regex.Pattern;



/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException 
    {
    	if (string==null || string.equals(""))
    	{
    		throw new TooShortStringException();
    	}
    	int first_whitespace = string.indexOf(" ");
    	
    	 
    	 ArrayList<Integer> white_spaces_indexes= new ArrayList<>();
    	 
    	 int index = 0;
    	 while (true)
    	 {
    		index = string.indexOf(' ',index+1);
    		 if (index == -1)
    		 {
    			 break;
    		 }
    		 white_spaces_indexes.add(index);
    	 }
    	 if (white_spaces_indexes.size()<4)
    	 {
    		 throw new TooShortStringException();
    	 }
    
    	return string.substring(white_spaces_indexes.get(0)+1,white_spaces_indexes.get(4));
    	
    }
    
    
    public static void main(String...args) throws Exception,TooShortStringException
    {
    	
    	
    	String res = Solution.getPartOfString("      ");
    	System.out.println(res);
    }

    public static class TooShortStringException extends Throwable {
    }
}

