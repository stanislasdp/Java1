package levrel17.lesson04;



import java.util.ArrayList;
import java.util.List;

/* ������������������ �������
1. ����� Note ����� �������������� ������. ������� ������ ���, ����� ��������� � ����� notes ����������� ������ notes, �� this
2. ��� System.out.println �� ������ ���� ������������� (����������������), �.�. �� ������ ���������� � ����� synchronized
 */

public class task01

{
	public  static class Note 
	{
		public final List<String> notes = new ArrayList<String>();

		public void addNote(int index, String note) 
		{

			System.out.println("������ ����� ��������� ������� [" + note + "] �� ������� " + index);
			synchronized (notes) 
			{
				notes.add(index, note);
			}

			System.out.println("��� ��������� ������� [" + note + "]");
		}


		public void removeNote(int index) 
		{
			String note;
			System.out.println("������ ����� ������� ������� � ������� " + index);
			{   synchronized (notes) 
				{
				note = notes.remove(index);
				}
			System.out.println("��� ������� ������� [" + note + "] � ������� " + index);
			}
		}
	}
}