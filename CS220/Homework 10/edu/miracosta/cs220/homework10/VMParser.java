package edu.miracosta.cs220.homework10;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/*
 * Parser: Handles the parsing of a single .vm file, and encapsulates access to the input code. It reads VM commands,
	parses them, and provides convenient access to their components. In addition, it removes all white space and comments.	
 */

public class VMParser 
{
	private String fileLocation, rawLine, cleanLine;
	private FileInputStream targetFile;
	private Scanner input;
	private int lineNumber;
	
	public VMParser()
	{
		try
		{
			System.out.println("Please enter the location of the file: ");
			Scanner keyboard = new Scanner(System.in);
			fileLocation = keyboard.nextLine();
			targetFile = new FileInputStream(fileLocation);
			input = new Scanner(targetFile);
			lineNumber = -1;
			keyboard.close();
		}
		
		catch (FileNotFoundException e)
		{
			System.out.println(e.getLocalizedMessage());
		}
		
	}
	
	public boolean hasMoreCommands()
	{
		return input.hasNextLine();
	}
	
	public void advance()
	{
		if (hasMoreCommands())
		{
			lineNumber++;
			rawLine = input.nextLine();
			clean();
		}
		
	}
	
	private void clean()
	{
		int commentLocation = 0;
		commentLocation = rawLine.indexOf("//");
		
		if (commentLocation != -1)
			cleanLine = rawLine.substring(0, commentLocation);
		
		cleanLine = rawLine.trim();
		cleanLine = cleanLine.replaceAll("//", "");
		cleanLine = cleanLine.replaceAll(" ", "");
	}
}
