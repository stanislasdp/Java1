public class Solution
{

	/* Switch для нитей
	Обработайте список нитей в зависимости от состояния:
	1. Если нить еще не запущена, то запустите ее.
	2. Если нить в ожидании, то прервите ее.
	3. Если нить работает, то проверить маркер isInterrupted.
	4. Если нить прекратила работу, то выведите в консоль ее приоритет.
	Используйте switch.
	*/
	
	    public static void processThreads(Thread... threads) 
	    {
	    	 for (Thread thread : threads) 
	    	 {
				switch (thread.getState()) 
				{
				    case NEW:
					thread.start();
					break;
				    case WAITING:
				    thread.interrupt();
				    break;
				    case TIMED_WAITING:
				    thread.interrupt();	
				    break;
				    case BLOCKED:
				    thread.interrupt();
				    break;
				    case RUNNABLE:
				    thread.isInterrupted();	
				    break;	
				    case TERMINATED:
				    System.out.print(thread.getPriority());	
				}
				
			}
	        //implement this method - реализуйте этот метод
	}
	    
	    public static void main(String...args)
	    {
	    	Thread th = new Thread();
	    	
	    }
}
