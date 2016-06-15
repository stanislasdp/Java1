package level16.lesson07;



public class task03 
{
	 public static volatile boolean isStopped = false;

	    public static void main(String[] args) throws InterruptedException {
	        Clock clock = new Clock("������", 23, 59, 57);
	        Thread.sleep(4000);
	        
	       
	    }

	    public static class Clock extends Thread {
	        private String cityName;
	        private int hours;
	        private int minutes;
	        private int seconds;

	        public Clock(String cityName, int hours, int minutes, int seconds) {
	            this.cityName = cityName;
	            this.hours = hours;
	            this.minutes = minutes;
	            this.seconds = seconds;
	            start();
	        }

	        public void run() {
	            try {
	                while (!isStopped) {
	                    printTime();
	                }
	            } catch (InterruptedException e) {
	            }
	        }

	        private void printTime() throws InterruptedException {
	            //add your code here - ������ ��� ���
	            Thread.sleep(1000);
	            seconds += 1;
	            if( hours == 23 && minutes == 59 && seconds == 60){
	                hours = 0; minutes = 0; seconds = 0;
	            }
	            else if (seconds == 60)
	            {
	                seconds = 0;
	                minutes += 1;
	                if ( minutes == 60)
	                {
	                    seconds = 0;
	                    minutes = 0;
	                    hours += 1;
	                }
	            }

	            if (hours == 0 && minutes == 0 && seconds == 0) {
	                System.out.println(String.format("� �. %s ������ �������!", cityName));
	            } else {
	                System.out.println(String.format("� �. %s ������ %d:%d:%d!", cityName, hours, minutes, seconds));
	            }
	        }
	    }

}
