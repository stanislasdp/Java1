package kitchen;

import java.util.Observable;
import java.util.Observer;

import main.ConsoleHelper;

public class Waitor implements Observer
{

	@Override
	public void update(Observable o, Object arg) 
	{
		ConsoleHelper.writeMessage(arg+" was cooked by " + o);
	}	
}
