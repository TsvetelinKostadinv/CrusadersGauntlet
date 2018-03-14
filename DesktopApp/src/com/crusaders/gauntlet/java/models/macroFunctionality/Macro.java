package com.crusaders.gauntlet.java.models.macroFunctionality;

import java.awt.event.KeyEvent;

import com.crusaders.gauntlet.java.scriptManagementJava.codeGeneration.CodeGeneratorJava;

public class Macro {
	
	private ActionOfMacro action;
	
	
	public Macro(Integer id)
	{
		initDependencies(id);
	}
	
	private void initDependencies(Integer id) 
	{
		action = new ActionOfMacro(id);
	}

	public void execute() {
		action.executeScript();
	}
	
	protected void editFunction(String newFunction)
	{
		action.editScript(newFunction);
	}
	
	protected void writeToScript(String whatToWrite)
	{
		action.writeToScript(whatToWrite);
	}
	
	public void insertLeftClick()
	{
		action.writeKeyCodes(((Integer) KeyEvent.BUTTON1_DOWN_MASK).toString()+CodeGeneratorJava.separator);
	}
	
	public void insertRightClick()
	{
		action.writeKeyCodes(((Integer) KeyEvent.BUTTON3_DOWN_MASK).toString()+CodeGeneratorJava.separator);
	}
	
	public void insertMiddleClick()
	{
		action.writeKeyCodes(((Integer) KeyEvent.BUTTON2_DOWN_MASK).toString()+CodeGeneratorJava.separator);
	}
}
