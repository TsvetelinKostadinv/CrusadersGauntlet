package com.crusaders.gauntlet.java.fileManagement;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Writer implements FileWriter {

    File targetFile;

    private static Writer instance = new Writer();

    public static Writer getInstance() {
        return instance;
    }

    private Writer() {}

    @Override
    public void assignFile(File file) {
        targetFile = file;
    }

    @Override
    public void writeToFile(String str) {
        try {
            PrintWriter writer = new PrintWriter(targetFile);
            writer.write(str);
            writer.close();
        }catch (FileNotFoundException e )
        {
            e.printStackTrace();
        }
    }
}
