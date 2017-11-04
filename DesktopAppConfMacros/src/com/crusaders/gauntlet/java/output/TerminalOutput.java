package com.crusaders.gauntlet.java.output;

public class TerminalOutput implements DisplayMethods {

	@Override
	public void displayMessage(String msg) {
		System.out.println(msg);
	}

}
