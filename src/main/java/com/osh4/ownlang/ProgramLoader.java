package com.osh4.ownlang;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ProgramLoader
{
	public static String loadFromFile(String fileName)
	{
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		URL resource = classloader.getResource(fileName);

		String programText = null;
		try
		{
			if (resource != null)
			{
				programText = Files.readString(Paths.get(resource.getFile()));
			}
		}
		catch (IOException ignored)
		{
		}

		if (programText == null)
		{
			System.out.println("File is empty or problems with loading");
			return null;
		}
		return programText;
	}
}
