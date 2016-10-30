package edu.miracosta.cs220.homework10;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CodeWriter 
{
	private String fileLocation;
	private PrintWriter outputStream;
	private Parser parser;
	private int labelCounter;
	
	public CodeWriter(String file)
	{
		try 
		{
			fileLocation = file;
			outputStream = new PrintWriter(fileLocation);
			parser = new Parser();
			labelCounter = 1;
			
		} 
		
		catch (FileNotFoundException e) 
		{
			System.out.println(e.getLocalizedMessage());
		}
	}
	
	public void writeArithmetic(String command)
	{
		if (command.contains("add"))
		{
			String line1 = "@SP";
			String line2 = "AM = M - 1";
			String line3 = "D = M";
			String line4 = "A = A - 1";
			String line5 = "M = M + D";
			outputStream.println(line1);
			outputStream.println(line2);
			outputStream.println(line3);
			outputStream.println(line4);
			outputStream.println(line5);
		}
		
		else if (command.contains("sub"))
		{
			String line1 = "@SP";
			String line2 = "AM = M - 1";
			String line3 = "D = M";
			String line4 = "A = A - 1";
			String line5 = "M = M - D";
			outputStream.println(line1);
			outputStream.println(line2);
			outputStream.println(line3);
			outputStream.println(line4);
			outputStream.println(line5);
		}
		
		else if (command.contains("neg"))
		{
			String line1 = "@SP";
			String line2 = "AM = M - 1";
			String line3 = "M = -M";
			outputStream.println(line1);
			outputStream.println(line2);
			outputStream.println(line3);
		}
		
		else if (command.contains("eq"))
		{
			String line1 = "@SP";
			String line2 = "A = M - 1";
			String line3 = "A = M - 1";
			String line4 = "D = M";
			String line5 = "A = A + 1";
			String line6 = "D = D - M";
			String line7 = "@_1";
			String line8 = "D;JEQ";
			String line9 = "@_2";
			String line10 = "D = 0";
			String line11 = "0;JMP";
			String line12 = "(_1)";
			String line13 = "D = -1";
			String line14 = "(_2)";
			String line15 = "@SP";
			String line16 = "AM = M - 1";
			String line17 = "A = A - 1";
			String line18 = "M = D";
			outputStream.println(line1);
			outputStream.println(line2);
			outputStream.println(line3);
			outputStream.println(line4);
			outputStream.println(line5);
			outputStream.println(line6);
			outputStream.println(line7);
			outputStream.println(line8);
			outputStream.println(line9);
			outputStream.println(line10);
			outputStream.println(line11);
			outputStream.println(line12);
			outputStream.println(line13);
			outputStream.println(line14);
			outputStream.println(line15);
			outputStream.println(line16);
			outputStream.println(line17);
			outputStream.println(line18);
		}
		
		else if (command.contains("gt"))
		{
			String line1 = "@SP";
			// Might be A = A - 1
			String line2 = "A = M - 1";
			String line3 = "A = A - 1";
			String line4 = "D = M";
			String line5 = "A = A + 1";
			String line6 = "D = D - M";
			String line7 = "@_" + labelCounter;
			String line8 = "D;JGT";
			String line9 = "@_" + labelCounter+1;
			String line10 = "D = 0";
			String line11 = "0;JMP";
			String line12 = "(_" + labelCounter + ")";
			labelCounter++;
			String line13 = "D = -1";
			String line14 = "(_" + labelCounter + ")";
			String line15 = "@SP";
			String line16 = "AM = M - 1";
			String line17 = "A = A - 1";
			String line18 = "M = D";
			outputStream.println(line1);
			outputStream.println(line2);
			outputStream.println(line3);
			outputStream.println(line4);
			outputStream.println(line5);
			outputStream.println(line6);
			outputStream.println(line7);
			outputStream.println(line8);
			outputStream.println(line9);
			outputStream.println(line10);
			outputStream.println(line11);
			outputStream.println(line12);
			outputStream.println(line13);
			outputStream.println(line14);
			outputStream.println(line15);
			outputStream.println(line16);
			outputStream.println(line17);
			outputStream.println(line18);
		}
		
		else if (command.contains("lt"))
		{
			
		}
		
		else if (command.contains("and"))
		{
			String line1 = "@SP";
			String line2 = "A = A - 1";
			String line3 = "A = A - 1";
			String line4 = "D = M";
			String line5 = "A = A + 1";
			String line6 = "D = D&M";
			outputStream.println(line1);
			outputStream.println(line2);
			outputStream.println(line3);
			outputStream.println(line4);
			outputStream.println(line5);
			outputStream.println(line6);
		}
		
		else if (command.contains("or"))
		{
			String line1 = "@SP";
			String line2 = "A = A - 1";
			String line3 = "A = A - 1";
			String line4 = "D = M";
			String line5 = "A = A + 1";
			String line6 = "D = D|M";
			
		}
		
		else if (command.contains("not"))
		{
			String line1 = "@SP";
			String line2 = "A = A - 1";
			String line3 = "D = !M";
		}
	}
	
	public void writePopPush(String command, String segment, int index)
	{
		if (command.contains("push"))
		{
			if (segment.contains("constant"))
			{
				String line1 = "@" + index;
				String line2 = "D = A";
				String line3 = "@SP";
				String line4 = "AM = M + 1";
				String line5 = "A = A - 1";
				String line6 = "M = D";
				outputStream.println(line1);
				outputStream.println(line2);
				outputStream.println(line3);
				outputStream.println(line4);
				outputStream.println(line5);
				outputStream.println(line6);
			}
			
			else if (segment.contains("local"))
			{
				
			}
			
			else if (segment.contains("argument"))
			{
				
			}
		}
		
		else if (command.contains("pop"))
		{
			if (segment.contains("local"))
			{
				String line1 = "@SP";
				String line2 = "AM = M - 1";
				String line3 = "D = M";
				String line4 = "@LCL";
				String line5 = "A = M + 1";
				String line6 = "A = A + 1";
				String line7 = "M = D";
				outputStream.println(line1);
				outputStream.println(line2);
				outputStream.println(line3);
				outputStream.println(line4);
				outputStream.println(line5);
				outputStream.println(line6);
				outputStream.println(line7);
			}
			
			else if (segment.contains("static"))
			{
				String line1 = "@SP";
				String line2 = "AM = M - 1";
				String line3 = "D = M";
				String line4 = "@f." + index;
				String line5 = "M = D";
				outputStream.println(line1);
				outputStream.println(line2);
				outputStream.println(line3);
				outputStream.println(line4);
				outputStream.println(line5);
			}
		}
	}
	
	public void close()
	{
		outputStream.close();
	}
}
