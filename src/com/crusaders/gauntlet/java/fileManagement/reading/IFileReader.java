package com.crusaders.gauntlet.java.fileManagement.reading;

import java.io.File;
import java.io.IOException;

public interface IFileReader 
{
    /**
     * 
     * Reads the whole file.
     * 
     * @param file
     * @return the whole file as a String
     * @throws IOException
     */
	public String readFile(File file) throws IOException;
	/**
	 * 
	 * Reads the whole file.
	 * 
	 * @param path to the file to be read
	 * @return the whole file as a String
	 * @throws IOException
	 */
	public String readFile(String path) throws IOException;
	
	/**
	 * 
	 * Reads the specified line of the file contained in the File variable
	 * 
	 * @param file to be read
	 * @param line to be read
	 * @return the specified line as a String
	 * @throws IOException
	 */
	public String readLineFromFile(File file, int line) throws IOException;
	/**
	 * 
	 * Reads the specified line of the file annotated by the path
	 * 
	 * @param path to the file to be read
	 * @param line to be read
	 * @return the specified line as a String
	 * @throws IOException
	 */
	public String readLineFromFile(String path, int line) throws IOException;
}
