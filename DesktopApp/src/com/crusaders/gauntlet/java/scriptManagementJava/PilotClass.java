package com.crusaders.gauntlet.java.scriptManagementJava;

import java.io.File;

import com.crusaders.gauntlet.java.scriptManagementJava.codeGeneration.CodeGeneratorJava;
import com.crusaders.gauntlet.java.scriptManagementJava.scriptGeneration.ScriptGeneratorJava;
import com.crusaders.gauntlet.java.scriptManagementJava.scriptWriting.ScriptWriterJava;

public class PilotClass {
	public static void main(String[] args)
	{
		CodeGeneratorJava codeGen = new CodeGeneratorJava();
		ScriptGeneratorJava scriptGen = new ScriptGeneratorJava();
		//ScriptFinderJava finder = new ScriptFinderJava();
		
		File script = scriptGen.generateNewScript();
		
		ScriptWriterJava writer;
		writer = new ScriptWriterJava(script);
		codeGen.insertKeys("Aa{}");
		String toInsert = codeGen.getCode();
		writer.writeToScript(toInsert);
		
	}
}
