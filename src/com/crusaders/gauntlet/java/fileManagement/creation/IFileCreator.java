package com.crusaders.gauntlet.java.fileManagement.creation;

import java.io.File;
import java.io.IOException;

public interface IFileCreator {
    
    /**
     * 
     * Creates the directory contained in the File variable
     * 
     * @param dir to be created
     * @return the created directory
     */
    public File createDirectory(File dir);
    /**
     * 
     * Creates the file contained in the File variable
     * 
     * @param file to be created
     * @throws IOException
     * @return the created file
     */
    public File createFile(File file) throws IOException;
    
    /**
     * 
     * Creates the directory annotated by the path in the String
     * 
     * @param path to the directory to be created
     * @return the created directory
     */
    public File createDirectory(String directoryPath);
    /**
     * 
     * Creates the file annotated by the path in the String
     * 
     * @param path to the file to be created
     * @throws IOException
     * @return the created file
     */
    public File createFile(String path) throws IOException;
    
}
