package com.crusaders.gauntlet.java.util.scriptManagement.generation;

import java.io.IOException;

import com.crusaders.gauntlet.java.util.scriptManagement.Script;

public class KeySequenceScriptGenerator implements ScriptGenerator{
    
    public static final String EXTENTION_OF_FILE = ".txt";
    
    private static int indexOfScript = 0;
    
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
