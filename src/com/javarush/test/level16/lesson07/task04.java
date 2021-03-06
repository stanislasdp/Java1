package level16.lesson07;


import java.util.ArrayList;
import java.util.List;

/* �������� ������
1. ���������, ��� ������ ���������.
2. �������� ������ ������ printCountdown ���, ����� ������ ���������� ��������� ������ ��
���������� list � �������� ������� - �� ����������� ������� �� ����.
������: ������� ������ 3
������ ������ � �������:
������ 2
������ 1
������ 0
*/

public class task04 
{
    public static volatile List<String> list = new ArrayList<String>(5);

    static {
        for (int i = 0; i < 5; i++) {
            list.add("������ " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Countdown(3));
        t.start();
    }

    public static class Countdown implements Runnable {
        private int countFrom;

        public Countdown(int countFrom) 
        {
            this.countFrom = countFrom;
        }

        public void run() {
            try {
                while (countFrom > 0) {
                    printCountdown();
                }
            } catch (InterruptedException e)
            {
            }
        }

        public void printCountdown() throws InterruptedException 
        {
        Thread.sleep(500);
        countFrom--;
         System.out.println(list.get(countFrom));
           
        }
    }
}