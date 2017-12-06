package com.crusaders.gauntlet.java.models.macroFunctionality;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.crusaders.gauntlet.java.models.codeGeneration.CodeGenerator;
import com.crusaders.gauntlet.java.models.codeGeneration.CodeGeneratorCPP;
import com.crusaders.gauntlet.java.models.codeGeneration.Command;
import com.crusaders.gauntlet.java.models.exeptions.UnableToExecuteExeption;

public class ActionOfMacro {
	
	private final String directoryPath = "src/com/crusaders/gauntlet/scripts/autoGeneratedScripts/";
	private final String defaultName = "ActionOfMacro";
	private final String extentionOfFile = ".cpp";
	
	private static int indexOfScript = 0;
	
	private File actionScript;
	private CodeGeneratorCPP gen = new CodeGeneratorCPP();
	private boolean hasBeenInited = false;
	
	public ActionOfMacro()
	{
		//navigate to the not yet created file!!!
		
		actionScript = new File(directoryPath + defaultName + indexOfScript + extentionOfFile );
		
		//Change the index for the next script
		indexOfScript++;
		
		System.out.println("Created the action object");
	}
	
	public void initMacroScript()
	{
		//System.out.println("Starting init procedure");
		
		createScriptFile();
		
		System.out.println(gen.generateDefaultCode());
		
		hasBeenInited = true;
	}


	private void createScriptFile() {
		if(!hasBeenInited)
		{
			if(!checkForDirectory())
			{
				createDirectory();
			}
			createActionFile();
			
		}else{
			System.out.println("Already Inited!!");
		}
	}

	public boolean hasBeenInited()
	{
		return hasBeenInited;
	}

	public boolean execute() throws UnableToExecuteExeption, FileNotFoundException {
		if(hasBeenInited)
		{
			System.out.println("Executing the script...");
		}
		return true;
	}
	
	
	private void createDirectory() {
		System.out.println("Creating dir");
		File dir = new File(directoryPath);
		dir.mkdirs();
	}

	private boolean checkForDirectory() {
		File dir = new File(directoryPath);
		return dir.isDirectory();
	}

	private void createActionFile() {
		if(!actionScript.exists())
		{
			System.out.println();
			try {
				if(actionScript.createNewFile())
				{
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
	
	public void insertCommand(Command command)
	{
		command.extractCommands();
	}
	
}
