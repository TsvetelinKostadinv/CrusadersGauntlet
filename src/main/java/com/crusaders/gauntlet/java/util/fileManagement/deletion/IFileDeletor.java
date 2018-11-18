package com.crusaders.gauntlet.java.util.fileManagement.deletion;

import java.io.File;

public interface IFileDeletor
{
    /**
     * 
     * Deletes the file contained in the object
     * 
     * @param file to be deleted
     */
    void delete (File file);
    
    /**
     * 
     * Deletes the file annotated by the path
     * 
     * @param path to the file to be deleted
     */
    void delete (String path);
}
