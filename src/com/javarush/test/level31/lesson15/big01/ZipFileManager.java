package com.javarush.test.level31.lesson15.big01;

import com.javarush.test.level31.lesson15.big01.exception.PathIsNotFoundException;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFileManager 
{
   // Полный путь zip файла
	private final Path zipFile;

	public ZipFileManager(Path zipFile) 
	{
		this.zipFile = zipFile;
	}

	public void createZip(Path source) throws Exception {
		// Проверяем, существует ли директория, где будет создаваться архив
		// При необходимости создаем ее
		Path zipDirectory = zipFile.getParent();
		if (Files.notExists(zipDirectory))
			Files.createDirectories(zipDirectory);

		// Создаем zip поток
		try (ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(zipFile))) 
		{

			if (Files.isDirectory(source)) {
				// Если архивируем директорию, то нужно получить список файлов в ней
				FileManager fileManager = new FileManager(source);
				List<Path> fileNames = fileManager.getFileList();

				// Добавляем каждый файл в архив
				for (Path fileName : fileNames)
					addNewZipEntry(zipOutputStream, source, fileName);

			} else if (Files.isRegularFile(source)) {

				// Если архивируем отдельный файл, то нужно получить его директорию и имя
				addNewZipEntry(zipOutputStream, source.getParent(), source.getFileName());
			} else {

				// Если переданный source не директория и не файл, бросаем исключение
				throw new PathIsNotFoundException();
			}
		}
	}

	private void addNewZipEntry(ZipOutputStream zipOutputStream, Path filePath, Path fileName) throws Exception {
		Path fullPath = filePath.resolve(fileName);
		try (InputStream inputStream = Files.newInputStream(fullPath)) 
		{
			ZipEntry entry = new ZipEntry(fileName.toString());

			zipOutputStream.putNextEntry(entry);

			copyData(inputStream, zipOutputStream);
			zipOutputStream.closeEntry();
		}
	}


	void copyData(InputStream in, OutputStream out) throws Exception {
		byte[] buffer = new byte[8 * 1024];
		int len;
		while ((len = in.read(buffer)) > 0) 
		{
			out.write(buffer, 0, len);
		}
	}

	public List<FileProperties> getFilesList() throws Exception
	{
		if (!Files.isRegularFile(zipFile))
		{
			throw new WrongZipFileException();
		}
		List<FileProperties> propertiesList = new ArrayList<FileProperties>();
		try(ZipInputStream zi = new ZipInputStream(Files.newInputStream(zipFile)))
		{
			ZipEntry zipEntry = null;
			while((zipEntry = zi.getNextEntry()) != null)
			{
				try (ByteArrayOutputStream bOut = new ByteArrayOutputStream())
				{
					copyData(zi, bOut);
					propertiesList.add(new FileProperties(zipEntry.getName(), bOut.size(), zipEntry.getCompressedSize(), zipEntry.getMethod()));
				}
			}
		}
		return propertiesList;
	}

	public void extractAll(Path outputFolder) throws Exception
	{
		if (Files.notExists(zipFile))
		{
			throw new WrongZipFileException();
		}
		if (Files.notExists(outputFolder))
		{
			Files.createDirectories(outputFolder);
		}
		try (ZipInputStream zi = new ZipInputStream(Files.newInputStream(outputFolder)))
		{
			ZipEntry zipEntry = null;

			while ((zipEntry = zi.getNextEntry())!= null)
			{
				Path fullpath = outputFolder.resolve(Paths.get(zipEntry.getName()));
				try (OutputStream fo = Files.newOutputStream(fullpath);)
				{
					copyData(zi, fo);
				}
			}
		}
	}
}
