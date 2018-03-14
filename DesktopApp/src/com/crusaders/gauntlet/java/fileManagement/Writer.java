package com.crusaders.gauntlet.java.fileManagement;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Writer implements FileWriter {

    File targetFile;

    public Writer() {}

    @Override
    public void assignFile(File file) {
        targetFile = file;
    }

    @Override
    public void writeToFile(String str) {
        try {
            BufferedWriter writer = new BufferedWriter(new PrintWriter(targetFile));
            writer.write(str);
            writer.close();
            writer = null;
        }catch (FileNotFoundException e )
        {
            e.printStackTrace();
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
