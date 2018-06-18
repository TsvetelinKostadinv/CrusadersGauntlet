package com.crusaders.gauntlet.java.fileManagement.reading;

import java.io.File;
import java.io.IOException;

public interface IFileReader 
{
	public String readFile(File file) throws IOException;
	public String readFile(String path) throws IOException;
	
	public String readLineFromFile(File file, int line) throws IOException;
	public String readLineFromFile(String path, int line) throws IOException;
}
