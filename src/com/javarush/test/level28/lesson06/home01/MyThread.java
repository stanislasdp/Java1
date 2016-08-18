package lesson06;

public class MyThread extends Thread 
{
	static int threadPriority = 0;

	public MyThread() 
	{
		super();
		setPriority(this);
		
	}

	public MyThread(Runnable target, String name) 
	{
		
		super(target, name);
		setPriority(this);
		
	}

	public MyThread(Runnable target) {
		
		super(target);
		setPriority(this);
	}

	public MyThread(String name) 
	{
		super(name);
		setPriority(this);
	}

	public MyThread(ThreadGroup group, Runnable target, String name,long stackSize) 
	{
		super(group, target, name, stackSize);
		setPriority(this);
	}

	public MyThread(ThreadGroup group, Runnable target, String name) 
	{
		super(group, target, name);
		setPriority(this);
	}

	public MyThread(ThreadGroup group, Runnable target) {
		super(group, target);
		setPriority(this);
	}

	public MyThread(ThreadGroup group, String name) 
	{
		super(group, name);
		setPriority(this);
	}
	
	
	private void setPriority (Thread th)
	{
		

		th.setPriority(++threadPriority);
		if (threadPriority==10)
		{
			threadPriority=0;
		}
	}
	

}
