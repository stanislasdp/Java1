package level16.lesson07;




public class task02 
{

	/* Stopwatch (����������)
	1. ���������, ��� ������ ���������.
	2. �������� ������ ������ doSeveralSteps ���, ����� ����������� �������� ������.
	2.1. ����� getSpeed() � ������ Runner ����������, ������� ����� � ������� ������ �����.
	�����, ����� ����� ������������� ����� �������� ���������� ����� � �������.
	���� ������ ������ 4 ���� � �������, �� �� 2 ������� �� ������� 8 �����.
	���� ������ ������ 2 ���� � �������, �� �� 2 ������� �� ������� 4 ����.
	2.2. ����� sleep � ������ Thread ��������� �������� ���� long.
	*/
	
	 public static volatile boolean isStopped = false;

	    public static void main(String[] args) throws InterruptedException {
	        Runner ivanov = new Runner("Ivanov", 4);
	        Runner petrov = new Runner("Petrov", 2);
	        //�� �����!
	        //��������!
	        //����!
	        ivanov.start();
	        petrov.start();
	        Thread.sleep(2000);
	        isStopped = true;
	        Thread.sleep(1000);
	    }

	    public static class Stopwatch extends Thread {
	        private Runner owner;
	        private int stepNumber;

	        public Stopwatch(Runner runner) {
	            this.owner = runner;
	        }

	        public void run() {
	            try {
	                while (!isStopped) {
	                    doSeveralSteps();
	                }
	            } catch (InterruptedException e) {
	            }
	        }

	        private void doSeveralSteps() throws InterruptedException {
	            stepNumber++;
	            //add your code here - ������ ��� ���
	            Thread.sleep((long)(1000/owner.getSpeed()));
	            System.out.println(owner.getName() + " ������ ��� �" + stepNumber + "!");
	        }
	    }

	    public static class Runner {
	        private String name;
	        private double speed;
	        Stopwatch stopwatch;

	        public Runner(String name, double speed) {
	            this.name = name;
	            this.speed = speed;
	            this.stopwatch = new Stopwatch(this);
	        }

	        public String getName() {
	            return name;
	        }

	        public double getSpeed() {
	            return speed;
	        }

	        public void start() {
	            stopwatch.start();
	        }
	    }
}
