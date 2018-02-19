package com.crusaders.gauntlet.java.scriptManagementJava.Writing;

import java.io.File;

import com.crusaders.gauntlet.java.fileManagement.FileWriter;
import com.crusaders.gauntlet.java.fileManagement.Writer;
import com.crusaders.gauntlet.java.scriptManagementJava.Generation.ScriptGeneratorJava;
import com.crusaders.gauntlet.java.scriptManagementJava.codeGeneration.CodeGeneratorJava;

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
		
		
		CodeGeneratorJava codeGen = new CodeGeneratorJava();
        ScriptGeneratorJava scriptGen = new ScriptGeneratorJava();
        
        File script = scriptGen.generateNewScript();
        
        writer.assignFile(script);
        
        codeGen.insertKeys(whatToWrite);
        String code = codeGen.getCode();
        writer.writeToFile(code);
		
	}
	
	public File getScript()
	{
		return script;
	}
	
}
