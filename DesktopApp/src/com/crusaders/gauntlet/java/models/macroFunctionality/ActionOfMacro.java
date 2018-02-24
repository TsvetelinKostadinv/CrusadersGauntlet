package com.crusaders.gauntlet.java.models.macroFunctionality;

import java.io.File;
import java.io.FileNotFoundException;

import com.crusaders.gauntlet.java.scriptManagementJava.Execution.ScriptExecutorJava;
import com.crusaders.gauntlet.java.scriptManagementJava.Finding.ScriptFinderJava;
import com.crusaders.gauntlet.java.scriptManagementJava.Generation.ScriptGeneratorJava;
import com.crusaders.gauntlet.java.scriptManagementJava.Writing.ScriptWriterJava;

public class ActionOfMacro {
	
	private ScriptFinderJava finder;
	private ScriptGeneratorJava scriptGen;
	private ScriptWriterJava writer;
	private ScriptExecutorJava executor;
	
	private File assignedScript;
	
	private final int delayBeforeExetution = 0;//this delay is in miliseconds
	
	private int indexOfScript;
	
	
	
	public ActionOfMacro(Integer id)
	{
		initDependencies(id);
	}

	private void initDependencies(Integer id)
    {
		finder = new ScriptFinderJava();
		
		try {
			assignedScript = finder.findScript(id);
			indexOfScript = id;
		} catch (FileNotFoundException e) {
			scriptGen = new ScriptGeneratorJava();
			
			indexOfScript = scriptGen.getIndex();
			
			assignedScript = scriptGen.generateNewScript();
		}
		
		
		
		writer = new ScriptWriterJava(assignedScript);
		executor = new ScriptExecutorJava();
		
    }
	
	/**
	 * <h3>getAssignedFile()</h3>
	 * <br>
	 * {@code public File getAssignedFile()}}
	 * <br>
	 * <p>
	 * 
	 * This method returns the script attached to this object in a File variable
	 * 
	 * @return The assigned script to the object
	 */
	public File getAssignedFile(){ return assignedScript; }
	
	public void writeToScript(String whatToWrite)
	{
		writer.writeToScript(whatToWrite);
	}
	
	public void writeKeyCodes(String keyCodes)
	{
		writer.writeKeyCodesToScript(keyCodes);
	}
	
	public void editScript(String whatToUpdate)
	{
		writeToScript(whatToUpdate);
	}
	
	public void executeScript()
	{
		try {
			executor.executeScriptID(indexOfScript, delayBeforeExetution);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//we should never get here because the script was created
		}
	}
	
}
