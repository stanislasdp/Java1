package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

public class Solution {
    public static void main(String[] args) 
    {

      BufferedReader br_first = new BufferedReader(new FileReader(args[0]));
    	BufferedWriter br_second = new BufferedWriter(new FileWriter(args[1]));
    	StringBuilder sb = new StringBuilder();
    	
    	while(br_first.ready())
    	{
    		String [] current_string=br_first.readLine().split(" ");
    		
   
    		for (int i = 0; i < current_string.length; i++) 
    		{
    			if (current_string[i].length()>6)
    			{
    				sb.append(current_string[i]);
    				sb.append(",");
    			}	
			}
    	}
    	sb.deleteCharAt(sb.length()-1);
    	br_second.write(sb.toString());
    	br_first.close();
    	br_second.close();
    }
}
