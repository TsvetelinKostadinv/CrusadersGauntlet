package com.crusaders.gauntlet.java.input;

import java.util.Scanner;

public class TerminalInput implements InputMethods{

	@Override
	public String getUserInput() {
		Scanner input = new Scanner(System.in);
		String userInput = input.nextLine();
		return userInput;
	}

}