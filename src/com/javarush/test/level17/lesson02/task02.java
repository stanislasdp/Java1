package levrel17.lesson02;

import java.util.ArrayList;
import java.util.List;

/* ������ �������? �� �������� :)
1. ���������, ��� � ��� ��������
2. ������ public static ���� SortThread, ������� � ������ run ����������� ����������� ������ testArray ��������� ����� sort
*/


public class task02 
{
	public static int countThreads = 10;
    public static int[] testArray = new int[1000];

    static {
        for (int i = 0; i < task02.testArray.length; i++) 
        {
            testArray[i] = i;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        initThreads();
    }

    public static void initThreads() throws InterruptedException {
        List<Thread> threads = new ArrayList<Thread>(countThreads);
        for (int i = 0; i < countThreads; i++)
        	threads.add(new SortThread());
        for (Thread thread : threads) thread.start();
        for (Thread thread : threads) thread.join();
        
        
        
    }

    public static void sort(int[] array) 
    {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] < array[j]) {
                    int k = array[i];
                    array[i] = array[j];
                    array[j] = k;
                }
            }
        }
    }
    
    public static class SortThread extends Thread
    {
    	@Override
    	public void run()
    	{
    		sort(testArray);
    	}
    }
	
	
}
