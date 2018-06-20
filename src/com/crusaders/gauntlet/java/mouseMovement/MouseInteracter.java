package com.crusaders.gauntlet.java.mouseMovement;

import com.crusaders.gauntlet.java.util.Direction;

public interface MouseInteracter {
    /**
     * 
     * Moves the mouse using the provided Direction object.
     * First maps the x and y of the Direction object from zero to one.
     * Second uses the values as radians for the argument of a sin function.
     * This helps to regulate the sensitivity of the gyroscope
     * 
     * @param direction
     */
	public void moveMouse(Direction direction);
}
