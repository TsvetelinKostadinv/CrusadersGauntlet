package com.crusaders.gauntlet.java.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.crusaders.gauntlet.java.models.exeptions.UnableToExecuteExeption;

public class ActionOfMacro {
	
	private static int indexOfScript = 0;
	
	private File actionScript;
	private boolean hasBeenInited = false;
	
	public ActionOfMacro()
	{
		//navigate to the not yet created file!!!
		actionScript = new File( "src/com/crusaders/gauntlet/java/autoGeneratedScripts/actionOfMacro"+indexOfScript+".java" );
		
		//Change the index for the next script
		indexOfScript++;
		
		System.out.println("Created the action object");
	}
	
	public void initMacroScript()
	{
		
		if(!actionScript.exists())
		{
			try {
				if(actionScript.createNewFile())
				{
					hasBeenInited = true;
					System.out.println("Succesfully crated the script file");
				}else{
					actionScript.delete();
					initMacroScript();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
				e.getMessage();
			}
		}
	}
	
	public boolean hasBeenInited()
	{
		return hasBeenInited;
	}

	public boolean execute() throws UnableToExecuteExeption, FileNotFoundException {
		System.out.println("Executing the script...");
		
		return true;
	}
}
