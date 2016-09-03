package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.ConsoleHelper;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


/**
 * Created by stas on 9/3/16.
 */
public class BotClient extends Client//18.1
{
    @Override
    protected SocketThread getSocketThread()
    {
        return new BotSocketThread();//18.3.1
    }

    @Override
    protected boolean shouldSentTextFromConsole()
    {
        return false;//18.3.2
    }

    @Override
    protected String getUserName()//18.3.3
    {;
        return String.format("date_bot_%d",(int)(Math.random()*99));
    }

    public static void main(String[] args)
    {;
        new BotClient().run();//18.4
    }

    public class BotSocketThread extends Client.SocketThread//18.2
   {
       @Override
       protected void processIncomingMessage(String message) {

           // Вывести в консоль текст полученного сообщения message
           ConsoleHelper.writeMessage(message);

           // Получить из message имя отправителя и текст сообщения. Они разделены ": "
           String senderName = "";
           String senderMessageText;

           if (message.contains(": ")) {
               senderName = message.substring(0, message.indexOf(": "));
               senderMessageText = message.substring(message.indexOf(": ") + 2);
           }
           else {
               senderMessageText = message;
           }

           SimpleDateFormat format = null;
           // Отправить ответ в зависимости от текста принятого сообщения. Если текст сообщения:
           if ("дата".equalsIgnoreCase(senderMessageText)) {
               format = new SimpleDateFormat("d.MM.YYYY");
           }
           else if ("день".equalsIgnoreCase(senderMessageText)) {
               format = new SimpleDateFormat("d");
           }
           else if ("месяц".equalsIgnoreCase(senderMessageText)) {
               format = new SimpleDateFormat("MMMM");
           }
           else if ("год".equalsIgnoreCase(senderMessageText)) {
               format = new SimpleDateFormat("YYYY");
           }
           else if ("время".equalsIgnoreCase(senderMessageText)) {
               format = new SimpleDateFormat("H:mm:ss");
           }
           else if ("час".equalsIgnoreCase(senderMessageText)) {
               format = new SimpleDateFormat("H");
           }
           else if ("минуты".equalsIgnoreCase(senderMessageText)) {
               format = new SimpleDateFormat("m");
           }
           else if ("секунды".equalsIgnoreCase(senderMessageText)) {
               format = new SimpleDateFormat("s");
           }

           if (format != null)
           {
               sendTextMessage("Информация для " + senderName + ": " + format.format(Calendar.getInstance().getTime()));
           }

       }

       @Override
       protected void clientMainLoop() throws IOException, ClassNotFoundException//19.1
       {
           sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");//19.1.1
           //System.out.println("works");
           super.clientMainLoop(); //19.1.2

       }
   }
}
