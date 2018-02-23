package com.crusaders.gauntlet.java.scriptManagementJava.Reading;

import java.io.File;

import com.crusaders.gauntlet.java.fileManagement.FileReader;
import com.crusaders.gauntlet.java.fileManagement.Reader;

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
		System.out.println(scriptString);
		String[] keys = scriptString.split("\\|");// i do not know a whole lot about regular expressions so i am going to leave this as it is
		for (int i = 0; i < keys.length; i++) {
			System.out.println(keys[i]);
		}
		
		return keys;
	}
	
	private Integer[] mapToCodes(String[] keys)
	{
		System.out.println(keys.length);
		Integer[] keycodes = new Integer[keys.length];
		
		for(int i = 0; i < keys.length; i++)
		{
			System.out.println("Integer: "+ Integer.valueOf(keys[i]));
			keycodes[i] = Integer.parseInt(keys[i]);
		}
		
		return keycodes;
	}
	
//	private String removeLineSep(String str)
//	{
//		StringBuilder newString = new StringBuilder();
//		for (int i = 0; i < str.length()-1; i++) 
//		{
//			newString.append(str.charAt(i));
//		}
//		return newString.toString();
//	}
	
	public Integer[] getKeycodesFromScript(File script)
	{
		String[] unmappedKeys = readInKeys(script);
		Integer[] keycodes = mapToCodes(unmappedKeys);
		return keycodes;
	}
	
}
