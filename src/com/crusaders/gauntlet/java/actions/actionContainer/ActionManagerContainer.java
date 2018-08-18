//18.08.2018 ã. at 15:31:46
//ActionTakerContainer.java created by Tsvetelin

package com.crusaders.gauntlet.java.actions.actionContainer;

import java.util.ArrayList;
import java.util.List;

import com.crusaders.gauntlet.java.actions.ActionManager;

public class ActionManagerContainer
{
    private final List< ActionManager < ? > > managers = new ArrayList< ActionManager < ? > >();
    
    /**
     * 
     * Adds the supplied <code>ActionManager</code> object to the internal list
     * 
     * @param newManager - the <code>ActionManager</code> object which will be added
     */
    public void addManager(ActionManager < ? > newManager)
    {
        managers.add( newManager );
    }
    
    /**
     * 
     * Removes all instance of the supplied <code>ActionManager</code> object from the internal list
     * 
     * @param toRemove - the <code>ActionManager</code> object which will be removed
     */
    public void removeManager(ActionManager < ? > toRemove)
    {
        do {
            managers.remove( toRemove );
        }while(managers.contains( toRemove ));
    }
    
    /**
     * 
     * @return a copy of the list for informative purpouses
     */
    public List<ActionManager < ? >> getManagers (  )
    {
        return new ArrayList<ActionManager < ? >>( managers );
    }
    
}
