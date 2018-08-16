package com.crewgame.fileManagement.writing;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Writer implements IFileWriter {

    @Override
    public void writeToFile(File file, String str, boolean append) throws IOException 
    {
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file, append)));
        out.print(str);
        out.close();
        out = null;
    }

    @Override
    public void writeToFile ( String path , String str, boolean append) throws IOException 
    {
        writeToFile( new File(path) , str, append );
        
    }
}
