package edu.miracosta.cs220.homework10;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CodeWriter 
{
	private String fileLocation;
	private PrintWriter outputStream;
	
	public CodeWriter(String file)
	{
		try 
		{
			fileLocation = file;
			outputStream = new PrintWriter(fileLocation);
		} 
		
		catch (FileNotFoundException e) 
		{
			System.out.println(e.getLocalizedMessage());
		}
	}
	
	public void writeArithmetic(String command)
	{
		
	}
	
	public void writePopPush(String command, String segment, int index)
	{
		
	}
	
	
	public void close()
	{
		outputStream.close();
	}
}
