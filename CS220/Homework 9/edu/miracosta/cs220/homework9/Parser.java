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
	private String rawLine;
	private String cleanLine;
	private char commandType;
	private String symbol;
	private String destMnemonic, compMnemonic, jumpMnemonic;
	
	public Parser(String inFileName)
	{
		inputFile = new Scanner(inFileName);
	}
	
	public boolean hasMoreCommands()
	{
		return inputFile.hasNextLine();
	}
	
	public void advance()
	{
		
	}
	
	public void cleanLine()
	{
		
	}
}
