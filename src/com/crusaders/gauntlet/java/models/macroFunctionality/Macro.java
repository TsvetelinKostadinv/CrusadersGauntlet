package com.crusaders.gauntlet.java.models.macroFunctionality;

import java.io.FileNotFoundException;

import com.crusaders.gauntlet.java.models.exeptions.UnableToExecuteExeption;

public class Macro {
	
	private ActionOfMacro action = new ActionOfMacro();
	
	private boolean hasBeenInited = false;
	
	
	public Macro()
	{
		System.out.println("Crated the macro object");
	}
	
	public void initMacro()
	{
		hasBeenInited = true;
		action.initMacroScript();
	}
	
	public boolean hasBeenInited()
	{
		return hasBeenInited;
	}
	
	public boolean executeScript()
	{
		//here we execute the script from the object
		
		if(hasBeenInited)
		{
			execute();
		}else{
			System.out.println("Has to be inited first");
		}
		return false; // it will return true if executed correctly and false otherwise
	}

	private void execute() {
		try {
			action.execute();
		} catch (FileNotFoundException | UnableToExecuteExeption e) {
			e.printStackTrace();
			if(e instanceof FileNotFoundException)
			{
				System.out.println("The script was not found");
			}else if(e instanceof UnableToExecuteExeption)
			{
				System.out.println("Unable to execute the script");
			}
		}
		
	}
	
	
	
}
