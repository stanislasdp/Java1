package level16.lesson10;


/* ����� interrupt
������ ���� TestThread.
� ������ main ������ ��������� ����, �������, � ����� ������ �� ��������� ����� interrupt().
*/


public class task03 
{

	public static void main(String[] args) throws InterruptedException {
		TestThread testThread = new TestThread();
		testThread.start();
		testThread.interrupt();
    }

    //Add your code below - ������ ��� ����
    public static class TestThread extends Thread{

		@Override
		public void run() 
		{	
		}
    }
}
