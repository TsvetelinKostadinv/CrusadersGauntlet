package com.crusaders.gauntlet.java.test;

import com.crusaders.gauntlet.java.models.Macro;

public class MacroTest {

	public static void main(String[] args) {
		
		Macro macro = new Macro();
		Macro secondMacro = new Macro();
		
		macro.initMacro();
		secondMacro.executeScript();
		
	}

}