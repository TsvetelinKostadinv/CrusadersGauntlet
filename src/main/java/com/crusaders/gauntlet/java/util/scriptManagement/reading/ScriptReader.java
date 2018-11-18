package com.crusaders.gauntlet.java.util.scriptManagement.reading;

import com.crusaders.gauntlet.java.util.fileManagement.reading.IFileReader;
import com.crusaders.gauntlet.java.util.fileManagement.reading.Reader;
import com.crusaders.gauntlet.java.util.scriptManagement.Script;

/**
 * 
 * Standart interface for reading the Crusaders Gauntlet's scripts
 * 
 * @author Tsvetelin
 *
 * @param <T> - the type in which the read scripts will be represented 
 * (needs to implement the <code>IParsableFromString</code> interface)
 */
@FunctionalInterface
public interface ScriptReader<T extends IParsableFromString< ? >>
{
    public static final IFileReader reader = new Reader();
    
    /**
     * Reads the script supplied and represents it as the <code>T</code> object.
     * 
     * @param script - the script object which will be read
     * @return the representation of the Script object in the <code>T</code> object if it can be parsed
     *  and <code>null</code> otherwise.
     */
    public T readScript(Script script);
    
}
