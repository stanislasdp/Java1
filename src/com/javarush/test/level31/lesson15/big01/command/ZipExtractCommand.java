package com.javarush.test.level31.lesson15.big01.command;

/**
 * Created by stas on 9/18/16.
 */
public class ZipExtractCommand extends ZipCommand
{
    @Override
    public void execute() throws Exception
    {
    	
    	 try {
             ConsoleHelper.writeMessage("Распаковка архива.");

             ZipFileManager zipFileManager = getZipFileManager();

             ConsoleHelper.writeMessage("Введите полное имя файла или директории для распаковки:");
             Path outputPath = Paths.get(ConsoleHelper.readString());
             zipFileManager.extractAll(outputPath);

             ConsoleHelper.writeMessage("Распаковано");

         } catch (PathIsNotFoundException e)
    	 {
             ConsoleHelper.writeMessage("Вы неверно указали имя файла или директории.");
            // e.printStackTrace();
         }
    }
}
