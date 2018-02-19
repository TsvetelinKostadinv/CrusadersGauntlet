package com.crusaders.gauntlet.java.scriptManagementJava.Execution;

import java.io.File;
import java.io.FileNotFoundException;

import com.crusaders.gauntlet.java.keyPress.KeyPresser;
import com.crusaders.gauntlet.java.keyPress.RobotKeyPresser;
import com.crusaders.gauntlet.java.scriptManagementJava.Finding.ScriptFinderJava;
import com.crusaders.gauntlet.java.scriptManagementJava.Reading.ScriptReader;

public class ScriptExecutorJava {
	
	ScriptFinderJava finder;
	
	ScriptReader reader;
	
	KeyPresser presser;
	
	public ScriptExecutorJava()
	{
		initDependecies();
	}
	
	private void initDependecies() 
	{
		finder = new ScriptFinderJava();
		reader = new ScriptReader();
		presser = new RobotKeyPresser();
	}

	/**
	 * @param id
	 * @throws FileNotFoundException 
	 */
	public void executeScriptID(int id, int delayBeforExecutionInMilis) throws FileNotFoundException 
	{
        Integer[] keys = reader.getKeycodesFromScript(finder.findScript(id));
        
        try { Thread.sleep(delayBeforExecutionInMilis); } 
        catch (InterruptedException e) { e.printStackTrace(); }
        
        for(Integer i = 0;i<keys.length-1;i++)
        {
            presser.pressKey(keys[i]);
        }
        
        presser.releaseShift();
	}
	
}
