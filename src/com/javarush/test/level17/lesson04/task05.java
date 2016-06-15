package levrel17.lesson04;

/* ���
Singleton ������� - ������������� � ������
IMF - ��� ������������� �������� ����
������ ������ getFund �������� ������������������ ����
������ ������������������� ����� ��������������� ���������� imf ���, ����� ����� getFund ������ ��������� ���� � ��� �� ������
*/

public class task05 
{
	public static class IMF 
	{
        private static IMF imf;

        public synchronized static IMF getFund() 
        {
        	
				if (imf == null)
				{
					imf = new IMF();
				}
            return imf;
        }

        private IMF() {
        }
    }
	
}
