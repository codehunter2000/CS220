package edu.miracosta.cs220.homework9;
import java.util.HashMap;
import java.util.Scanner;

public class SymbolTable 
{
	private static final String INITIAL_VALID_CHARS = "SP LCL ARG THIS THAT R0 R1 R2 R3 R4 R6 R7 R8 R9 R10 R11 R12 R13 R14 R15 SCREEN KBD";
	private static final String ALL_VALID_CHARS = INITIAL_VALID_CHARS + "0, 1, 2, 3, 4, 5, 6, 7, 8, 9";
	private HashMap<String, Integer> symbolTable;
	
	SymbolTable()
	{
		symbolTable = new HashMap<>();
		Scanner readLetters = new Scanner(INITIAL_VALID_CHARS);
		while(readLetters.hasNext())
		{
			String theLetters = readLetters.next();
			theLetters = theLetters.trim();
			if (theLetters.equals("SP"))
				symbolTable.put(theLetters, 0);
			else if (theLetters.equals("LCL"))
				symbolTable.put(theLetters, 1);
			else if (theLetters.equals("ARG"))
				symbolTable.put(theLetters, 2);
			else if (theLetters.equals("THIS"))
				symbolTable.put(theLetters, 3);
			else if (theLetters.equals("THAT"))
				symbolTable.put(theLetters, 4);
			else if (theLetters.equals("R0"))
				symbolTable.put(theLetters, 0);
			else if (theLetters.equals("R1"))
				symbolTable.put(theLetters, 1);
			else if (theLetters.equals("R2"))
				symbolTable.put(theLetters, 2);
			else if (theLetters.equals("R3"))
				symbolTable.put(theLetters, 3);
			else if (theLetters.equals("R4"))
				symbolTable.put(theLetters, 4);
			else if (theLetters.equals("R5"))
				symbolTable.put(theLetters, 5);
			else if (theLetters.equals("R6"))
				symbolTable.put(theLetters, 6);
			else if (theLetters.equals("R7"))
				symbolTable.put(theLetters, 7);
			else if (theLetters.equals("R8"))
				symbolTable.put(theLetters, 8);
			else if (theLetters.equals("R9"))
				symbolTable.put(theLetters, 9);
			else if (theLetters.equals("R10"))
				symbolTable.put(theLetters, 10);
			else if (theLetters.equals("R11"))
				symbolTable.put(theLetters, 11);
			else if (theLetters.equals("R12"))
				symbolTable.put(theLetters, 12);
			else if (theLetters.equals("R13"))
				symbolTable.put(theLetters, 13);
			else if (theLetters.equals("R14"))
				symbolTable.put(theLetters, 14);
			else if (theLetters.equals("R15"))
				symbolTable.put(theLetters, 15);
			else if (theLetters.equals("SCREEN"))
				symbolTable.put(theLetters, 16384);
			else if (theLetters.equals("KBD"))
				symbolTable.put(theLetters, 24576);
		}
	}
}
