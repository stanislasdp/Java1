package level16.lesson05;



/* ��������������
1. �����������, ��� ������ ���������.
2. ����� ������� ���, ����� ��� ���� ��� ������������.
3. �������, ����� ����� ��������� �����-����� ���� ���� ������, � ������ ��������� ���� ����.
4. ����� ����� ����� ������.
*/

public class task04 
{
	public static void main(String[] args) throws InterruptedException {
        Mouse alpha = new Mouse("#1");
        //alpha.join();
        Mouse mouse1 = new Mouse("#2");
        Mouse mouse2 = new Mouse("#3");
    }

    public static class Mouse extends Thread {
        public Mouse(String name) {
            super(name);
            start();
        }

        public void run() {
            System.out.println(getName() + " starts eating");
            eating();
            System.out.println(getName() + " finished");
        }
    }
    private static void eating() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
    }
	
}
