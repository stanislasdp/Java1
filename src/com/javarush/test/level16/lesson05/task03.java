package level16.lesson05;


/* ����������� �� ������������ �������
1. �����������, ��� ������ ���������.
2. ����� ������� ���, ����� ������ ������ ������ ����� ����� �� ������������ �������.
3. �������, ����� ����� ����� ������� � ������� ivanov, ����� ������ ������������, ���� �� ���������� �� ��������� �����.
*/

public class task03 
{
    public static int totalCountSpeeches = 200;
    public static int soundsInOneSpeech = 1000000;

    public static void main(String[] args) throws InterruptedException {
        Politic ivanov = new Politic("������");
        ivanov.join();
        Politic petrov = new Politic("������");
        Politic sidorov = new Politic("�������");

        while (ivanov.getCountSpeaches() + petrov.getCountSpeaches() + sidorov.getCountSpeaches() < totalCountSpeeches) 
        {
        	
        }

        System.out.println(ivanov);
        System.out.println(petrov);
        System.out.println(sidorov);
    }

    public static class Politic extends Thread 
    {
        private int countSounds;

        public Politic(String name) 
        {
            super(name);
            start();
        }

        public void run() 
        {
            while (countSounds < totalCountSpeeches * soundsInOneSpeech) {
                countSounds++;
            }
        }

        public int getCountSpeaches() {
            return countSounds / soundsInOneSpeech;
        }

        @Override
        public String toString() {
            return String.format("%s ������ ���� %d ���", getName(), getCountSpeaches());
        }
    }
}
