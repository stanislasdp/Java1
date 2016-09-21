package com.javarush.test.level32.lesson06.task01;

import java.io.ByteArrayOutputStream;

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
		boolean isLowerCasePresent = false;
		boolean isUpperCasePresent = false;
		boolean isDigitPresent = false;

		while (!isLowerCasePresent || !isUpperCasePresent || !isDigitPresent)
		{
			bo.reset();
			for (int i =0; i <8; i++)
			{
				char lC = (char)(random.nextInt(26) + 'a');
				char UC = (char)(random.nextInt(26) + 'A');
				char Digit = (char)(random.nextInt(10) + '0');
				int flag = random.nextInt(3);
				switch (flag)
				{
				case 0:
					bo.write(lC);
					isLowerCasePresent = true;
					break;
				case 1:
					bo.write(UC);
					isUpperCasePresent = true;
					break;
				case 2:
					bo.write(Digit);
					isDigitPresent = true;
					break;
				}
			}
		}
		return bo;
	}
}
