package com.crusaders.gauntlet.java.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

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
                if(this.keys.get( i ) != ( (KeySequence) obj ).getKeysAsList().get( i ))
                {
                    return false;
                }
            }
            return true;
        }
       return false;
    }
    
    /**
     * 
     * Adds the supplied key to the end of the sequence. <br>
     * Note that there is no way to check if the value is of a real key or not so caution is needed with this method
     * 
     * @param key
     * @return the same object for further manipulaton
     */
    public KeySequence addKey(Integer key)
    {
        keys.add( key );
        return this;
    }
    
    /**
     * Adds the supplied array of keys to the end of the sequence in the order they are in the array. <br>
     * Note that there is no way to check if the value is of a real key or not so caution is needed with this method
     * 
     * @param keys
     * @return the same object for further manipulaton
     */
    public KeySequence addKeys(Integer... keys)
    {
        for(Integer i : keys)
        {
            addKey( i );
        }
        return this;
    }
    
    /**
     * Adds the supplied list of keys to the end of the sequence in the order they are in the list. <br>
     * Note that there is no way to check if the value is of a real key or not so caution is needed with this method
     * 
     * @param keys
     * @return the same object for further manipulaton
     */
    public KeySequence addKeys ( List<Integer> keys ) 
    {
        
        for(Integer i : keys)
        {
            this.addKey( i );
        }
        
        return this;
    }
    
    /**
     * 
     * @return the keys in the sequence represented in a list
     */
    public List< Integer > getKeysAsList () 
    {
        return keys;
    }
    
    /**
     * 
     * @return the keys in the sequence represented in a list
     */
    public Integer[] getKeysAsArray () 
    {
        return (Integer []) keys.toArray();
    }

    /**
     * 
     * Sets the whole sequence to the supplied list. This clears all previous keys
     * 
     * @param keys
     */
    public void setKeys ( List< Integer > keys ) 
    {
        this.keys = keys;
    }
    
    /**
     * This method parses the string into the KeySequence object. <br>
     * There are, however, some special cases. <br>
     * If it contains the separator char it will try to parse it. <br>
     * If it encounters something it cannot parse it will return the sequence it generated to that moment.
     * 
     * @param str
     * @return KeySequence object formed by the supplied string or <code> null </code> if it cannot be parsed at all
     */
    public static KeySequence parse(String str)
    {
        KeySequence parsedKS = null;
        if(str.contains( Reference.separator ))
        {
            parsedKS = new KeySequence();
            
            String[] parts = str.split( Pattern.quote( Reference.separator )  );
            for(int i = 0;i < parts.length;i++) 
            {
                try {
                    Integer part = Integer.parseInt( parts[i].replaceAll( Pattern.quote( Reference.separator ) , "" ) );
                    parsedKS.addKey( part );
                }catch (NumberFormatException e) {
                    System.out.println( "Caught a string we cannot parse!!" );
                    return parsedKS;
                }
            }
            
            return parsedKS;
        }
        return parsedKS;
    }
    
}
