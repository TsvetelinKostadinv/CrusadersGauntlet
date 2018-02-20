package com.crusaders.gauntlet.java.scriptManagementJava;

import java.io.FileNotFoundException;

import com.crusaders.gauntlet.java.scriptManagementJava.Execution.ScriptExecutorJava;
import com.crusaders.gauntlet.java.scriptManagementJava.Generation.ScriptGeneratorJava;
import com.crusaders.gauntlet.java.scriptManagementJava.Writing.ScriptWriterJava;

public class ScriptExample {
    public static void main(String[] args)
    {
    	
        inserCodeToScript(0,"zdr");
        try {
        	pressKeys(0, 0);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        //zdr
        
        
    }

	/**
	 * @param whatToInsert
	 * @author Tsvetelin
	 */
	private static void inserCodeToScript(int id, String whatToInsert) 
	{
        ScriptGeneratorJava scriptGen = new ScriptGeneratorJava();
        
        scriptGen.generateNewScript();
        
		ScriptWriterJava writer = new ScriptWriterJava();
		
		writer.writeToScript(id, whatToInsert);
	}
    
    //this method is static for the example and should not be static in implementation
    public static void  pressKeys(int indexOfScript, int delayBeforExecutionInMilis) throws FileNotFoundException, InterruptedException
    {
    	ScriptExecutorJava executor = new ScriptExecutorJava();
    	executor.executeScriptID(indexOfScript, delayBeforExecutionInMilis);
    }
    
}
