package lesson03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.TreeSet;
/* ���������� ����
������ � ������� ��� �����
������� ��� ����� �� �����.
�� �������� ���������� - ������������� �� �� ����-���� � ������������ �������.
������� �� �����
������� ����� �����-������

������ ���� �������� �����
44 83 44

������ ������
44 83
 */


public class task05 
{
	public static void main(String[] args) throws Exception 
	{
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(in);
		String filename =reader.readLine();
		in.close();
		FileInputStream fi = new FileInputStream(filename);
		TreeSet<Integer> tree = new TreeSet<Integer>();
	

		while (fi.available()>0)
		{
			int bite = fi.read();
			if (!tree.contains(bite))
			{
				tree.add(bite);
			}
		}
		fi.close();

		
		for (Integer i : tree) 
		{
			System.out.print(i+" ");
		}

		
	}
}
