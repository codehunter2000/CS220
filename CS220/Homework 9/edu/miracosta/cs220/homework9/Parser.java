package edu.miracosta.cs220.homework9;
import java.util.Scanner;
public class Parser 
{
	public static final char NO_COMMAND = 'N';
	public static final char A_COMMAND = 'A';
	public static final char C_COMMAND = 'C';
	public static final char L_COMMAND = 'L';
	
	private Scanner inputFile;
	private int lineNumber;
	private static String rawLine;
	private String cleanLine;
	private static char commandType;
	private String symbol;
	private String destMnemonic, compMnemonic, jumpMnemonic;
	
	public Parser(String inFileName)
	{
		inputFile = new Scanner(inFileName);
		lineNumber = 0;
		rawLine = null;
		cleanLine = null;
		symbol = null;
		destMnemonic = null;
		compMnemonic = null;
		jumpMnemonic = null;
	}
	
	public boolean hasMoreCommands()
	{
		if (inputFile.hasNextLine())
			return true;
		else
		{
			inputFile.close();
			return false;
		}
	}
	
	public void advance()
	{
		if (inputFile.hasNextLine())
		{
			rawLine = inputFile.nextLine();
			lineNumber++;
		}
	}
	
	private void cleanLine()
	{
		int commentLocation = 0;
		commentLocation = rawLine.indexOf("//");
		
		if (commentLocation != -1)
			rawLine = rawLine.substring(0, commentLocation);
		
		rawLine = rawLine.trim();
		rawLine = rawLine.replaceAll("//", "");
		rawLine = rawLine.replaceAll(" ", "");
	}
	
	private void parseCommandType()
	{
		if(rawLine.charAt(0) == '@')
			commandType = 'A';
		else if (rawLine.charAt(0) == '(')
			commandType = 'L';
		else if (rawLine.length() == 0)
			commandType = 'N';
		else
			commandType = 'C';			
	}
	
	private void parse()
	{
		try
		{
			if (commandType == 'N')
			{
				symbol = null;
				destMnemonic = null;
				compMnemonic = null;
				jumpMnemonic = null;
			}
			else if (commandType == 'A')
				parseSymbol();
			else if (commandType == 'L')
				parseSymbol();
			else if (commandType == 'C')
				{
					parseDest();
					if (cleanLine.contains("="))
						parseComp();
					else if (cleanLine.contains(";"))
						parseJump();
				}
		}
		
		catch (Exception e)
		{
			e.getMessage();
		}
		
	}
	
	private void parseSymbol() throws Exception
	{
		try
		{
			if (cleanLine.contains("@"))
		
			symbol = cleanLine.substring(1, cleanLine.length()-1);
		else if (cleanLine.contains("(") && cleanLine.contains(")"))
				symbol = cleanLine.substring(1, cleanLine.length()-2);
		else
			throw new Exception(" /' ) /' expected.");
		}
		
		catch(Exception e)
		{
			e.getMessage();
		}
	}
	
	private void parseDest()
	{
		int stop = 0;
		if (cleanLine.contains("="))
		{
			stop = cleanLine.indexOf("=");
			destMnemonic = cleanLine.substring(0, stop);
		}
		
		else if (cleanLine.contains(";"))
		{
			stop = cleanLine.indexOf(";");
			destMnemonic = cleanLine.substring(0, stop);
		}
	}
	
	private void parseComp()
	{
		int start = cleanLine.indexOf("=");
		compMnemonic = cleanLine.substring(start, cleanLine.length()-1);
	}
	
	private void parseJump()
	{
		int start = cleanLine.indexOf(";");
		jumpMnemonic = cleanLine.substring(start, cleanLine.length()-1);
	}
	
	public char getCommandType()
	{
		return commandType;
	}
	
	public String getSymbol()
	{
		return symbol;
	}
	
	public String getDest()
	{
		return destMnemonic;
	}
	
	public String getComp()
	{
		return compMnemonic;
	}
	
	public String getJump()
	{
		return jumpMnemonic;
	}
	
	public String getCommandTypeString()
	{
		return null;
	}
	
	public String getRawLine()
	{
		return rawLine;
	}
	
	public String getCleanLine()
	{
		return cleanLine;
	}
	
	public int getLineNumber()
	{
		return lineNumber;
	}
}
