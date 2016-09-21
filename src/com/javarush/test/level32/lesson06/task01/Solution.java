package com.javarush.test.level32.lesson06.task01;

import java.io.ByteArrayOutputStream;
import java.util.Random;

/* Генератор паролей
Реализуйте логику метода getPassword, который должен возвращать ByteArrayOutputStream, в котором будут байты пароля.
Требования к паролю:
1) 8 символов
2) только цифры и латинские буквы разного регистра
3) обязательно должны присутствовать цифры, и буквы разного регистра
Все сгенерированные пароли должны быть уникальные.
Пример правильного пароля:
wMh7SmNu
*/
public class Solution {
   public static void main(String[] args) 
	{
		ByteArrayOutputStream password = getPassword();
		System.out.println(password.toString());
	}

	public static ByteArrayOutputStream getPassword() 
	{
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		Random random = new Random();
			bo.reset();

			for (int i =0;i < 3;i++)
			{
				char lC = (char)(random.nextInt(26) + 'a');
				bo.write(lC);
			}
			for (int i =0;i < 3;i++)
			{
				char UC = (char)(random.nextInt(26) + 'A');
				bo.write(UC);
			}
			for (int i =0;i < 2;i++)
			{
				char Digit = (char)(random.nextInt(10) + '0');
				bo.write(Digit);
			}

		return bo;
	}
}
