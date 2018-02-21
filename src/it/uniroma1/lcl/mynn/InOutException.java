package it.uniroma1.lcl.mynn;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class InOutException extends Exception
{
	@Override
	public String getMessage()
	{
		return "poro cio";
		
	}
	public void provaException() throws InOutException
	{
		try
		{
			StringBuilder str = new StringBuilder();
			Files.newBufferedReader(Paths.get(new File(".").getCanonicalPath() + "/ciao")).lines().forEach(l -> {
				str.append(l);
				str.append("\n");
				
			});}
		catch(Exception e)
		{
			e.getMessage();
		}
	}
	public static void main(String[] args) {
		
	}
}
