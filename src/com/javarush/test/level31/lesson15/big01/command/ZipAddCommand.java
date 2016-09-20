package com.javarush.test.level31.lesson15.big01.command;

/**
 * Created by stas on 9/18/16.
 */
public class ZipAddCommand extends ZipCommand
{
   try 
    	{
    	ZipFileManager zipFileManager = getZipFileManager();
		Path addPath = Paths.get(ConsoleHelper.readString());
		ConsoleHelper.writeMessage("Enter file path to add");
		zipFileManager.addFile(addPath);
    	}
    	catch (PathIsNotFoundException pe)
    	{
    		ConsoleHelper.writeMessage("Вы неверно указали имя файла или директории.");
    	}
    	
}
