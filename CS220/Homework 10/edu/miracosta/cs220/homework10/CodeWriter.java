package edu.miracosta.cs220.homework10;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CodeWriter 
{
	private String fileLocation, fileName;
	private PrintWriter outputStream;
	private static int labelCounter = 1;
	
	public CodeWriter(String file)
	{
		try 
		{
			fileLocation = file.substring(0,file.lastIndexOf('.')) + ".asm";
			outputStream = new PrintWriter(fileLocation);
			int start, index = fileLocation.length() - 1;
			char letter;
			if (fileLocation.contains("/") || fileLocation.contains("\\"))
			{
				while(index > 0)
				{
					letter = fileLocation.charAt(index);
					if (letter == '/' || letter == '\\')
					{
						start = index + 1;
						fileName = fileLocation.substring(start);
						break;
					}
					index--;
				}
			}
			else
			{
				fileName = fileLocation;
			}
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
			String line2 = "A = M - 1";
			String line3 = "M = -M";
			outputStream.println(line1);
			outputStream.println(line2);
			outputStream.println(line3);
		}
		
		else if (command.contains("eq"))
		{
			String line1 = "@SP";
			String line2 = "AM = M - 1";
			String line3 = "D = M";
			String line4 = "A = A - 1";
			String line5 = "D = M - D";
			String line6 = "@_" + labelCounter;
			labelCounter++;
			String line7 = "D;JEQ";
			String line8 = "@SP";
			String line9 = "A = M - 1";
			String line10 = "M = 0";
			String line11 = "@_" + labelCounter;
			labelCounter--;
			String line12 = "0;JMP";
			String line13 = "(_" + labelCounter + ")";
			labelCounter++;
			String line14 = "@SP";
			String line15 = "A = M - 1";
			String line16 = "M = -1";
			String line17 = "(_" + labelCounter + ")";
			labelCounter++;
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
		}
		
		else if (command.contains("gt"))
		{
			String line1 = "@SP";
			String line2 = "AM = M - 1";
			String line3 = "D = M";
			String line4 = "A = A - 1";
			String line5 = "D = M - D";
			String line6 = "@_" + labelCounter;
			labelCounter++;
			String line7 = "D;JGT";
			String line8 = "@SP";
			String line9 = "A = M - 1";
			String line10 = "M = 0";
			String line11 = "@_" + labelCounter;
			labelCounter--;
			String line12 = "0;JMP";
			String line13 = "(_" + labelCounter + ")";
			labelCounter++;
			String line14 = "@SP";
			String line15 = "A = M - 1";
			String line16 = "M = -1";
			String line17 = "(_" + labelCounter + ")";
			labelCounter++;
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
		}
		
		else if (command.contains("lt"))
		{
			String line1 = "@SP";
			String line2 = "AM = M - 1";
			String line3 = "D = M";
			String line4 = "A = A - 1";
			String line5 = "D = M - D";
			String line6 = "@_" + labelCounter;
			labelCounter++;
			String line7 = "D;JLT";
			String line8 = "@SP";
			String line9 = "A = M - 1";
			String line10 = "M = 0";
			String line11 = "@_" + labelCounter;
			labelCounter--;
			String line12 = "0;JMP";
			String line13 = "(_" + labelCounter + ")";
			labelCounter++;
			String line14 = "@SP";
			String line15 = "A = M - 1";
			String line16 = "M = -1";
			String line17 = "(_" + labelCounter + ")";
			labelCounter++;
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
		}
		
		else if (command.contains("and"))
		{
			String line1 = "@SP";
			String line2 = "AM = M - 1";
			String line3 = "D = M";
			String line4 = "A = A - 1";
			String line5 = "M = M&D";
			outputStream.println(line1);
			outputStream.println(line2);
			outputStream.println(line3);
			outputStream.println(line4);
			outputStream.println(line5);
		}
		
		else if (command.contains("or"))
		{
			String line1 = "@SP";
			String line2 = "AM = M - 1";
			String line3 = "D = M";
			String line4 = "A = A - 1";
			String line5 = "M = M|D";
			outputStream.println(line1);
			outputStream.println(line2);
			outputStream.println(line3);
			outputStream.println(line4);
			outputStream.println(line5);
		}
		
		else if (command.contains("not"))
		{
			String line1 = "@SP";
			String line2 = "A = M - 1";
			String line3 = "D = !M";
			outputStream.println(line1);
			outputStream.println(line2);
			outputStream.println(line3);
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
			
			else if (segment.contains("static"))
			{
				String line1 = "@" + fileName + "." + index;
				String line2 = "D = M";
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
				String line1 = "@LCL";
				String line2 = "D = M";
				String line3 = "@" + index;
				String line4 = "A = D + A";
				String line5 = "D = M";
				String line6 = "@SP";
				String line7 = "AM = M + 1";
				String line8 = "A = A - 1";
				String line9 = "M = D";
				outputStream.println(line1);
				outputStream.println(line2);
				outputStream.println(line3);
				outputStream.println(line4);
				outputStream.println(line5);
				outputStream.println(line6);
				outputStream.println(line7);
				outputStream.println(line8);
				outputStream.println(line9);
			}
			
			else if (segment.contains("argument"))
			{
				String line1 = "@ARG";
				String line2 = "D = M";
				String line3 = "@" + index;
				String line4 = "A = D + A";
				String line5 = "D = M";
				String line6 = "@SP";
				String line7 = "AM = M + 1";
				String line8 = "A = A - 1";
				String line9 = "M = D";
				outputStream.println(line1);
				outputStream.println(line2);
				outputStream.println(line3);
				outputStream.println(line4);
				outputStream.println(line5);
				outputStream.println(line6);
				outputStream.println(line7);
				outputStream.println(line8);
				outputStream.println(line9);
			}
			
			else if (segment.contains("this"))
			{
				String line1 = "@THIS";
				String line2 = "D = M";
				String line3 = "@" + index;
				String line4 = "A = D + A";
				String line5 = "D = M";
				String line6 = "@SP";
				String line7 = "AM = M + 1";
				String line8 = "A = A - 1";
				String line9 = "M = D";
				outputStream.println(line1);
				outputStream.println(line2);
				outputStream.println(line3);
				outputStream.println(line4);
				outputStream.println(line5);
				outputStream.println(line6);
				outputStream.println(line7);
				outputStream.println(line8);
				outputStream.println(line9);
			}
			
			else if (segment.contains("that"))
			{
				String line1 = "@THAT";
				String line2 = "D = M";
				String line3 = "@" + index;
				String line4 = "A = D + A";
				String line5 = "D = M";
				String line6 = "@SP";
				String line7 = "AM = M + 1";
				String line8 = "A = A - 1";
				String line9 = "M = D";
				outputStream.println(line1);
				outputStream.println(line2);
				outputStream.println(line3);
				outputStream.println(line4);
				outputStream.println(line5);
				outputStream.println(line6);
				outputStream.println(line7);
				outputStream.println(line8);
				outputStream.println(line9);
			}
		}
		
		else if (command.contains("pop"))
		{
			if (segment.contains("local"))
			{
				// Access Local
				String line1 = "@LCL";
				// Store address value in D
				String line2 = "D = M";
				// Get 16-bit value for index
				String line3 = "@" + index;
				// Add LCL + the 16-bit value calculated
				// to get the memory location inside Local
				// Call it Local[x]
				String line4 = "D = D + A";
				// Access RAM[13] location
				String line5 = "@R13";
				// Save Local[x] address at R13
				String line6 = "M = D";
				// Call stack pointer
				String line7 = "@SP";
				// Decrement value of stack point
				// Should now point to value @ top of stack
				String line8 = "AM = M - 1";
				// Save the value @ top of stack
				String line9 = "D = M";
				// Access RAM[13] location
				String line10 = "@R13";
				// Save the address Local[x] in A register
				// Should now point to address of Local[x]
				String line11 = "A = M";
				// Save value from the top of the stack
				// in the location at address Local[x]
				String line12 = "M = D";
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
			}
			
			else if (segment.contains("argument"))
			{
				String line1 = "@ARG";
				String line2 = "D = M";
				String line3 = "@" + index;
				String line4 = "D = D + A";
				String line5 = "@R13";
				String line6 = "M = D";
				String line7 = "@SP";
				String line8 = "AM = M - 1";
				String line9 = "D = M";
				String line10 = "@R13";
				String line11 = "A = M";
				String line12 = "M = D";
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
			}
			
			else if (segment.contains("this"))
			{
				String line1 = "@THIS";
				String line2 = "D = M";
				String line3 = "@" + index;
				String line4 = "D = D + A";
				String line5 = "@R13";
				String line6 = "M = D";
				String line7 = "@SP";
				String line8 = "AM = M - 1";
				String line9 = "D = M";
				String line10 = "@R13";
				String line11 = "A = M";
				String line12 = "M = D";
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
			}
			
			else if (segment.contains("that"))
			{
				String line1 = "@THAT";
				String line2 = "D = M";
				String line3 = "@" + index;
				String line4 = "D = D + A";
				String line5 = "@R13";
				String line6 = "M = D";
				String line7 = "@SP";
				String line8 = "AM = M - 1";
				String line9 = "D = M";
				String line10 = "@R13";
				String line11 = "A = M";
				String line12 = "M = D";
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
			}
			
			else if (segment.contains("temp"))
			{
				
			}
			
			else if (segment.contains("static"))
			{
				String line1 = "@" + fileName + "." + index;
				String line2 = "D = A";
				String line3 = "@R13";
				String line4 = "M = D";
				String line5 = "@SP";
				String line6 = "AM = M - 1";
				String line7 = "D = M";
				String line8 = "@R13";
				String line9 = "A = M";
				String line10 = "M = D";
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
			}
		}
	}
	
	public void close()
	{
		outputStream.close();
	}
}
