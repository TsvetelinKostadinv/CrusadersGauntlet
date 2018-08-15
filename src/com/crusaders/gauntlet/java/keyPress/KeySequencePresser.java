package com.crusaders.gauntlet.java.keyPress;

import com.crusaders.gauntlet.java.util.KeySequence;

public interface KeySequencePresser
{
    /**
     * Presses the keys annotated by the KeySequence object
     * 
     * @param keys
     */
    public void pressKeys(KeySequence keys);
}