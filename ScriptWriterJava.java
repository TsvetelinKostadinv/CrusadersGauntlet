package com.crusaders.gauntlet.java.scriptManagementJava.Writing;

import java.io.File;
import java.io.FileNotFoundException;

import com.crusaders.gauntlet.java.fileManagement.FileWriter;
import com.crusaders.gauntlet.java.fileManagement.Writer;
import com.crusaders.gauntlet.java.scriptManagementJava.Finding.ScriptFinderJava;
import com.crusaders.gauntlet.java.scriptManagementJava.codeGeneration.CodeGeneratorJava;

public class ScriptWriterJava {
	
	private FileWriter writer;
	private File script;
	
	CodeGeneratorJava codeGen;
	
	public ScriptWriterJava()
	{
		initDependencies();
	}

	private void initDependencies() 
	{
		writer = new Writer();
		codeGen = new CodeGeneratorJava();
	}
	
	public void writeToScript(int id, String whatToWrite)
	{ 
        try {
			writer.assignFile(new ScriptFinderJava().findScript(id));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        
        codeGen.insertKeys(whatToWrite);
        String code = codeGen.getCode();
        writer.writeToFile(code);
		
	}
	
	public void insertLeftClick()
	{
		codeGen.insertLeftClick();;
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
