package levrel17.lesson04;

import java.util.ArrayList;
import java.util.List;

public class task03 

{
	/* ���-������
	1. �������� ����� public void addFruit(int index, String fruit) - ������� ��������� �������� fruit � ���� fruits �� ������� index +
	2. �������� ����� public void removeFruit(int index) - ������� ������� �� fruits ������� � �������� index +
	3. �������� ����� public void addVegetable(int index, String vegetable) - ������� ��������� �������� vegetable � ���� vegetables �� ������� index+
	4. �������� ����� public void removeVegetable(int index) - ������� ������� �� vegetables ������� � �������� index +
	5. ����� Garden ����� �������������� ������. ������� ������ ���, ����� ��� ������ ����������� ������ this
	6. �������� ��� ����������� ����������� ����
	*/

	 public static class Garden
	 {
		 
	        public final List<String> fruits = new ArrayList<String>();
	        public final List<String> vegetables = new ArrayList<String>();
	        
	        
	        public synchronized void addFruit(int index,String fruit)
	        {
	        	fruits.add(index, fruit);
	        }
	        
	        public synchronized void removeFruit(int index)
	        {
	        	fruits.remove(index);
	        }
	        
	        public synchronized void addVegetable(int index,String vegetable)
	        {
	        	vegetables.add(index, vegetable);
	        }
	        
	        public synchronized void removeVegetable(int index)
	        {
	        	vegetables.remove(index);
	        }
	        

	    }
	
}
