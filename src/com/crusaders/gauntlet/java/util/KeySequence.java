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
    
    public List< Integer > getKeys () 
    {
    
        return keys;
    }

    
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
