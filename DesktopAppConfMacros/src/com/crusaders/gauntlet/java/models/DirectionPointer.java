package com.crusaders.gauntlet.java.models;

public class DirectionPointer {
	
	private Directions direction;
	
	public DirectionPointer(){}
	
	
	
	public void directionSetUP()
	{
		direction = Directions.UP;
	}
	public void directionSetDOWN()
	{
		direction = Directions.DOWN;
	}
	public void directionSetLEFT()
	{
		direction = Directions.LEFT;
	}
	public void directionSetRIGHT()
	{
		direction = Directions.RIGHT;
	}
	public void directionSetUPRIGHT()
	{
		direction = Directions.UP_RIGHT;
	}
	public void directionSetUPLEFT()
	{
		direction = Directions.UP_LEFT;
	}
	public void directionSetDOWNRIGHT()
	{
		direction = Directions.DOWN_RIGHT;
	}
	public void directionSetDOWNLEFT()
	{
		direction = Directions.DOWN_LEFT;
	}
	
	
	public String getDirectionPointing()
	{
		return direction.toString();
	}


}
