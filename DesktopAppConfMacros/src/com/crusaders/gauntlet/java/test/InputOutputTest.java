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
		
		String msg = input.getUserInput();
		output.displayMessage(msg);
	}
	
}
