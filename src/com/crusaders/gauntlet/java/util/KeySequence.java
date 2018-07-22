package com.crusaders.gauntlet.java.util;

import java.util.ArrayList;
import java.util.List;

public class KeySequence
{
    private List<Integer> keys;
    
    
    public KeySequence ( Integer... integers )
    {
        initDependencies();
        for(Integer i : integers)
        {
            keys.add( i );
        }
    }
    
    public KeySequence ()
    {
        initDependencies();
    }

    private void initDependencies () 
    {

        keys = new ArrayList<Integer>();
        
    }
    
    @Override
    public String toString () 
    {
        StringBuilder sb = new StringBuilder();
        
        for(Integer i : keys)
        {
            sb.append( i.toString() );
            sb.append( Reference.separator );
        }
        
        return sb.toString();
    }
    
    @Override
    public boolean equals ( Object obj ) 
    {
        if(obj instanceof KeySequence)
        {
            for(int i=0;i<this.keys.size();i++)
            {
                if(this.keys.get( i ) != ( (KeySequence) obj ).getKeys().get( i ))
                {
                    return false;
                }
            }
            return true;
        }
       return false;
    }
    
    public KeySequence addKey(Integer key)
    {
        keys.add( key );
        return this;
    }
    
    public void addKeys(Integer... keys)
    {
        for(Integer i : keys)
        {
            addKey( i );
        }
    }
    
    public void addKeys ( List<Integer> keys ) 
    {
        
        for(Integer i : keys)
        {
            this.addKey( i );
        }
        
    }
    
    public List< Integer > getKeys () {
    
        return keys;
    }

    
    public void setKeys ( List< Integer > keys ) {
    
        this.keys = keys;
    }
    
}
