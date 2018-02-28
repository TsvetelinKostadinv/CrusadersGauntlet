package com.crusaders.gauntlet.java.codeGeneration;

import java.io.File;

public interface ScriptGenerator {
	public int getNextIndex();
	public String getPath();
	public File generateNewScript();
	//public File getScriptByID(int id);
	//public String getScriptContents(int id);
	//public boolean isCompiled();
}
