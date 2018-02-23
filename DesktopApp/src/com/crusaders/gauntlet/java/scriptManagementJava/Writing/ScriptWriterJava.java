package com.crusaders.gauntlet.java.scriptManagementJava.Writing;

import java.io.File;

import com.crusaders.gauntlet.java.fileManagement.FileWriter;
import com.crusaders.gauntlet.java.fileManagement.Writer;
import com.crusaders.gauntlet.java.scriptManagementJava.Generation.ScriptGeneratorJava;
import com.crusaders.gauntlet.java.scriptManagementJava.codeGeneration.CodeGeneratorJava;

public class ScriptWriterJava {
	
	private FileWriter writer;
	private File script;
	
	CodeGeneratorJava codeGen;
    ScriptGeneratorJava scriptGen;
	
	public ScriptWriterJava(File script)
	{
		initDependencies();
		this.script = script;
	}

	private void initDependencies() 
	{
		writer = new Writer();
		codeGen = new CodeGeneratorJava();
		scriptGen = new ScriptGeneratorJava();
	}
	
	public void writeToScript(String whatToWrite)
	{
		writer.assignFile(script);
        
        codeGen.insertKeys(whatToWrite);
        String code = codeGen.getCode();
        writer.writeToFile(code);
	}
	
	public void writeKeyCodesToScript(String whatToWrite)
	{
		writer.assignFile(script);
		writer.writeToFile(whatToWrite);
	}
	
	public void insertLeftClick()
	{
		codeGen.insertLeftClick();
	}

	public void insertRightClick()
	{
		codeGen.insertRightClick();
	}
	
	public void insertMiddleClick()
	{
		codeGen.insertMiddleClick();
	}
	
	public File getScript()
	{
		return script;
	}
	
}
