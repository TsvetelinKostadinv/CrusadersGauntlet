package com.crusaders.gauntlet.java.models.codeGeneration;

import java.util.HashMap;

public abstract class CodeGenerator 
{
	//full lines of code
		public final String includeLibIOStream = "";
		public final String STDNamespace = "";
		public final String declareMainFunc = "";
		
		
		//default words
		public final String integerVar = "";
		public final String doubleVar = "";
		public final String booleanVar = "";
		public final String ifStatement = "";
		public final String whileLoop = "";
		public final String forLoop = "";
		public final String voidDeclarator = "";
		
		
		//characters
		public final String openCurlyBracket = "";
		public final String closeCurlyBracket = "";
		public final String openSquareBracket = "";
		public final String closeSquareBracket = "";
		public final String openRoundBracket = "";
		public final String closeRoundBracket = "";
		public final String lineSeparator = "";
		public final String semicolomn = "";
		
		
	public HashMap<String, String> getDefLines()
	{
		HashMap<String, String> map = null;
		return map;
	}
	
}
