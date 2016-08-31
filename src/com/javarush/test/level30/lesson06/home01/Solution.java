package com.javarush.test.level30.lesson06.home01;

/* Fork/Join
1. Создайте класс BinaryRepresentationTask. Для этого на красном имени класса нажмите Alt+Enter -> Create Class ...
(класс должен наследоваться от RecursiveTask)
2. Реализуйте логику метода compute, должна переводить число в двоичное представление.
3. Используйте методы fork и join.
4. Пример функциональной реализации - метод binaryRepresentationMethod.
*/
public class Solution {
    private String binaryRepresentationMethod(int x) {
        int a = x % 2;
        int b = x / 2;
        String result = String.valueOf(a);
        if (b > 0) {
            return binaryRepresentationMethod(b) + result;
        }
        return result;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String result1 = solution.binaryRepresentationMethod(6);
        System.out.println(result1);

        System.out.println();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        String result2 = forkJoinPool.invoke(new BinaryRepresentationTask(6));
        System.out.println(result2);
    }
    
    public static class BinaryRepresentationTask extends RecursiveTask<String>
{
	final int x;
	public BinaryRepresentationTask(int x) 
	{
		this.x = x;
	}

	@Override
	protected String compute() 
	{
		int a = x % 2;
		int b = x / 2;
		String result = String.valueOf(a);
		if (b > 0)
		{  
			BinaryRepresentationTask binRepTask = new BinaryRepresentationTask(b);
			binRepTask.fork();
			return binRepTask.join() + result;
		}
		return result;	
	}

}
