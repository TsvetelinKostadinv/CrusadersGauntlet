/*
 * 18/57/2018 at 17:57:17 ÷.
 * Macro.java created by Tsvetelin
 */

package com.crusaders.gauntlet.java.macros;

import com.crusaders.gauntlet.java.actions.keyPress.KeySequencePresser;
import com.crusaders.gauntlet.java.actions.keyPress.RobotKeySequencePresser;
import com.crusaders.gauntlet.java.util.scriptManagement.Script;
import com.crusaders.gauntlet.java.util.scriptManagement.execution.KeySequenceScriptExecutor;
import com.crusaders.gauntlet.java.util.scriptManagement.execution.ScriptExecutor;

public class Macro
{
    
    private Script script;
    
    public Macro( Script script )
    {
        this.script = script;
    }
    
    public void executeMacro(  )
    {
        ScriptExecutor< KeySequencePresser > exec = new KeySequenceScriptExecutor();
        
        exec.executeScript( script , new RobotKeySequencePresser() );
        
    }
}
