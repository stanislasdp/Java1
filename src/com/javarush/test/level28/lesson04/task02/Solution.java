package com.javarush.test.level28.lesson04.task02;

import java.util.concurrent.ThreadLocalRandom;

/* ThreadLocalRandom
Класс Solution будет использоваться трэдами.
Реализуйте логику всех методов, используйте класс ThreadLocalRandom.
getRandomIntegerBetweenNumbers должен возвращать случайный int между from и to
getRandomDouble должен возвращать случайный double
getRandomLongBetween0AndN должен возвращать случайный long между 0 и n
*/
public class Solution 
{
     public static synchronized int getRandomIntegerBetweenNumbers(int from, int to) 
	 {
	        return ThreadLocalRandom.current().nextInt(from,to);
	    }

	    public static synchronized double getRandomDouble() 
	    {
	        return ThreadLocalRandom.current().nextDouble();
	    }

	    public static synchronized long getRandomLongBetween0AndN(long n) 
	    {
	        return ThreadLocalRandom.current().nextLong(n);
	    }
}
