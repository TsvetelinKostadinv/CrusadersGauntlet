package com.crusaders.gauntlet.java.fileManagement.creation;

import java.io.File;
import java.io.IOException;

public interface IFileCreator {
    
    /**
     * 
     * Creates the directory contained in the File variable
     * 
     * @param dir to be created
     */
    void createDirectory(File dir);
    /**
     * 
     * Creates the file contained in the File variable
     * 
     * @param file to be created
     * @throws IOException
     */
    void createFile(File file) throws IOException;
    
    /**
     * 
     * Creates the directory annotated by the path in the String
     * 
     * @param path to the directory to be created
     */
    void createDirectory(String directoryPath);
    /**
     * 
     * Creates the file annotated by the path in the String
     * 
     * @param path to the file to be created
     * @throws IOException
     */
    void createFile(String path) throws IOException;
    
}
