package com.crusaders.gauntlet.java.models.codeGeneration;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public interface ScriptEditor {
	public boolean editScript(ArrayList<CommandCPP> contents);
	public void changeTargetScript(File script) throws FileNotFoundException;
}
