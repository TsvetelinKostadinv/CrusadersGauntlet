package com.crusaders.gauntlet.java.util.scriptManagement.generation;

import java.io.IOException;

import com.crusaders.gauntlet.java.util.scriptManagement.Script;

public interface ScriptGenerator
{
    public static final String DEFAULT_DIRECTORY_PATH = "C:/CrusadersGauntlet/";
    public static final String DEFAULT_NAME = "ActionOfMacro";
    
    /**
     * Creates a script file in the annotated by the path
     * 
     * @return returns the Script object pointing to the script file created or
     * @throws IOException if an IO Exception occurred during the files creation
     */
    public Script generateNewScript(String directoryPath, String name) throws IOException;
    
    /**
     * 
     * Creates a script file in the <code>DEFAULT_DIRECTORY_PATH</code> with the <code>DEFAULT_NAME</code>
     * 
     * @return returns the Script object pointing to the script file created or
     * @throws IOException if an IO Exception occurred during the files creation
     */
    public default Script generateNewScript() throws IOException 
    { 
        return generateNewScript(DEFAULT_DIRECTORY_PATH, DEFAULT_NAME); 
    }
    
    /**
     * 
     * Creates a script file in the <code>DEFAULT_DIRECTORY_PATH</code> with the <code>name</code> supplied
     * 
     * @return returns the Script object pointing to the script file created or
     * @throws IOException if an IO Exception occurred during the files creation
     */
    public default Script generateNewScript(String name) throws IOException 
    { 
        return generateNewScript(DEFAULT_DIRECTORY_PATH, name); 
    }
}
