//18.08.2018 ã. at 13:58:31
//ScriptExecutor.java created by Tsvetelin

package com.crusaders.gauntlet.java.util.scriptManagement.execution;

import com.crusaders.gauntlet.java.actions.keyPress.KeyPresser;
import com.crusaders.gauntlet.java.util.scriptManagement.Script;

/**
 * 
 * @author Tsvetelin
 *
 * @param <Presser> - the type which will do the actual pressing of buttons and must <code>extend KeyPresser</code>
 */
public interface ScriptExecutor< Presser extends KeyPresser>
{
    
    /**
     * 
     * 
     * Parses the raw <code>String</code> from the Script executes it from the <code>Presser</code> object 
     * 
     * @param script - the <code>Script</code> from which it will read
     * @param presser - the actual presser which will do the work has to <code>extend KeyPresser</code>
     */
     public void executeScript(Script script, Presser presser);
}
