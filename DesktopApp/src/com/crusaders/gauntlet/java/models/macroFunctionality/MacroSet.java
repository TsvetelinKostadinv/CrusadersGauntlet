package com.crusaders.gauntlet.java.models.macroFunctionality;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.crusaders.gauntlet.java.scriptManagementJava.Execution.ScriptExecutorJava;
import com.crusaders.gauntlet.java.scriptManagementJava.Finding.ScriptFinderJava;

public class MacroSet {
	
	public static final int numberOfMacrosInTheSet = 4;
	
	private ArrayList<Macro> macros;
	private ScriptExecutorJava executor;
	
	public MacroSet(String functionOfRingFinger, String functionOfPinkie)
	{
		initDependencies(functionOfRingFinger, functionOfPinkie);
	}

	private void initDependencies(String functionOfRingFinger, String functionOfPinkie) {
		macros = new ArrayList<Macro>(numberOfMacrosInTheSet);
		
		executor = new ScriptExecutorJava();
		
		Macro indexFingerMacro = new Macro();
		indexFingerMacro.insertLeftClick();
		macros.add(0, indexFingerMacro);
		
		Macro middleFingerMacro = new Macro();
		middleFingerMacro.insertRightClick();
		macros.add(1, middleFingerMacro);
		
		Macro ringFingerMacro = new Macro();
		ringFingerMacro.writeToScript(functionOfRingFinger);
		macros.add(ringFingerMacro);
		
		Macro pinkieFingerMacro = new Macro();
		pinkieFingerMacro.writeToScript(functionOfPinkie);
		macros.add(pinkieFingerMacro);
	}
	
	private boolean areThereAllTheScripts()
	{
		ScriptFinderJava finder = new ScriptFinderJava();
		for(int i=0;i<numberOfMacrosInTheSet;i++)
		{
			try {
				finder.findScript(i);
			} catch (FileNotFoundException e) {
				return false;
			}
		}
		return true;
	}
	
	public void execute(int id)
	{
		try {
			executor.executeScriptID(id, 0);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void appendLeftClick(int id)
	{
		macros.get(id).insertLeftClick();
	}
	
	public void appendRightClick(int id)
	{
		macros.get(id).insertRightClick();
	}
	
	public void appendMiddleClick(int id)
	{
		macros.get(id).insertMiddleClick();
	}
	
}
