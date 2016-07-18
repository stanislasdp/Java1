package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class Solution {
   public static void main(String[] args)
	    {
	        String filename = null;
	        String tag = args[0];
	        StringBuilder sb = new StringBuilder();
	        BufferedReader file_reader;
	        try
	        {
	            BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
	            filename = bi.readLine();
	            bi.close();
	            file_reader = new BufferedReader(new FileReader(filename));
	           
	            while (file_reader.ready())
	            {
	                sb.append(file_reader.readLine());
	            }
	            
	            file_reader.close();}
	        catch (IOException ie)
	        {
	            ie.printStackTrace();
	        }
	       
	        String open_tag = "<" +tag;
	        String close_tag = "</" + tag + ">";
	        String initial_string = sb.toString();
	        ArrayList<Integer> ind_opened = new ArrayList<>();
	        ArrayList<Integer> ind_closed = new ArrayList<>();
	        int opened_tag = 0;
	        int closed_tag = 0;
	        while (true)
	        {
	        	//remember previous open tag index for the next search
	            int tmp_opened = opened_tag;
	            //searching the nearest open tag index in the string starting from current opened tag index
	            opened_tag = initial_string.indexOf(open_tag,opened_tag+1);
	            // remember previous closed tag index for the next search
	            int tmp_closed = closed_tag;
	            //searching index of the nearest close tag starting from current close tag index
	            closed_tag = initial_string.indexOf(close_tag,closed_tag+1);
	            int min_tag=0;
	            
	            //if close tag =-1, it means there are no more close tags in the stiong  (all opened and closed tags are counted)
	            if (closed_tag==-1 )
	            {
	                break;
	            }
	            // if opened tag =-1 it means that all opened tags are counted, but there is at least one not counted
	            if (opened_tag==-1)
	            {
	             min_tag=closed_tag;
	            }
	            else
	            {
	            	// calculating minimal index
	            	min_tag = Math.min(opened_tag,closed_tag);
	            }
	             if (min_tag==opened_tag)
	             {
	            	 //add opened tag to the list
	                 ind_opened.add(opened_tag);
	                 // add null to closed tags
	                 ind_closed.add(null);
	                 // set closed tag position for search to previous value (It needed for the next loop iteration)
	                 closed_tag = tmp_closed;
	             }
	            else if (min_tag==closed_tag)
	             {
	            	//fing last index of null in the list of closed tags and set current close tag position to this index
	                 ind_closed.set(ind_closed.lastIndexOf(null),closed_tag);
	                 // set closed tag position for search to previous value (It needed for the next loop iteration)
	                 opened_tag = tmp_opened;
	             }
	        }
	        // printing all substiong within tag indexes stored in list of opened and closed tags.
	        for (int i = 0; i <ind_opened.size() ; i++)
	        {
	            System.out.println(initial_string.substring(ind_opened.get(i),ind_closed.get(i)+tag.length()+3));
	        }
	}
}
