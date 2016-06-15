package level16.lesson07;

import level16.lesson07.Solution.Plane;
import level16.lesson07.Solution.Runway;

public class task05 
{

	public static volatile Runway RUNWAY = new Runway();   //1 �������� ������

    public static void main(String[] args) throws InterruptedException {
        Plane plane1 = new Plane("������� #1");
        Plane plane2 = new Plane("������� #2");
        Plane plane3 = new Plane("������� #3");
    }

    public static class Plane extends Thread {
        public Plane(String name) {
            super(name);
            start();
        }

        public void run() {
            boolean  isAlreadyTakenOff = false;
            while (!isAlreadyTakenOff) {
                if (RUNWAY.getTakingOffPlane() == null) {    //���� �������� ������ ��������
                    RUNWAY.setTakingOffPlane(this);
                    System.out.println(getName() + " ��������");
                    takingOff();//��������
                    System.out.println(getName() + " ��� � ����");
                    isAlreadyTakenOff = true;
                    RUNWAY.setTakingOffPlane(null);
                } else if (!this.equals(RUNWAY.getTakingOffPlane())) {  //���� �������� ������ ������ ���������
                    System.out.println(getName() + " �������");
                    waiting(); //�������
                }
            }
        }
    }
    private static void waiting() {
        try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
	
			e.printStackTrace();
		}
    }

    private static void takingOff() {
        //fix this method - ������� ���� �����
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
    }

    public static class Runway { //�������� ������
        private Thread t;

        public Thread getTakingOffPlane() {
            return t;
        }

        public void setTakingOffPlane(Thread t) {
            synchronized (this) {
                this.t = t;
            }
        }
    }
}
