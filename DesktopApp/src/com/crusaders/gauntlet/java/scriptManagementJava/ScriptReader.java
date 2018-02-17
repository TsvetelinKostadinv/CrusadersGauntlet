package com.crusaders.gauntlet.java.scriptManagementJava;

import java.awt.event.KeyEvent;
import java.io.File;

import com.crusaders.gauntlet.java.fileManagement.FileReader;
import com.crusaders.gauntlet.java.fileManagement.Reader;
import com.crusaders.gauntlet.java.scriptManagementJava.codeGeneration.CodeGeneratorJava;

public class ScriptReader {
	Reader reader;
	
	public ScriptReader()
	{
		initDependecies();
	}
	
	private void initDependecies() {
		reader = new FileReader();
		
	}

	private String[] readInKeys(File script)
	{
		String scriptString = reader.readFile(script);
		String[] keys = scriptString.split(CodeGeneratorJava.separator);
		return keys;
	}
	
	private Integer[] mapToCodes(String[] keys)
	{
		Integer[] keycodes = new Integer[keys.length];
		for(int i = 0; i < keycodes.length; i++) {
			keycodes[i] = Integer.parseInt(keys[i]);
		}
		
		return keycodes;
	}
	
	public Integer[] getKeycodesFromScript(File script)
	{
		String[] unmappedKeys = readInKeys(script);
		Integer[] keycodes = mapToCodes(unmappedKeys);
		return keycodes;
	}
	
}
