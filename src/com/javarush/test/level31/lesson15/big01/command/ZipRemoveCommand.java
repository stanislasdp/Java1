package com.javarush.test.level31.lesson15.big01.command;

import com.javarush.test.level31.lesson15.big01.ConsoleHelper;
import com.javarush.test.level31.lesson15.big01.ZipFileManager;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by stas on 9/18/16.
 */
public class ZipRemoveCommand extends ZipCommand
{
    @Override
    public void execute() throws Exception
    {
        ZipFileManager zipFileManager = getZipFileManager();
        Path removePath = Paths.get(ConsoleHelper.readString());

        zipFileManager.removeFile(removePath);

/*
        3.	Реализуй метод execute() класса ZipRemoveCommand, создав объект класса ZipFileManager,
            спросив пользователя из какого архива и какой файл будем удалять, и вызвав метод removeFile().
            Все остальное, как и в других командах. Исключение PathIsNotFoundException можно не ловить, т.к. метод
        removeFile() не должен его кидать.*/
    }
}
