package com.crusaders.gauntlet.java.fileManagement.writing;

import java.io.File;
import java.io.IOException;

public interface IFileWriter 
{
    void writeToFile(File file, String str) throws IOException;
    void writeToFile(String path, String str) throws IOException;
}
