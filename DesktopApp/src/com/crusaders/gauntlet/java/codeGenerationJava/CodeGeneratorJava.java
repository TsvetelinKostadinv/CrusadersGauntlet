package com.crusaders.gauntlet.java.codeGenerationJava;

public class CodeGeneratorJava{
	
	private static CodeGeneratorJava instance = new CodeGeneratorJava();
	private StringBuilder code;
	
	private CodeGeneratorJava() 
	{
		initDependecies();
	}
	
	private void initDependecies() {
		code = new StringBuilder();
		
	}

	public void rememberCode(String whatToRemember)
	{
		code.append(whatToRemember);
	}
	
	public static CodeGeneratorJava getInstance()
	{
		return instance;
	}
	
	public String getCode()
	{
		return code.toString();
	}
	
	public void insertCode(String code)
	{
		this.code.append(code);
	}
}
