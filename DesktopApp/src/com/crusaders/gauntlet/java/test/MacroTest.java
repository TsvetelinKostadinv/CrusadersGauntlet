package com.crusaders.gauntlet.java.test;

import com.crusaders.gauntlet.java.models.macroFunctionality.Macro;

public class MacroTest {

	public static void main(String[] args) {
		
		Macro macro = new Macro();
		//Macro secondMacro = new Macro();
		
		macro.initMacro();
		//secondMacro.initMacro();
		
		macro.executeScript();
		//secondMacro.executeScript();
		
//		Macro macros[] = new Macro[20];
//		
//		for (int i = 0; i < macros.length; i++) {
//			macros[i] = new Macro();
//			macros[i].initMacro();
//		}
	}

}
