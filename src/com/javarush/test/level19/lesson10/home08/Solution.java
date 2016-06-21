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

public class Solution {
    public static void main(String[] args) 
    {
        
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 String file_name = br.readLine();
		 br.close();
		 
		 BufferedReader br_file = new BufferedReader(new FileReader(file_name));
		 StringBuilder sb = new StringBuilder();
		 
		 while (br_file.ready())
		 {
			 sb.append(br_file.readLine());
		 }
		 br_file.close();
		 sb.reverse();
		 System.out.println(sb.toString());
    }
}
