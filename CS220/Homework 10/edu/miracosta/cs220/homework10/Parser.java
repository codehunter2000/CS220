package edu.miracosta.cs220.homework10;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

/*
 * Parser: Handles the parsing of a single .vm file, and encapsulates access to the input code. It reads VM commands,
	parses them, and provides convenient access to their components. In addition, it removes all white space and comments.	
 */

public class Parser 
{
	private String fileLocation, rawLine, cleanLine, arg1, currentCommand, commandWord;
	private FileInputStream targetFile;
	private Scanner input;
	private int lineNumber, arg2;
	private HashMap<String, String> vmCodes;
	private static final String C_ARTH = "C_ARITHMETIC";
	private static final String C_PUSH = "C_PUSH";
	private static final String C_POP = "C_POP";
	private static final String C_LABEL = " C_LABEL";
	private static final String C_GOTO = " C_GOTO";
	private static final String C_IF = "C_IF";
	private static final String C_FUNCTION  = "C_FUNCTION";
	private static final String C_RETURN = "C_RETURN";
	private static final String C_CALL = "C_CALL";
	private static final String ADD = "add";
	private static final String SUB = "sub";
	private static final String NEG = "neg";
	private static final String EQ = "eq";
	private static final String GT = "gt";
	private static final String LT = "lt";
	private static final String AND = "and";
	private static final String OR = "or";
	private static final String NOT = "not";
	private static final String PUSH = "push";
	private static final String POP = "pop";
	private static final String LABEL = "label";
	private static final String GOTO = "goto";
	private static final String IF = "if";
	private static final String FUNCTION = "function";
	private static final String RETURN = "return";
	private static final String CALL = "call";
	
	public Parser(String filePath)
	{
		try
		{
			fileLocation = filePath;
			targetFile = new FileInputStream(fileLocation);
			input = new Scanner(targetFile);
			lineNumber = -1;
			arg2 = 0;
			arg1 = null;
			currentCommand = null;
			vmCodes = new HashMap<>();
			vmCodes.put(ADD, C_ARTH);
			vmCodes.put(SUB, C_ARTH);
			vmCodes.put(NEG, C_ARTH);
			vmCodes.put(EQ, C_ARTH);
			vmCodes.put(GT, C_ARTH);
			vmCodes.put(LT, C_ARTH);
			vmCodes.put(AND, C_ARTH);
			vmCodes.put(OR, C_ARTH);
			vmCodes.put(NOT, C_ARTH);
			vmCodes.put(PUSH, C_PUSH);
			vmCodes.put(POP, C_POP);
			vmCodes.put(LABEL, C_LABEL);
			vmCodes.put(GOTO, C_GOTO);
			vmCodes.put(IF, C_IF);
			vmCodes.put(FUNCTION, C_FUNCTION);
			vmCodes.put(RETURN, C_RETURN);
			vmCodes.put(CALL, C_CALL);
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
			parseCommandType();
			parse();
		}
		
	}
	
	private void clean()
	{
		cleanLine = rawLine;
	}
	
	private void parseCommandType()
	{
		if (cleanLine.contains(ADD))
		{
			currentCommand = vmCodes.get(ADD);
			commandWord = ADD;
		}
		
		else if (cleanLine.contains(SUB))
		{
			currentCommand = vmCodes.get(SUB);
			commandWord = SUB;
		}
		
		else if (cleanLine.contains(NEG))
		{
			currentCommand = vmCodes.get(NEG);
			commandWord = NEG;
		}
		
		else if (cleanLine.contains(EQ))
		{
			currentCommand = vmCodes.get(EQ);
			commandWord = EQ;
		}
		
		else if (cleanLine.contains(GT))
		{
			currentCommand = vmCodes.get(GT);
			commandWord = GT;
		}
			
		else if (cleanLine.contains(LT))
		{
			currentCommand = vmCodes.get(LT);
			commandWord = LT;
		}
		
		else if (cleanLine.contains(AND))
		{
			currentCommand = vmCodes.get(AND);
			commandWord = AND;
		}
		
		else if (cleanLine.contains(OR))
		{
			currentCommand = vmCodes.get(OR);
			commandWord = OR;
		}
		
		else if (cleanLine.contains(NOT))
		{
			currentCommand = vmCodes.get(NOT);
			commandWord = NOT;
		}
		
		else if (cleanLine.contains(PUSH))
		{
			currentCommand = vmCodes.get(PUSH);
			commandWord = PUSH;
		}
		
		else if (cleanLine.contains(POP))
		{
			currentCommand = vmCodes.get(POP);
			commandWord = POP;
		}
		
		else if (cleanLine.contains(LABEL))
		{
			currentCommand = vmCodes.get(LABEL);
			commandWord = LABEL;
		}
		
		else if (cleanLine.contains(GOTO))
		{
			currentCommand = vmCodes.get(GOTO);
			commandWord = GOTO;
		}
		
		else if (cleanLine.contains(IF))
		{
			currentCommand = vmCodes.get(IF);
			commandWord = IF;
		}
		
		else if (cleanLine.contains(FUNCTION))
		{
			currentCommand = vmCodes.get(FUNCTION);
			commandWord = FUNCTION;
		}
		
		else if (cleanLine.contains(RETURN))
		{
			currentCommand = vmCodes.get(RETURN);
			commandWord = RETURN;
		}
		
		else if (cleanLine.contains(CALL))
		{
			currentCommand = vmCodes.get(CALL);
			commandWord = CALL;
		}
	}
	
	private void parse()
	{
		int start = commandWord.length();
		int stop = commandWord.length() + 1;
		String number;
		char letter;
		if (currentCommand != C_RETURN)
		{
			while (stop < cleanLine.length())
			{
				letter = cleanLine.charAt(stop);
				if (Character.isWhitespace(letter))
				{
					arg1 = cleanLine.substring(start, stop);
					arg1 = arg1.trim();
					break;
				}
				
				stop++;
			}
		}
		
		
		
		if (currentCommand == C_PUSH || currentCommand == C_POP || currentCommand == C_FUNCTION || currentCommand == C_CALL)
		{
			number = cleanLine.substring(stop+1);
			arg2 = Integer.parseInt(number);
		}
	}
	
	
	/*
	 * Returns the first arg. of the current command.
		In the case of C_ARITHMETIC, the command itself
		(add, sub, etc.) is returned. Should not be called
		if the current command is C_RETURN.
	 */
	public String getArg1()
	{
		return arg1;
	}
	
	
	/*
	 * Returns the second argument of the current
		command. Should be called only if the current
		command is C_PUSH, C_POP, C_FUNCTION, or
		C_CALL
	 */
	public int getArg2()
	{
		return arg2;
	}
	
	public String getCommandWord()
	{
		return commandWord;
	}
	
	public void close()
	{
		input.close();
	}
}
