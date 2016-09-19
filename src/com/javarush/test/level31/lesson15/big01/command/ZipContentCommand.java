package com.javarush.test.level31.lesson15.big01.command;

/**
 * Created by stas on 9/18/16.
 */
public class ZipContentCommand extends ZipCommand
{
     @Override
    public void execute() throws Exception
    {
    	ZipFileManager zipFileManager = getZipFileManager();
    	ConsoleHelper.writeMessage("Содержимое архива:");
    	List<FileProperties> fileList = zipFileManager.getFilesList();
    	
    	for (FileProperties fileProperties : fileList) 
    	{
    		ConsoleHelper.writeMessage(fileProperties.toString());
		}
    	ConsoleHelper.writeMessage("Содержимое архива прочитано.");
    }
}
