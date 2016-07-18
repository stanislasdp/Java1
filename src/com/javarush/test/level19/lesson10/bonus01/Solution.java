package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)


строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка4                           REMOVED строка4
строка5        строка5            SAME строка5
строка0                           ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка5                           ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5
*/

public class  Solution {


	public static List<LineItem> lines = new ArrayList<LineItem>();



	public static void main(String[] args) throws IOException
	{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String first_file_name = bf.readLine();
		String second_file_name = bf.readLine();
		LinkedList<String> old_file_strings = ReadFiles(first_file_name);
		LinkedList<String>  new_file_strings = ReadFiles(second_file_name);
		bf.close();

		boolean same_flag = true;


		while(true)
		{
			if (old_file_strings.size()==0 || new_file_strings.size()==0)
			{
				break;
			}
			else
			{
				if (old_file_strings.peek().equals(new_file_strings.peek()))
				{
					lines.add(new LineItem(Type.SAME, old_file_strings.peek()));;
					old_file_strings.poll();
					new_file_strings.poll();
					same_flag =true;


				}
				else if ((old_file_strings.peekFirst().equals(new_file_strings.get(1))) && same_flag)
				{
					;
					System.out.println(old_file_strings);
					lines.add(new LineItem(Type.ADDED, new_file_strings.peekFirst()));
					new_file_strings.poll();
					same_flag = false;
				}
				else if (old_file_strings.get(1).equals(new_file_strings.peekFirst())&& same_flag)
				{
					lines.add(new LineItem(Type.REMOVED, old_file_strings.peekFirst()));
					old_file_strings.poll();
					same_flag = false;
				}
				else
				{
					break;
				}
			}
		}

		if (old_file_strings.size()==0 && new_file_strings.size()!=0)
		{
			lines.add(new LineItem(Type.ADDED, new_file_strings.peekFirst()));
		}
		if (new_file_strings.size()==0 && old_file_strings.size()!=0)
		{
			lines.add(new LineItem(Type.REMOVED, old_file_strings.peekFirst()));
		}

		for (LineItem item : lines)
		{
			System.out.println(item.line+" "+ item.type);
		}
	}

	public static enum Type
	{
		ADDED,        //added new line
		REMOVED,      //removed line
		SAME          //no changes
	}

	public static class LineItem
	{
		public Type type;
		public String line;

		public LineItem(Type type, String line)
		{
			this.type = type;
			this.line = line;
		}
	}


	public static LinkedList<String> ReadFiles(String filename) throws IOException
	{
		BufferedReader br_file1 = new BufferedReader(new FileReader(filename));
		LinkedList<String> list_of_strings = new LinkedList<>();
		while (br_file1.ready())
		{
			list_of_strings.add(br_file1.readLine());
		}
		br_file1.close();
		return list_of_strings;
	}
}
