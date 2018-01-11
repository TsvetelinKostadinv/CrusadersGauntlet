package com.crusaders.gauntlet.java.codeGeneration;

public interface ScriptGenerator {
	public int getNextIndex();
	public String getPath();
	public boolean generateNewScript();
	//public File getScriptByID(int id);
	//public String getScriptContents(int id);
	//public boolean isCompiled();
}
