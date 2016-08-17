package kitchen;

import java.util.Observable;
import java.util.Observer;

import main.ConsoleHelper;

public class Cook implements Observer
{
	String name;

	public Cook(String name)
	{
		this.name = name;
	}
	
	@Override
	public String toString() 
	{
		return name;
	}

	@Override
	public void update(Observable o, Object arg) 
	{
		ConsoleHelper.writeMessage("Start cooking - "+arg);
	}
	
	
}
