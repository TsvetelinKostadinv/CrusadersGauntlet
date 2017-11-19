package com.crusaders.gauntlet.java.test;

import java.util.ArrayList;

import com.crusaders.gauntlet.java.input.InputMethods;
import com.crusaders.gauntlet.java.input.TerminalInput;
import com.crusaders.gauntlet.java.output.DisplayMethods;
import com.crusaders.gauntlet.java.output.TerminalOutput;

public class TestingMenu {
	
	private ArrayList<String> displayMessages = new ArrayList<String>();
	private DisplayMethods display = new TerminalOutput();
	private InputMethods input = new TerminalInput();
	

	public void main(String[] args) {
		
		initMenu();
		
		displayMenu();
		
		input.getUserInput(); // unfinished class
	}

	private void initMenu() {
		fillDisplayMessages();
		
	}

	private void fillDisplayMessages() {
		displayMessages.add("[0] Exit");
		displayMessages.add("[1] Create a new Macro");
		displayMessages.add("[2] Execute Macro");
		displayMessages.add("[3] Edit Macro");
		
	}

	private void displayMenu() {
		
		for(int i=0;i<displayMessages.size();i++)
		{
			display.displayMessage(displayMessages.get(i));
		}
		
		
	}

}
