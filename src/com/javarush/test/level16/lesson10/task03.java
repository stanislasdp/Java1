package level16.lesson10;


/* —нова interrupt
—оздай нить TestThread.
¬ методе main создай экземпл€р нити, запусти, а потом прерви ее использу€ метод interrupt().
*/


public class task03 
{

	public static void main(String[] args) throws InterruptedException {
		TestThread testThread = new TestThread();
		testThread.start();
		testThread.interrupt();
    }

    //Add your code below - добавь код ниже
    public static class TestThread extends Thread{

		@Override
		public void run() 
		{	
		}
    }
}
