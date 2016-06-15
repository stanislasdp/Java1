package lesson05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class task02 
{

	/* Подсчет запятых
	С консоли считать имя файла
	Посчитать в файле количество символов ',', количество вывести на консоль
	Закрыть потоки. Не использовать try-with-resources

	Подсказка: нужно сравнивать с ascii-кодом символа ','
	 */

	public static void main(String[] args) throws Exception 
	{

		InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);
        String filename =reader.readLine();
        in.close();
        
        FileInputStream inputStream = new FileInputStream(filename);
        int commaCount =0;
        while(inputStream.available()>0)
        {
        	if (inputStream.read()==44)
        	{
        		commaCount++;
        	}
        }
        inputStream.close();
        System.out.println(commaCount);
        
	}
	
}
