package com.crusaders.gauntlet.java.models.codeGeneration;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ScriptEditorCPP implements ScriptEditor {
	
	//This object is one time use because of the nature of the reader!!!!
	
	File script;
	BufferedReader reader;
	
	public ScriptEditorCPP(File script) throws FileNotFoundException
	{	
		this.script = script;
		reader = new BufferedReader(new FileReader(script));
	}

	
	
	@Override
	public boolean editScript(ArrayList<CommandCPP> contents) 
	{
		
		String[] lines = extractLines(contents);
		
		File tempScript = new File("src/com/crusaders/gauntlet/scripts/autoGeneratedScripts/temporary.cpp");
		try
		{
			tempScript.createNewFile();
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(tempScript));
			
			reader.mark(Integer.MAX_VALUE-1);
			int counter=0;
			
			while(reader.readLine()!=null)
			{
				reader.reset();
				String oldLine = reader.readLine();
				if(!oldLine.equals(lines[counter]))
				{
					writer.write(lines[counter]);
				}else{
					
				}
				counter++;
			}
			writer.close();
			script.delete();
			tempScript.renameTo(script);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}

		return false;
	}



	private String[] extractLines(ArrayList<CommandCPP> contents) {
		String[] toBeInserted = new String[contents.size()];
		for(int i=0;i<contents.size();i++)
		{
			toBeInserted[i] = contents.get(i).extractCommands();
		}
		return toBeInserted;
	}



	@Override
	public void changeTargetScript(File script) throws FileNotFoundException
	{
		this.script = script;
		reader = new BufferedReader(new FileReader(script));
	}

}
