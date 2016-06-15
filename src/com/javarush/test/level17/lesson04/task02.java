package levrel17.lesson04;

import java.util.ArrayList;
import java.util.List;

/* ������������������ ������� 2
����� Note ����� �������������� ������. ������� ������ ���, ����� �c� ������ ���� ����������������
 */

public class task02 
{
	public static class Note 
	{

		public final List<String> notes = new ArrayList<String>();

		public synchronized void addNote(int index, String note)
		{
			System.out.println("������ ����� ��������� ������� [" + note + "] �� ������� " + index);
			notes.add(index, note);
			System.out.println("��� ��������� ������� [" + note + "]");
		}

		public synchronized void removeNote(int index) {
			System.out.println("������ ����� ������� ������� � ������� " + index);
			String note = notes.remove(index);
			System.out.println("��� ������� ������� [" + note + "] � ������� " + index);
		}
	}

}
