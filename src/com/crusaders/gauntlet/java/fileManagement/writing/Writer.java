package com.crusaders.gauntlet.java.fileManagement.writing;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Writer implements IFileWriter {

    @Override
    public void writeToFile(File file, String str) throws IOException 
    {
        BufferedWriter writer = new BufferedWriter(new PrintWriter(file));
        writer.write(str);
        writer.close();
        writer = null;

    }

    @Override
    public void writeToFile ( String path , String str ) throws IOException 
    {
        writeToFile( new File(path) , str );
        
    }
}
