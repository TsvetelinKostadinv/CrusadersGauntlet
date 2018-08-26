package com.crusaders.gauntlet.java.actions.keyPress;

import com.crusaders.gauntlet.java.util.KeySequence;

/**
 * 
 * An interface which defines a method for pressing keys from a <code>KeySequence</code> object <br>
 * 
 * This interface and <code>KeyPresser</code> will soon be merged into a generic interface and will be revamped
 * 
 * @author Tsvetelin
 *
 */
public interface KeySequencePresser extends KeyPresser
{
    /**
     * Presses the keys annotated by the KeySequence object
     * 
     * @param keys
     */
    public void pressKeys(KeySequence keys);
}
