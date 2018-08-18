//18.08.2018 ã. at 15:42:01
//ActionManager.java created by Tsvetelin

package com.crusaders.gauntlet.java.actions;

/**
 * 
 * @author Tsvetelin
 *
 * @param <DataType> - the type of data which will be forwarded to the <code>Taker</code> object
 * @param <Taker> - the type which will execute the commands from the <code>DataType</code>
 */
public abstract class ActionManager <DataType, Taker>
{
    private Taker taker;

    public ActionManager ( Taker taker )
    {
        if(taker.getClass().isAnnotationPresent( ActionTaker.class ))
        {
            this.setTaker( taker );
        }else {
            throw new IllegalArgumentException("Cannot assign a class which does not have @ActionTaker annotation");
        }
    }
    
    /**
     * 
     * Formats and sends the <code>DataType</code> object to the <code>ActionTaker</code>
     * 
     * @param data
     */
    public abstract void forwardDataToActionTaker(DataType data);
    
    public abstract Class< ? > getDataType();
    
    /**
     * 
     * @return the taker assigned to this object
     */
    public Taker getTaker () 
    {
        return taker;
    }
    
    /**
     * 
     * @param taker - the new <code>ActionTaker</code> object which will be assigned
     */
    public void setTaker ( Taker taker ) 
    {
        this.taker = taker;
    }
    
}
