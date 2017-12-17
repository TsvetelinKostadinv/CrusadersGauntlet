package com.crusaders.gauntlet.java.models.codeGeneration;

import java.util.HashMap;

public class CodeGeneratorCPP implements CodeGenerator {

	private HashMap<String, String> lines = new HashMap<String, String>();
	public final String extention = ".cpp";

	// full lines of code
	public final String includeLibIOStream = "includeLibIOStream";
	public final String STDNamespace = "STDNamespace";
	public final String declareMainFunc = "declareMainFunc";

	// default words
	public final String integerVar = "int";
	public final String doubleVar = "double";
	public final String booleanVar = "boolean";
	public final String ifStatement = "if";
	public final String whileLoop = "while";
	public final String forLoop = "for";
	public final String voidDeclarator = "void";

	// characters
	public final String openCurlyBracket = "openCurlyBracket";
	public final String closeCurlyBracket = "closeCurlyBracket";
	public final String openSquareBracket = "openSquareBracket";
	public final String closeSquareBracket = "closeSquareBracket";
	public final String openRoundBracket = "openRoundBracket";
	public final String closeRoundBracket = "closeRoundBracket";
	public final String lineSeparator = "lineSeparator";
	public final String semicolomn = "semicolomn";
	public final String space = "space";

	public CodeGeneratorCPP() 
	{
		fillLines();
	}

	public void fillLines()
	{
		// full lines of code
		lines.put(includeLibIOStream, "#include<iostream>");
		lines.put(STDNamespace, "using namespace std;");
		lines.put(declareMainFunc, "main()");

		// default words
		lines.put(integerVar, "int");
		lines.put(doubleVar, "double");
		lines.put(booleanVar, "bool");
		lines.put(ifStatement, "if");
		lines.put(whileLoop, "while");
		lines.put(forLoop, "for");
		lines.put(voidDeclarator, "void");

		// characters
		lines.put(openCurlyBracket, "{");
		lines.put(closeCurlyBracket, "}");
		lines.put(openSquareBracket, "[");
		lines.put(closeSquareBracket, "]");
		lines.put(openRoundBracket, "(");
		lines.put(closeRoundBracket, ")");
		lines.put(lineSeparator, System.lineSeparator());
		lines.put(space, " ");
		lines.put(semicolomn, ";");

	}

	@Override
	public HashMap<String, String> getDefLines() 
	{
		return lines;
	}

	public String generateDefaultCode() 
	{
		StringBuilder defCode = new StringBuilder();

		CodeGeneratorCPP gen = new CodeGeneratorCPP();

		HashMap<String, String> defLines = gen.getDefLines();

		defCode.append(defLines.get(gen.includeLibIOStream));
		defCode.append(defLines.get(gen.lineSeparator));
		defCode.append(defLines.get(gen.STDNamespace));
		defCode.append(defLines.get(gen.lineSeparator));

		defCode.append(defLines.get(gen.voidDeclarator));
		defCode.append(defLines.get(gen.space));
		defCode.append(defLines.get(gen.declareMainFunc));
		defCode.append(defLines.get(gen.openCurlyBracket));
		defCode.append(defLines.get(gen.closeCurlyBracket));
		return defCode.toString();
	}

}
