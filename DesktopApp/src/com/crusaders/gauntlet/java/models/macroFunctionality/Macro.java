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
	
	
	
}
