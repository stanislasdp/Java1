package com.javarush.test.level33.lesson15.big01.strategies;

import com.javarush.test.level33.lesson15.big01.ExceptionHandler;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by stas on 10/8/16.
 */
public class FileBucket
{
    private Path path;

    public FileBucket()
    {

        try
        {
            path = Files.createTempFile("tmp",null);

        }
        catch (IOException ie)
        {
            ExceptionHandler.log(ie);
        }
        path.toFile().deleteOnExit();

    }

    public long getFileSize()
    {
        return path.toFile().length();
    }

   public void putEntry(Entry entry)
    {
        try (FileOutputStream fo = new FileOutputStream(path.toFile());
             ObjectOutputStream ou = new ObjectOutputStream(fo); )
        {

            ou.writeObject(entry);
        }
        catch (IOException ie)
        {
            ExceptionHandler.log(ie);
        }
    }

    public Entry getEntry()
    {
        if (getFileSize() == 0)
        {
            return null;
        }
        Entry entry = null;
        try (FileInputStream fi = new FileInputStream(path.toFile());
             ObjectInputStream ob = new ObjectInputStream(fi);)
        {
            entry = (Entry) ob.readObject();

        }
        catch (IOException ie)
        {
            ExceptionHandler.log(ie);
        }
        catch (ClassNotFoundException ce)
        {
            ExceptionHandler.log(ce);
        }
        return entry;
    }

    public void remove()
    {
        try
        {
            Files.delete(path);
        }
        catch (IOException ie)
        {
            ExceptionHandler.log(ie);
        }

    }
}
