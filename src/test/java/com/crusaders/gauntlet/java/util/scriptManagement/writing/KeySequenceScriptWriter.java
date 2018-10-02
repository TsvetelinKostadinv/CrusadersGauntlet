package com.crusaders.gauntlet.java.util.scriptManagement.writing;

import java.io.IOException;

import com.crusaders.gauntlet.java.util.scriptManagement.Script;

public class KeySequenceScriptWriter implements ScriptWriter< KeySequenceScriptWriter >
{
    @Override
    public void writeToScript ( Script script , KeySequenceScriptWriter toBeWritten ) 
    {
        try
        {
            writer.writeToFile( script.getScript() , toBeWritten.toString() , true );
        } catch ( IOException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
