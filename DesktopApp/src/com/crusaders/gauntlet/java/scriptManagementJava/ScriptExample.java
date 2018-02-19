package com.crusaders.gauntlet.java.scriptManagementJava;

import java.io.File;
import java.io.FileNotFoundException;

import com.crusaders.gauntlet.java.scriptManagementJava.Execution.ScriptExecutorJava;
import com.crusaders.gauntlet.java.scriptManagementJava.Generation.ScriptGeneratorJava;
import com.crusaders.gauntlet.java.scriptManagementJava.Writing.ScriptWriterJava;

public class ScriptExample {
    public static void main(String[] args)
    {
        inserCodeToScript("This is to be inserted");
        try {
        	pressKeys(0, 2000);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

	/**
	 * @param whatToInsert
	 * @author Tsvetelin
	 */
	private static void inserCodeToScript(String whatToInsert) 
	{
        ScriptGeneratorJava scriptGen = new ScriptGeneratorJava();
        
        File script = scriptGen.generateNewScript();
        
		ScriptWriterJava writer = new ScriptWriterJava(script);
		
		writer.writeToScript(whatToInsert);
	}
    
    //this method is static for the example and should not be static in implementation
    public static void  pressKeys(int indexOfScript, int delayBeforExecutionInMilis) throws FileNotFoundException, InterruptedException
    {
    	ScriptExecutorJava executor = new ScriptExecutorJava();
    	executor.executeScriptID(indexOfScript, delayBeforExecutionInMilis);
    }
    
}
