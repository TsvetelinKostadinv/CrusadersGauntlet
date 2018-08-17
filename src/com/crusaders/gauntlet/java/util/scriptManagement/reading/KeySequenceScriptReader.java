package com.crusaders.gauntlet.java.util.scriptManagement.reading;

import java.io.IOException;

import com.crusaders.gauntlet.java.util.KeySequence;
import com.crusaders.gauntlet.java.util.scriptManagement.Script;

public class KeySequenceScriptReader implements ScriptReader< KeySequence >
{
    
    @Override
    public KeySequence readScript ( Script script ) 
    {
        String content = null;
        try
        {
            content = reader.readFile( script.getScript() );
        } catch ( IOException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if(content == null || content.equals( "" ))
        {
            return null;
        }else {
            KeySequence ks = new KeySequence();
            return ks.parse( content );
        }
    }

}
