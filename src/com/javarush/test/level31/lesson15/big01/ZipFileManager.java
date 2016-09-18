package com.javarush.test.level31.lesson15.big01;

import com.javarush.test.level31.lesson15.big01.exception.PathIsNotFoundException;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by stas on 9/17/16.
 */
public class ZipFileManager
{
    private final Path zipFile;

    public ZipFileManager(Path zipFile)
    {
        this.zipFile = zipFile;
    }

    public void createZip(Path source) throws Exception
    {
        if (Files.notExists(zipFile.getParent()))
        {
            Files.createDirectories(zipFile);
        }

        try ( ZipOutputStream zo =  new ZipOutputStream(Files.newOutputStream(zipFile));)
        {

            if (Files.isRegularFile(source))
            {
                addNewZipEntry(zo,source.getParent(),source.getFileName());
            }
            else if (Files.isDirectory(source))
            {
                FileManager fm = new FileManager(source);
                List<Path> allFIlesList = fm.getFileList();

                for (Path fileName: allFIlesList)
                {
                    addNewZipEntry(zo,source,fileName);
                }
            }
            else
            {
                throw new PathIsNotFoundException();
            }
        }

    }

    private void addNewZipEntry (ZipOutputStream zipOutputStream, Path filePath, Path fileName) throws Exception
    {
        try (InputStream is = Files.newInputStream(filePath.resolve(fileName)))
        {
            ZipEntry ze =new ZipEntry(fileName.toString());
            zipOutputStream.putNextEntry(ze);
            copyData(is,zipOutputStream);
            zipOutputStream.closeEntry();
        }
    }

    private void copyData(InputStream in, OutputStream out) throws Exception
    {
        byte[] buffer = new byte[8 * 1024];
        int len;
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer, 0, len);
        }
    }

}
