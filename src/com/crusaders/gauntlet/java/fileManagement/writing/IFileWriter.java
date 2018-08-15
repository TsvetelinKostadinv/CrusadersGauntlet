package com.crusaders.gauntlet.java.fileManagement.writing;

import java.io.File;
import java.io.IOException;

public interface IFileWriter 
{
    /**
     * 
     * Writes to the file in the File variable
     * 
     * @param file to be written to
     * @param string to be written
     * @throws IOException
     */
    void writeToFile(File file, String str) throws IOException;
    /**
     * 
     * Writes to the file annotated by the path
     * 
     * @param path to the file
     * @param string to be written
     * @throws IOException
     */
    void writeToFile(String path, String str) throws IOException;
}
