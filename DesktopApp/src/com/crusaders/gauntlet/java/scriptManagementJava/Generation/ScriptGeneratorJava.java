package com.crusaders.gauntlet.java.scriptManagementJava.Generation;

import java.io.File;
import com.crusaders.gauntlet.java.codeGeneration.ScriptGenerator;
import com.crusaders.gauntlet.java.fileManagement.CreatorDeletor;
import com.crusaders.gauntlet.java.fileManagement.FileCreatorDeletor;

public class ScriptGeneratorJava implements ScriptGenerator{
	
	private static int indexOfScript = 0;
	
	
	public static final String directoryPath = "auto/scripts/Java/";
	public static final String defaultName = "ActionOfMacro";
	public static final String extentionOfFile = ".txt";
	
	
	private FileCreatorDeletor creator;
	private File actionScript;
	private File directory;
	
	
	private int currentIndex;
	
	public ScriptGeneratorJava() {
		initDependecies();
	}
	
	private void initDependecies() {
		directory = new File(directoryPath);
		if(!directory.isDirectory())
		{
			directory.mkdirs();
		}
		creator = new CreatorDeletor();
	}
	
	public int getIndex()
	{
		return currentIndex;
	}
	
	@Override
	public int getNextIndex() {
		return indexOfScript+1;
	}

	@Override
	public String getPath() {
		return directoryPath;
	}

	@Override
	public File generateNewScript() {
		actionScript = new File(directoryPath + defaultName+ indexOfScript + extentionOfFile);
		creator.createFile(actionScript, directoryPath);
		currentIndex = indexOfScript;
		ScriptGeneratorJava.indexOfScript++;
		return actionScript;
	}
	
	
}
