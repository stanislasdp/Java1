package lesson08;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CustomInvocationHandler implements InvocationHandler {

	public SomeInterfaceWithMethods sm;
	
	public  CustomInvocationHandler(SomeInterfaceWithMethods sm) 
	{
		this.sm = sm;
	}
	
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable 
	{
	
		System.out.println(method.getName()+ " in");
		method.invoke(sm, args);
		System.out.println(method.getName()+ " out");
		
		return null;
	}

}
