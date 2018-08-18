//18.08.2018 ã. at 15:42:01
//ActionManager.java created by Tsvetelin

package com.crusaders.gauntlet.java.actions;

/**
 * 
 * @author Tsvetelin
 *
 * @param <DataType> - the type of data which will be forwarded to the <code>ActionTaker</code>
 */
public abstract class ActionManager<DataType>
{
    private ActionTaker taker;

    public ActionManager ( ActionTaker taker )
    {
        super();
        this.setTaker( taker );
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
    public ActionTaker getTaker () 
    {
        return taker;
    }
    
    /**
     * 
     * @param taker - the new <code>ActionTaker</code> object which will be assigned
     */
    public void setTaker ( ActionTaker taker ) 
    {
        this.taker = taker;
    }
    

}
