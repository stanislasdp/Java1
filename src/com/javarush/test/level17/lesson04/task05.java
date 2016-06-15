package levrel17.lesson04;

/* МВФ
Singleton паттерн - синхронизация в методе
IMF - это Международный Валютный Фонд
Внутри метода getFund создайте синхронизированный блок
Внутри синхронизированного блока инициализируйте переменную imf так, чтобы метод getFund всегда возвращал один и тот же объект
*/

public class task05 
{
	public static class IMF 
	{
        private static IMF imf;

        public synchronized static IMF getFund() 
        {
        	
				if (imf == null)
				{
					imf = new IMF();
				}
            return imf;
        }

        private IMF() {
        }
    }
	
}
