package com.crusaders.gauntlet.java.mouseMovement;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;

import org.eclipse.xtext.xbase.lib.Pair;

import com.crusaders.gauntlet.java.models.Direction;

public class RobotMouseInteracter implements MouseInteracter{
	
	public final int maxSpeed = 50;
	public final int maxInputSpeed = 100;
	public final int stepsForMaxSpeed = 3;
	public final int increment = maxSpeed/stepsForMaxSpeed;
	
	private Robot robo;
	
	public RobotMouseInteracter() 
	{
		initDependencies();
	}

	private void initDependencies() {
		try {
			robo = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void moveMouse(Direction direction) 
	{
		accelerateToMaxSpeed(direction, maxSpeed);
		
	}

	private Pair<Integer, Integer> accelerateToMaxSpeed(Direction direction, int maxSpeed) 
	{
		Point loc = MouseInfo.getPointerInfo().getLocation();
		int mouseX = (int) loc.getX();
		int mouseY = (int) loc.getY();
		
		loc = null;
		
		int speedX=1;
		int speedY=1;
		int maxSpeedX = (direction.getAccX()*maxSpeed)/maxInputSpeed;
		int maxSpeedY = (direction.getAccY()*maxSpeed)/maxInputSpeed;

		do{
			mouseX = mouseX+speedX;
			mouseY = mouseY+speedY;
			robo.mouseMove(mouseX, mouseY);
			speedX+=increment;
			speedY+=increment;
		}while(speedX!=maxSpeedX || speedY!=maxSpeedY);
		
		return new Pair<Integer, Integer>(speedX, speedY);
	}
	
	public static void main(String[] args)
	{
		RobotMouseInteracter i = new RobotMouseInteracter();
		i.moveMouse(new Direction(60, -30));
	}
	
}
