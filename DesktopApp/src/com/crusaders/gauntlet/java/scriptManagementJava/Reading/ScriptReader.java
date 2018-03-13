package com.crusaders.gauntlet.java.scriptManagementJava.Reading;

import java.io.File;

import com.crusaders.gauntlet.java.fileManagement.Reader;
import com.crusaders.gauntlet.java.fileManagement.FileReader;

public class ScriptReader {
	FileReader reader;
	
	public ScriptReader()
	{
		initDependecies();
	}
	
	private void initDependecies() {
		reader = new Reader();
		
	}

	private String[] readInKeys(File script)
	{
		String scriptString = reader.readFile(script);
		System.out.println("Whole file: "+scriptString);
		String[] keys = scriptString.split("\\|");// i do not know a whole lot about regular expressions so i am going to leave this as it is
//		for (int i = 0; i < keys.length; i++) {
//			System.out.println(keys[i]); // prints the separated keys
//		}
		
		return keys;
	}
	
	private Integer[] mapToCodes(String[] keys)
	{
		System.out.println("Length: "+keys.length); // prints the length of the array
		Integer[] keycodes = new Integer[keys.length];
		
		for(int i = 0; i < keys.length; i++)
		{
			try {
			System.out.println("Integer: "+ Integer.valueOf(keys[i]));
			keycodes[i] = Integer.parseInt(keys[i]);
			}catch(NumberFormatException e)
			{
				keycodes = new Integer[0];
				break;
			}
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
