package com.crusaders.gauntlet.java.test;

import com.crusaders.gauntlet.java.models.DirectionPointer;

public class DirectionPointerTest {

	public static void main(String[] args) {
		DirectionPointer direction = new DirectionPointer();
		DirectionPointer secondDirection = new DirectionPointer();
		
		direction.directionSetUPLEFT();
		secondDirection.directionSetDOWN();
		
		System.out.println(direction.getDirectionPointing());
		System.out.println(secondDirection.getDirectionPointing());
		
	}
	
	//06.11.2017 WORKING

}
