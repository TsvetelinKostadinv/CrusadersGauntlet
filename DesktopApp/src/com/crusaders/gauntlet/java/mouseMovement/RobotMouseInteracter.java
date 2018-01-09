package com.crusaders.gauntlet.java.mouseMovement;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;

import org.eclipse.xtext.xbase.lib.Pair;

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
	
	
	
	public final int maxSpeed = 20;
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
		
		Pair<Integer, Integer> speeds = accelerateToMaxSpeed(direction);
//		for(int i=0;i<time;i++)
//		{
//			updateMouseCoord();
//			robo.mouseMove(mouseX+direction.getAccX(), mouseY+direction.getAccY());
//			System.out.println("Mouse coord: ");
//			System.out.println(mouseX+", "+mouseY);
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
	}

	private Pair<Integer, Integer> accelerateToMaxSpeed(Direction direction) 
	{
		/*
		 * the speedX is the key;
		 * the speedY is the value;
		 */
		
		Pair<Integer, Integer> speeds = new Pair<Integer, Integer>(1,1);
		do{
			
			System.out.println("acc: "+speeds.getKey()+", "+speeds.getValue());
			
			updateMouseCoord();
			
			robo.mouseMove(mouseX+speeds.getKey(), mouseY+speeds.getValue());
			
			System.out.println("Moved the mouse!");
			
			speeds = increaseSpeeds(speeds.getKey(), speeds.getValue(), direction);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}while(!checkMaxSpeedsReached(speeds, direction));
		//System.out.println(speedX<maxSpeedX && speedY<maxSpeedY);
		return speeds;
	}
	
	private boolean checkMaxSpeedsReached(Pair<Integer, Integer> speeds, Direction direction) {
		if(direction.getAccX()>=0)
		{
			if(speeds.getKey()>=maxSpeed)
			{
				return true;
			}
		}else{
			if(speeds.getKey()<=(-maxSpeed))
			{
				return true;
			}
		}
		
		if(direction.getAccY()>=0)
		{
			if(speeds.getValue()>=maxSpeed)
			{
				return true;
			}
		}else{
			if(speeds.getValue()<=(-maxSpeed))
			{
				return true;
			}
		}
		return false;
	}

	private Pair<Integer, Integer> increaseSpeeds(int speedX, int speedY, Direction direction)
	{
		if(direction.getAccX()>=0) { speedX+=increment; } else { speedX-=increment; }
		if(direction.getAccY()>=0) { speedY+=increment; } else { speedY-=increment; }
		
		return new Pair<Integer, Integer>(speedX, speedY);
	}
	
	
	private void updateMouseCoord()
	{
		Point loc = MouseInfo.getPointerInfo().getLocation();
		this.mouseX = (int) loc.getX();
		this.mouseY = (int) loc.getY();
		loc=null;
	}
	
	public static void main(String[] args)
	{
		RobotMouseInteracter i = new RobotMouseInteracter();
		i.moveMouse(new Direction(-60, -30));
	}

}
