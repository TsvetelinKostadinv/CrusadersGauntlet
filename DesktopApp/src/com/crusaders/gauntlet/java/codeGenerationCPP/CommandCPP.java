package com.crusaders.gauntlet.java.codeGenerationCPP;

import com.crusaders.gauntlet.java.codeGeneration.CodeGenerator;

public class CommandCPP {
	
	private String content = "";
	
	public CommandCPP()
	{
		
	}

	public String extractCommands() 
	{
		return content;
	}
	
	public String setCommand(String command)
	{
		if(checkIfExists(command))
		{
			content = command;
			return "Successfully saved!";
		}else{
			return "Not supported!";
		}
		
	}

	private boolean checkIfExists(String command) {
		
		CodeGenerator gen = new CodeGeneratorCPP();
		return gen.exists(command);
	}
}
