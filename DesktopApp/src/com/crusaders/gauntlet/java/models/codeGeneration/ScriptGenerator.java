package com.crusaders.gauntlet.java.models.codeGeneration;

public interface ScriptGenerator {
	public int getNextIndex();
	public String getPath();
	public boolean generateNewScript();
	public boolean generateNewScript(String name);
	//public File getScriptByID(int id);
	//public String getScriptContents(int id);
	//public boolean isCompiled();
}