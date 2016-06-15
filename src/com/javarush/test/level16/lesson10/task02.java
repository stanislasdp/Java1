package level16.lesson10;
/* ������ �� ������
1. ���������, ��� ������ ���������.
2. �������� ������ ������ run ���, ����� ������ ������� ����� ������
��������� ������ ������� � countSeconds �� 1, � ����� ����� [����!] (�� �������).
3. ���� ���� �������� 3.5 ������� ��� �����, ������ �� ������� interrupt � ������ ���� ������ � ������� ����� [��������!].
������ ��� countSeconds=4 : [4 3 2 1 ��������!]
4. ���� ���� �������� ����� 3.5 ������, ��� ������ ����������� ����.
������ ��� countSeconds=3 : [3 2 1 ����!]
PS: ����� sleep ����������� InterruptedException.
 */

public class task02 {
	public static volatile int countSeconds = 5;

	public static void main(String[] args) throws InterruptedException
	{	long currenttime = System.currentTimeMillis();
	RacingClock clock = new RacingClock();

	while (true)
	{
		if (System.currentTimeMillis()-currenttime>3500)
		{
			clock.interrupt();
			break;

		}
	}
	//add your code here - ������ ��� ���
	}

	public static class RacingClock extends Thread 
	{
		public RacingClock() {
			start();
		}

		public void run() 
		{
			try
			{
				while (countSeconds>0)
				{
					System.out.print(countSeconds+" ");
					countSeconds--;
					Thread.sleep(1000);
				}
				System.out.print("����!");
			}

			catch (InterruptedException iex)
			{
				System.out.print("��������!");
			}
		}
	}
}
