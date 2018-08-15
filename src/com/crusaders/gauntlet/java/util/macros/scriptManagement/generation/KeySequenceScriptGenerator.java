package com.crusaders.gauntlet.java.util.macros.scriptManagement.generation;

import java.io.IOException;

import com.crusaders.gauntlet.java.fileManagement.creation.Creator;
import com.crusaders.gauntlet.java.util.macros.scriptManagement.Script;

public class KeySequenceScriptGenerator implements ScriptGenerator{
    
    public static final String EXTENTION_OF_FILE = ".txt";
    
    private static int indexOfScript = 0;
    
    private Creator creator;
    
    public KeySequenceScriptGenerator() 
    {
        initDependecies();
    }
    
    private void initDependecies() 
    {
        creator = new Creator();
    }
    
    public int getIndex()
    {
        return indexOfScript;
    }
    
    

    public Script generateNewScript(String path, String name) throws IOException 
    {
        String fullPath = path + "/" + name+ indexOfScript + EXTENTION_OF_FILE;
        indexOfScript++;
        return new Script( creator.createFile( fullPath ) );
    }
}
