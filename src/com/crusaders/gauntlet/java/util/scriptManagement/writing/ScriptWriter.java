package com.crusaders.gauntlet.java.util.scriptManagement.writing;

import java.io.IOException;

import com.crusaders.gauntlet.java.util.fileManagement.writing.IFileWriter;
import com.crusaders.gauntlet.java.util.fileManagement.writing.Writer;
import com.crusaders.gauntlet.java.util.scriptManagement.Script;

public interface ScriptWriter<T>
{
    
    IFileWriter writer = new Writer();
    
    /**
     * This method saves the <code>T</code> object into the script file. <br>
     * Even though this method has a default version it is highly suggested u override it.
     * 
     * @param script - the script object to be written to
     * @param toBeWritten - the thing to be saved to that script
     */
    public default void writeToScript(Script script, T toBeWritten)
    {
        try
        {
            writer.writeToFile( script.getScript() , toBeWritten.toString() , true );
        } catch ( IOException e )
        {
            e.printStackTrace();
        }
    }
}
