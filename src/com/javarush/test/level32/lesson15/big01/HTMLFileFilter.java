package com.javarush.test.level32.lesson15.big01;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Created by stas on 9/25/16.
 */
public class HTMLFileFilter extends FileFilter
{
    @Override
    public boolean accept(File f)
    {

        String fileName = f.getName();
        String html = ".html";
        String htm = ".htm";
        return  fileName.endsWith(html) || fileName.endsWith(html.toUpperCase()) || fileName.endsWith(htm) || fileName.endsWith(htm.toUpperCase()) || f.isDirectory();
    }

    @Override
    public String getDescription()
    {
        return "HTML и HTM файлы";
    }
}
