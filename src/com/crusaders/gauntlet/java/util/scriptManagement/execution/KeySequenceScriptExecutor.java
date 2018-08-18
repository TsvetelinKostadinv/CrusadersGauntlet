//18.08.2018  at 14:28:29
//KeySequenceScriptExecutor.java created by Tsvetelin

package com.crusaders.gauntlet.java.util.scriptManagement.execution;

import com.crusaders.gauntlet.java.keyPress.KeySequencePresser;
import com.crusaders.gauntlet.java.util.KeySequence;
import com.crusaders.gauntlet.java.util.scriptManagement.Script;
import com.crusaders.gauntlet.java.util.scriptManagement.reading.KeySequenceScriptReader;
import com.crusaders.gauntlet.java.util.scriptManagement.reading.ScriptReader;

public class KeySequenceScriptExecutor implements ScriptExecutor< KeySequencePresser >
{
    
    public final ScriptReader< KeySequence > reader = new KeySequenceScriptReader();

    @Override
    public  void executeScript ( Script script , KeySequencePresser presser ) 
    {
        KeySequence ks = reader.readScript( script );
        presser.pressKeys( ks );
    }

}
