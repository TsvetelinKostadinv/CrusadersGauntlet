//18.08.2018 ã. at 15:31:46
//ActionTakerContainer.java created by Tsvetelin

package com.crusaders.gauntlet.java.actions.actionContainer;

import java.util.ArrayList;
import java.util.List;

import com.crusaders.gauntlet.java.actions.ActionManager;

/**
 * 
 * This container class holds <code>ActionManagers</code>.  <br>
 * This class is singleton because there needs to be one and only one instance of this object at any given time <br>
 * 
 * 
 * @author Tsvetelin
 *
 */
public class ActionManagerContainer
{
    private final List< ActionManager < ?, ?> > managers;
    
    private ActionManagerContainer instance = null;
    
    public ActionManagerContainer getInstance() 
    { 
        if(instance == null)
        {
            instance = new ActionManagerContainer();
        }
        return instance; 
    }
    
    private ActionManagerContainer ()
    {
        managers = new ArrayList< ActionManager < ?, ? > >();
    }
    
    /**
     * 
     * Adds the supplied <code>ActionManager</code> object to the internal list
     * 
     * @param newManager - the <code>ActionManager</code> object which will be added
     */
    public void addManager(ActionManager < ?, ? > newManager)
    {
        managers.add( newManager );
    }
    
    /**
     * 
     * Removes all instance of the supplied <code>ActionManager</code> object from the internal list
     * 
     * @param toRemove - the <code>ActionManager</code> object which will be removed
     */
    public void removeManager(ActionManager < ?, ? > toRemove)
    {
        do {
            managers.remove( toRemove );
        }while(managers.contains( toRemove ));
    }
    
    /**
     * 
     * @return a copy of the list for informative purposes
     */
    public List<ActionManager < ?, ? >> getManagers (  )
    {
        return new ArrayList<ActionManager < ?, ? >>( managers );
    }
    
    /**
     * 
     * Updates all the managers with the provided data object   <br>
     * which will be checked for compatibility with every <code>Action manager</code>   <br>
     * before casting the data to the <code>DataType</code> of the <code>ActionManager</code>.
     * 
     * 
     * @param data - the object which will be forwarded
     */
    @SuppressWarnings ( "all" )
    public void updateManagers( Object data )
    {
        for ( ActionManager manager : managers )
        {
            Class< ? > dataType = manager.getDataType();
            if( dataType.isInstance( data ) )
            {
                manager.forwardDataToActionTaker( dataType.cast( data ) );
            }
        }
    }
    
}
