package com.crusaders.gauntlet.java.scriptManagementJava.Finding;

import java.io.File;
import java.io.FileNotFoundException;

import com.crusaders.gauntlet.java.scriptManagementJava.Generation.ScriptGeneratorJava;

public class ScriptFinderJava{
	
	public final String directoryPath = ScriptGeneratorJava.directoryPath;
	public final String defaultName = ScriptGeneratorJava.defaultName;
	public final String extentionOfFile = ScriptGeneratorJava.extentionOfFile;
	
	private final File directory = new File(directoryPath);
	
	public File findScript(Integer index) throws FileNotFoundException 
	{
		if (directory.isDirectory()) 
		{
			String[] namesOfFiles = directory.list();
			if (namesOfFiles.length != 0) 
			{
				
				for (int i = 0; i < namesOfFiles.length; i++) 
				{
					String currName = namesOfFiles[i];
					StringBuilder buildingDefaultName = new StringBuilder();
					for (int j = 0; j < defaultName.length(); j++) 
					{
						buildingDefaultName.append(currName.charAt(j));
					}
					if (!buildingDefaultName.toString().equals(defaultName)) 
					{
						continue;
					} else {
						if (currName.charAt(defaultName.length()) == index.toString().charAt(0)) 
						{
							return new File(directoryPath + defaultName + index.toString() + extentionOfFile);
						}
					}
					currName = null;
					buildingDefaultName = null;
				}
			}
			namesOfFiles = null;
		} else {
			directory.mkdirs();
		}
		throw new FileNotFoundException();
	}
}
