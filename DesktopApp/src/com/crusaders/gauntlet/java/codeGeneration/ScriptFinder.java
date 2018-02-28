package com.crusaders.gauntlet.java.codeGeneration;

import java.io.File;
import java.io.FileNotFoundException;

public interface ScriptFinder {
	public File findScript(Integer index) throws FileNotFoundException;
}
