package levrel17.lesson02;

import java.util.ArrayList;
import java.util.List;


/* �������
1. ����� Note ����� �������������� ������.
2. ������ public static ���� NoteThread (Runnable �� �������� �����),
������� � ������ run 1000 ��� (index = 0-999) ������� ��������� ��������:
2.1. ��������� ����� addNote ������� ������� � ������ [getName() + "-Note" + index], ��������, ��� index=4
"Thread-0-Note4"
2.2. ��������� ����� removeNote ������ �������
2.3. � �������� ������� ��������� � removeNote ������� ��� ���� - ����� getName()
*/

public class task01 
{
    public static void main(String[] args) {

    }

    public static class Note
    {
        public static final List<String> notes = new ArrayList<String>();
        public static void addNote(String note) 
        {
            notes.add(0, note);
        }

        public static void removeNote(String threadName) {
            String note = notes.remove(0);
            if (note == null) 
            {
                System.out.println("������ ���� ������� ���� �������");
            } else if (!note.startsWith(threadName)) {
                System.out.println("���� [" + threadName + "] ������� ����� ������� [" + note + "]");
            }
        }
    }
    
    public static class NoteThread extends Thread
    {
    	@Override
    	public void run()
    	{
    		for (int i=0;i<999;i++)
    		{
    		Note.addNote(getName()+ "-Note"+i);	
    	    Note.removeNote(getName());
    		}
    	}
    }
}