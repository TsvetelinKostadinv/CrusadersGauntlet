package com.crusaders.gauntlet.java.codeGeneration;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.crusaders.gauntlet.java.codeGenerationCPP.CommandCPP;

public interface ScriptEditor {
	public boolean editScript(ArrayList<CommandCPP> contents);
	public void changeTargetScript(File script) throws FileNotFoundException;
}