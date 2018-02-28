package com.crusaders.gauntlet.java.codeGenerationJava;

import java.io.FileNotFoundException;

public class PilotClass {
	public static void main(String[] args)
	{
		CodeGeneratorJava codeGen = new CodeGeneratorJava();
		ScriptGeneratorJava scriptGen = new ScriptGeneratorJava();
		ScriptFinderJava finder = new ScriptFinderJava();
		
		scriptGen.generateNewScript();
		
		ScriptWriterJava writer;
		try {
			writer = new ScriptWriterJava(finder.findScript(0));
			codeGen.insertKeys("Aa");
			String toInsert = codeGen.getCode();
			writer.writeToScript(toInsert);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		

		
	}
}
