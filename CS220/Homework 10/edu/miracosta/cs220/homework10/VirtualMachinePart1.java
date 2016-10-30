package edu.miracosta.cs220.homework10;
import java.util.Scanner;

public class VirtualMachinePart1 
{
	public static void main(String[] args)
	{
		System.out.println("Please enter the location of the file you would like to translate: ");
		Scanner keyboard = new Scanner(System.in);
		String filePath = keyboard.nextLine();
		keyboard.close();
		Parser parser = new Parser(filePath);
		CodeWriter writer = new CodeWriter(filePath);
		String currentCommand, arg1;
		int arg2;
		while (parser.hasMoreCommands())
		{
			parser.advance();
			currentCommand = parser.getCommandWord();
			if (currentCommand.contains("push") || currentCommand.contains("pop"))
			{
				arg1 = parser.getArg1();
				arg2 = parser.getArg2();
//				System.out.println("Current command: " + currentCommand);
//				System.out.println("Argument 1: " + arg1);
//				System.out.println("Argument 2: " + arg2);
				writer.writePopPush(currentCommand, arg1, arg2);
			}
			
			else
			{
//				System.out.println("Current Command: " + currentCommand);
				writer.writeArithmetic(currentCommand);
			}
		}
		parser.close();
		writer.close();
		System.out.println("Done!");
	}
}
