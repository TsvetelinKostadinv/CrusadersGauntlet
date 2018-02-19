package com.crusaders.gauntlet.java.models.macroFunctionality;

public class Macro {
	
	private ActionOfMacro action;
	
	
	public Macro()
	{
		initDependencies();
	}
	
	private void initDependencies() 
	{
		action = new ActionOfMacro();
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
		action.insertLeftClick();
	}

	public void insertRightClick()
	{
		action.insertRightClick();
	}
	
	public void insertMiddleClick()
	{
		action.insertMiddleClick();
	}
}
