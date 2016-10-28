package edu.miracosta.cs220.homework10;
import java.util.Scanner;
import java.util.HashMap;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

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
	
	public Parser()
	{
		try
		{
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
			System.out.println("Please enter the location of the file: ");
			Scanner keyboard = new Scanner(System.in);
			fileLocation = keyboard.nextLine();
			targetFile = new FileInputStream(fileLocation);
			input = new Scanner(targetFile);
			lineNumber = -1;
			arg2 = 0;
			arg1 = null;
			currentCommand = null;
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
			parseCommandType();
			parse();
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
	
	private void parseCommandType()
	{
		if (cleanLine.contains(ADD))
		{
			if (vmCodes.containsKey(ADD))
			{
				currentCommand = vmCodes.get(ADD);
				commandWord = ADD;
			}
			
			else if (vmCodes.containsKey(SUB))
			{
				currentCommand = vmCodes.get(SUB);
				commandWord = SUB;
			}
			
			else if (vmCodes.containsKey(NEG))
			{
				currentCommand = vmCodes.get(NEG);
				commandWord = NEG;
			}
			
			else if (vmCodes.containsKey(EQ))
			{
				currentCommand = vmCodes.get(EQ);
				commandWord = EQ;
			}
			
			else if (vmCodes.containsKey(GT))
			{
				currentCommand = vmCodes.get(GT);
				commandWord = GT;
			}
				
			else if (vmCodes.containsKey(LT))
			{
				currentCommand = vmCodes.get(LT);
				commandWord = LT;
			}
			
			else if (vmCodes.containsKey(AND))
			{
				currentCommand = vmCodes.get(AND);
				commandWord = AND;
			}
			
			else if (vmCodes.containsKey(OR))
			{
				currentCommand = vmCodes.get(OR);
				commandWord = OR;
			}
			
			else if (vmCodes.containsKey(NOT))
			{
				currentCommand = vmCodes.get(NOT);
				commandWord = NOT;
			}
			
			else if (vmCodes.containsKey(PUSH))
			{
				currentCommand = vmCodes.get(PUSH);
				commandWord = PUSH;
			}
			
			else if (vmCodes.containsKey(POP))
			{
				currentCommand = vmCodes.get(POP);
				commandWord = POP;
			}
			
			else if (vmCodes.containsKey(LABEL))
			{
				currentCommand = vmCodes.get(LABEL);
				commandWord = LABEL;
			}
			
			else if (vmCodes.containsKey(GOTO))
			{
				currentCommand = vmCodes.get(GOTO);
				commandWord = GOTO;
			}
			
			else if (vmCodes.containsKey(IF))
			{
				currentCommand = vmCodes.get(IF);
				commandWord = IF;
			}
			
			else if (vmCodes.containsKey(FUNCTION))
			{
				currentCommand = vmCodes.get(FUNCTION);
				commandWord = FUNCTION;
			}
			
			else if (vmCodes.containsKey(RETURN))
			{
				currentCommand = vmCodes.get(RETURN);
				commandWord = RETURN;
			}
			
			else if (vmCodes.containsKey(CALL))
			{
				currentCommand = vmCodes.get(CALL);
				commandWord = CALL;
			}
		}
	}
	
	private void parse()
	{
		int start = currentCommand.length() + 1;
		int stop = currentCommand.length() + 2;
		char letter;
		if (currentCommand != C_RETURN)
		{
			while (stop < cleanLine.length())
			{
				letter = cleanLine.charAt(stop);
				if (Character.isWhitespace(letter))
				{
					arg1 = cleanLine.substring(start, stop);				
					break;
				}
				
				stop++;
			}
		}
		
		if (currentCommand == C_PUSH || currentCommand == C_POP || currentCommand == C_FUNCTION || currentCommand == C_CALL)
		{
			start = stop + 1;
			arg2 = cleanLine.charAt(start);
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
}
