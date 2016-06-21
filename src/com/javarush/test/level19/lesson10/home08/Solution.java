package com.javarush.test.level19.lesson10.home08;

/* Перевертыши
1 Считать с консоли имя файла.
2 Для каждой строки в файле:
2.1 переставить все символы в обратном порядке
2.2 вывести на экран
3 Закрыть потоки. Не использовать try-with-resources

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args)  throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String file_name = br.readLine();
		br.close();

		BufferedReader br_file = new BufferedReader(new FileReader(file_name));
		StringBuilder sb ;

		while (br_file.ready())
		{
			sb =new StringBuilder();
			sb.append(br_file.readLine());
			sb.reverse();
			System.out.println(sb.toString());
		}
		br_file.close();

	}
}
