/*
 * 20/32/2018 at 19:32:13
 * GauntletData.java created by Tsvetelin
 */
package com.crusaders.gauntlet.java.util;

import java.util.Arrays;

import com.crusaders.gauntlet.java.util.Reference.CrusadersGauntletSpecialSymbols;
import com.crusaders.gauntlet.java.util.scriptManagement.reading.IParsableFromString;

/**
 * @author Tsvetelin
 *
 */
public class GauntletData implements IParsableFromString< GauntletData >
{
    public final int accXIndex = 1;
    public final int accYIndex = 0;
    public final int accZIndex = 2;
    
    public final int btn1PushedStateIndex = 3;
    public final int btn2PushedStateIndex = 4;
    public final int btn3PushedStateIndex = 5;
    public final int btn4PushedStateIndex = 6;
    
    public short[] data = new short[7];
    
    
    public GauntletData (short[] data)
    {
        setData( data );
    }
    
    
    public GauntletData ()
    {
        setData( new short[7] );
    }
    
    
    /**
     * 
     * Sets the internal array to the new one provided
     * 
     * @param newData - the new array which will be assigned
     */
    public void setData(short[] newData)
    {
        if(newData!=null && newData.length == this.data.length)
        {
            for(int i = 0;i<this.data.length;i++)
            {
                if(i == accZIndex)
                {
                    this.data[i] = 0;
                }
                this.data[i] = newData[i];
            }
        }else {
            throw new IllegalArgumentException("Input array must not be null or size different of 7");
        }
    }
    
    
    @Override
    public GauntletData parse ( String str ) {
        String[] parts = str.split( "\\" + Reference.CrusadersGauntletSpecialSymbols.DATA_SEPARATION_SYMBOL.getValue() );
        short[] data = new short[this.data.length];
        
        for(int i=0;i<parts.length;i++)
        {
            switch ( i )
                {
                    case accXIndex :
                        data[accXIndex] = Short.parseShort( parts[accXIndex] );
                        break;
                    case accYIndex :
                        data[accYIndex] = Short.parseShort( parts[accYIndex] );
                        break;
                    case btn1PushedStateIndex :
                        data[btn1PushedStateIndex] = Short.parseShort( parts[btn1PushedStateIndex] );
                        break;
                    case btn2PushedStateIndex :
                        data[btn2PushedStateIndex] = Short.parseShort( parts[btn2PushedStateIndex] );
                        break;
                    case btn3PushedStateIndex :
                        data[btn3PushedStateIndex] = Short.parseShort( parts[btn3PushedStateIndex] );
                        break;
                    case btn4PushedStateIndex :
                        String specialCase = parts[btn4PushedStateIndex].charAt( 0 ) + "";
                        data[btn4PushedStateIndex] = Short.parseShort( specialCase );
                        break;
                    default : continue;
                }
        }
        
        
        return new GauntletData( data );
        
    }


    @Override
    public String toString () 
    {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<data.length;i++)
        {
            sb.append( data[i] );
            sb.append( CrusadersGauntletSpecialSymbols.DATA_SEPARATION_SYMBOL.getValue() );
        }
        sb.append( CrusadersGauntletSpecialSymbols.DATA_TERMINATION_SYMBOL.getValue() );
        return sb.toString();
    }
    
    @Override
    public boolean equals ( Object arg0 ) 
    {
        if(arg0 instanceof GauntletData)
        {
            if(this.toString().equals( arg0.toString() )) return true;
        }
        return false;
    }
    
    /**
     * 
     * Parses the data from this object to a <code>Direction</code> object
     * 
     * @return the <code>Direction</code> object created
     * 
     * @see Direction
     */
    public Direction castToDirection()
    {
        return new Direction( data[accXIndex] , data[accYIndex] );
    }
    
}
