package com.crewgame.fileManagement.writing;

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
     * @param whether or not it should append at the end of the file
     * @throws IOException
     */
    void writeToFile(File file, String str, boolean append) throws IOException;
    /**
     * 
     * Writes to the file annotated by the path
     * 
     * @param path to the file
     * @param string to be written
     * @param whether or not it should append at the end of the file
     * @throws IOException
     */
    void writeToFile(String path, String str, boolean append) throws IOException;
}
