package level16.lesson10;
/* Отсчет на гонках
1. Разберись, что делает программа.
2. Реализуй логику метода run так, чтобы каждую секунду через пробел
выдавался отсчет начиная с countSeconds до 1, а потом слово [Марш!] (см примеры).
3. Если нить работает 3.5 секунды или более, прерви ее методом interrupt и внутри нити выведи в консоль слово [Прервано!].
Пример для countSeconds=4 : [4 3 2 1 Прервано!]
4. Если нить работает менее 3.5 секунд, она должна завершиться сама.
Пример для countSeconds=3 : [3 2 1 Марш!]
PS: метод sleep выбрасывает InterruptedException.
 */

public class task02 {
	public static volatile int countSeconds = 5;

	public static void main(String[] args) throws InterruptedException
	{	long currenttime = System.currentTimeMillis();
	RacingClock clock = new RacingClock();

	while (true)
	{
		if (System.currentTimeMillis()-currenttime>3500)
		{
			clock.interrupt();
			break;

		}
	}
	//add your code here - добавь код тут
	}

	public static class RacingClock extends Thread 
	{
		public RacingClock() {
			start();
		}

		public void run() 
		{
			try
			{
				while (countSeconds>0)
				{
					System.out.print(countSeconds+" ");
					countSeconds--;
					Thread.sleep(1000);
				}
				System.out.print("Марш!");
			}

			catch (InterruptedException iex)
			{
				System.out.print("Прервано!");
			}
		}
	}
}
