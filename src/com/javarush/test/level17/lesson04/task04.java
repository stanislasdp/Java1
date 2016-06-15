package levrel17.lesson04;

/* ������������������ ���������
� ����� Singleton ������� - ������������� � ����������� �����
������ ������ OurPresident � ����������� ����� �������� ������������������ ����.
������ ������������������� ����� ��������������� president.
*/

public class task04 
{
	public static class OurPresident {
		
		
		
        private static OurPresident president;
        
        static
        {
        	synchronized (OurPresident.class) 
        	{
        		president= new OurPresident();
			}
        }

        private OurPresident() 
        {
        }

        public static OurPresident getOurPresident() 
        {
        	
            return president;
        }
    }

}
