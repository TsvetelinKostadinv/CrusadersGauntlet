package com.crusaders.gauntlet.java.fileManagement.generation;

import java.io.File;
import java.io.IOException;

public interface IFileCreator {
    
    void createDirectory(File dir);
    void createFile(File file) throws IOException;
    
    
    void createDirectory(String directoryPath);
    void createFile(String path) throws IOException;
    
}
