package com.crusaders.gauntlet.java.actions.mouseMovement;

/**
 * 
 * An interface defining a method for moving the mouse from the data provided by the <code>DataType</code>
 * 
 * @author Tsvetelin
 *
 * @param <DataType> - the type used for the input data
 */
@FunctionalInterface
public interface MouseInteracter < DataType > {
    /**
     * 
     * Moves the mouse using the provided Direction object.
     * 
     * @param direction
     */
	public void moveMouse(DataType direction);
}
