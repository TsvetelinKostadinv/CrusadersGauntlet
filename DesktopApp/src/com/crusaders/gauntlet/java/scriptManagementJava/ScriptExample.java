package com.crusaders.gauntlet.java.scriptManagementJava;

import java.io.File;
import java.io.FileNotFoundException;

import com.crusaders.gauntlet.java.keyPress.KeyPresser;
import com.crusaders.gauntlet.java.keyPress.RobotKeyPresser;
import com.crusaders.gauntlet.java.scriptManagementJava.Execution.ScriptExecutorJava;
import com.crusaders.gauntlet.java.scriptManagementJava.Finding.ScriptFinderJava;
import com.crusaders.gauntlet.java.scriptManagementJava.Generation.ScriptGeneratorJava;
import com.crusaders.gauntlet.java.scriptManagementJava.Writing.ScriptWriterJava;
import com.crusaders.gauntlet.java.scriptManagementJava.codeGeneration.CodeGeneratorJava;
import com.crusaders.gauntlet.java.scriptManagementJava.Reading.ScriptReader;

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
        CodeGeneratorJava codeGen = new CodeGeneratorJava();
        ScriptGeneratorJava scriptGen = new ScriptGeneratorJava();
        
        File script = scriptGen.generateNewScript();
        
		ScriptWriterJava writer;
        writer = new ScriptWriterJava(script);
        codeGen.insertKeys(whatToInsert);
        String toInsert = codeGen.getCode();
        writer.writeToScript(toInsert);
	}
    
    //this method is static for the example and should not be static in implementation
    public static void  pressKeys(int indexOfScript, int delayBeforExecutionInMilis) throws FileNotFoundException, InterruptedException
    {
    	ScriptExecutorJava executor = new ScriptExecutorJava();
    	executor.executeScriptID(indexOfScript, delayBeforExecutionInMilis);
    }
    
}
