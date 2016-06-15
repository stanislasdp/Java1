package level16.lesson10;

public class task04 
{
	/* � ��� interrupt �����?
	���������, ��� �������� ���������.
	������ ���, ����� � ������ ourInterruptMethod ����� ���� ������� ���, ����� ���� TestThread ����������� ����.
	������ ������������ ����� interrupt.
	*/
	
	
	
	  public static void main(String[] args) throws InterruptedException {
	        Thread t = new Thread(new TestThread());
	        t.start();
	        
	        Thread.sleep(3000);
	        ourInterruptMethod();
	    }

	    public static void ourInterruptMethod() 
	    {
	    	TestThread.cancel=true;
	    }

	    public static class TestThread implements Runnable 
	    {
	    	public static boolean cancel = false;
	    	
	        public void run() {
	            while(!cancel) 
	            {
	                try {
	                	
	                    System.out.println("he-he");
	                    Thread.sleep(500);
	                    
	                } catch (InterruptedException e) {
	                }
	            }
	        }
	    }
	}
	
