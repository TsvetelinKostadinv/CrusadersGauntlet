package com.crusaders.gauntlet.java.models.macroFunctionality;

import java.util.ArrayList;

public class MacroSet {
	
	public static final int numberOfMacrosInTheSet = 4;
	
	private ArrayList<Macro> macros;
	
	public MacroSet(String functionOfRingFinger, String functionOfPinkie)
	{
		initDependencies(functionOfRingFinger, functionOfPinkie);
	}

	private void initDependencies(String functionOfRingFinger, String functionOfPinkie) {
		macros = new ArrayList<Macro>(numberOfMacrosInTheSet);
		
		Macro indexFingerMacro = new Macro();
		indexFingerMacro.insertLeftClick();
		macros.add(indexFingerMacro);
		
		Macro middleFingerMacro = new Macro();
		indexFingerMacro.insertRightClick();
		macros.add(middleFingerMacro);
		
		Macro ringFingerMacro = new Macro();
		indexFingerMacro.writeToScript(functionOfRingFinger);
		macros.add(ringFingerMacro);
		
		Macro pinkieFingerMacro = new Macro();
		indexFingerMacro.writeToScript(functionOfPinkie);
		macros.add(pinkieFingerMacro);
		
		indexFingerMacro = null;
		middleFingerMacro = null;
		ringFingerMacro = null;
		pinkieFingerMacro = null;
	}
	
	public void execute(int id)
	{
		macros.get(id).execute();
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
