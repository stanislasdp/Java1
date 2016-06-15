package level17.lesson06;

import java.util.ArrayList;
import java.util.List;

/*����� Note ����� �������������� ������.
������� ������ ���, ����� ���� notes ��������� � ����� ������*/

public class task01
{
	 public static class Note {
		 
	        public volatile List<String> notes = new ArrayList<String>();

	        public void addNote(int index, String note) {
	            System.out.println("������ ����� ��������� ������� [" + note + "] �� ������� " + index);
	            notes.add(index, note);
	            System.out.println("��� ��������� ������� [" + note + "]");
	        }

	        public void removeNote(int index) {
	            System.out.println("������ ����� ������� ������� � ������� " + index);
	            String note = notes.remove(index);
	            System.out.println("��� ������� ������� [" + note + "] � ������� " + index);
	        }
	    }
}
