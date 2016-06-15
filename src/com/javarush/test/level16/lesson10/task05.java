package level16.lesson10;

import java.util.ArrayList;
import java.util.List;

/* ���� ��� ����, ��� - ��� ������
1. ���������, ��� �������� ���������.
1.1. ������ ��������, ��� ������ Water - ���� ��� ���� �����.

2. �������� ����� ourInterruptMethod, ����� �� �������� ��� ���� �� threads.
3. � ������ run ������� �������� ����������:
3.1. isCurrentThreadInterrupted - ������ ��������� �������� ������ isInterrupted � ������� ����.
3.2. threadName - ������ ��������� �������� ������ getName (����������� � ������ Thread) � ������� ����.
*/

public class task05 
{
    public static byte countThreads = 3;
    static List<Thread> threads = new ArrayList<Thread>(countThreads);

    public static void main(String[] args) throws InterruptedException 
    {
        initThreadsAndStart();
        Thread.sleep(3000);
        ourInterruptMethod();
    }

    public static void ourInterruptMethod()
    {
        for (Thread thread : threads) 
        {
			thread.interrupt();
		}
    }

    private static void initThreadsAndStart() {
        Water water = new Water("water");
        for (int i = 0; i < countThreads; i++) 
        {
            threads.add(new Thread(water, "#" + i));
        }
        
        for (int i = 0; i < countThreads; i++) 
        {
            threads.get(i).start();
        }
    }

    public static class Water implements Runnable {
        private String commonResource;

        public Water(String commonResource) {
            this.commonResource = commonResource;
        }

        public void run() 
        {
        	Thread thread =Thread.currentThread();
            //fix 2 variables - ������� 2 ����������
            boolean isCurrentThreadInterrupted =thread.isInterrupted();
            String threadName = thread.getName();

            try {
                while (!isCurrentThreadInterrupted) {

                    System.out.println("������ " + commonResource + ", ���� " + threadName);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
            }
        }
    }
}