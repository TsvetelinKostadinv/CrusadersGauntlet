package com.crusaders.gauntlet.java.test;

import com.crusaders.gauntlet.java.input.InputMethods;
import com.crusaders.gauntlet.java.input.TerminalInput;
import com.crusaders.gauntlet.java.output.DisplayMethods;
import com.crusaders.gauntlet.java.output.TerminalOutput;

public class InputOutputTest {
	
	public static void main(String[] args)
	{
		DisplayMethods output = new TerminalOutput();
		InputMethods input = new TerminalInput();
		
		System.out.println("Input the message: ");
		String msg = input.getUserInput();
		System.out.println("The message is: ");
		output.displayMessage(msg);
	}
	
	// 06.11.2017 WORKING
	
}
