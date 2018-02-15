package com.crusaders.gauntlet.java.codeGenerationJava;

import java.io.File;

public class PilotClass {
	public static void main(String[] args)
	{
		CodeGeneratorJava codeGen = new CodeGeneratorJava();
		ScriptGeneratorJava scriptGen = new ScriptGeneratorJava();
		//ScriptFinderJava finder = new ScriptFinderJava();
		
		File script = scriptGen.generateNewScript();
		
		ScriptWriterJava writer;
		writer = new ScriptWriterJava(script);
		codeGen.insertKeys("Deiv");
		String toInsert = codeGen.getCode();
		writer.writeToScript(toInsert);
		
		System.out.println(Character.isLowerCase('@'));
		
	}
}
