package com.crusaders.gauntlet.java.codeGenerationJava;

public class CodeGeneratorJava{
	
	private static CodeGeneratorJava instance = new CodeGeneratorJava();
	private String code;
	
	private CodeGeneratorJava() 
	{
		
	}
	
	public void rememberCode(String whatToRemember)
	{
		code = whatToRemember;
	}
	
	public static CodeGeneratorJava getInstance()
	{
		return instance;
	}
	
	public String getCode()
	{
		return code;
	}
}
