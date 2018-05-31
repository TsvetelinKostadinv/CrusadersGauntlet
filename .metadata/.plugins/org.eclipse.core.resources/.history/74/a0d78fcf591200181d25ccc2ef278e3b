package com.crusaders.gauntlet.java.codeGenerationJava;

import java.io.File;

import com.crusaders.gauntlet.java.fileManagement.FileWriter;
import com.crusaders.gauntlet.java.fileManagement.Writer;

public class ScriptWriterJava {
	
	private FileWriter writer;
	private File script;
	
	public ScriptWriterJava(File script)
	{
		initDependencies();
		this.script = script;
	}

	private void initDependencies() 
	{
		writer = new Writer();
		
	}
	
	public void writeToScript(String whatToWrite)
	{
		writer.assignFile(script);
		writer.writeToFile(whatToWrite);
	}
	
	public File getScript()
	{
		return script;
	}
	
}
