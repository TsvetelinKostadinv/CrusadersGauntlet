package com.crusaders.gauntlet.java.mouseMovement;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;

import com.crusaders.gauntlet.java.models.Direction;

public class RobotMouseInteracter implements MouseInteracter{
	
	/* REMEMBER!!!!!
	 * X++ is there
	 * ---------------\
	 * 				    \
	 * 					  >
	 * 		 			/
	 * ---------------/
	 * 
	 * */
	
	/* REMEMBER!!!!!
	 * Y++ is there
	 * |    |
	 * |    |
	 * |    |
	 * |    |
	 *  \  /
	 * 	 \/
	 * */
	
	
	
	public final int maxSpeed = 30;
	public final int maxInputSpeed = 100;
	public final int stepsForMaxSpeed = 20;
	public final int increment = maxSpeed/stepsForMaxSpeed;
	
	private Robot robo;
	private int mouseX, mouseY;
	
	public RobotMouseInteracter()
	{
		initDependencies();
	}

	private void initDependencies() 
	{
		Point loc = MouseInfo.getPointerInfo().getLocation();
		mouseX = (int) loc.getX();
		mouseY = (int) loc.getY();
		loc=null;
		try {
			robo = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void moveMouse(Direction direction)
	{
		updateMouseCoord();
		
		int speedX = (int) (Math.sin(Math.toRadians(direction.getAccX()))*maxSpeed);
		int speedY = (int) (Math.sin(Math.toRadians(direction.getAccY()))*maxSpeed);
		
		robo.mouseMove(mouseX+speedX, mouseY+speedY);
		
	}
	
	private void updateMouseCoord()
	{
		Point loc = MouseInfo.getPointerInfo().getLocation();
		this.mouseX = (int) loc.getX();
		this.mouseY = (int) loc.getY();
		loc=null;
	}


}
