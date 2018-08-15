package com.crusaders.gauntlet.java.fileManagement.deletion;

import java.io.File;

public class Deletor implements IFileDeletor
{
    @Override
    public void delete(File file) 
    {
        if(file.exists())  file.delete();
        
    }

    @Override
    public void delete(String path) 
    {
        File file = new File(path);
        delete(file);
    }
}
