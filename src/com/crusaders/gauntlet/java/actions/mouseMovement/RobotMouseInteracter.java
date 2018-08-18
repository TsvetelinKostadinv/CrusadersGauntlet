package com.crusaders.gauntlet.java.actions.mouseMovement;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;

import com.crusaders.gauntlet.java.actions.ActionTaker;
import com.crusaders.gauntlet.java.util.Direction;

@ActionTaker
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
	
    public static final int DEFAULT_MAX_CURSOR_SPEED = 30;
    public static final int DEFAULT_MAX_INPUT_SPEED = 16000;
    public static final int DEFAULT_MIN_INPUT_SPEED = 0;
	
	private int maxCursorSpeed;
	private int maxInputSpeed;
	private int minInputSpeed;
	
	private Robot robo;
	private int mouseX, mouseY;
	
	public RobotMouseInteracter()
	{
	    this.maxInputSpeed = DEFAULT_MAX_INPUT_SPEED;
        this.minInputSpeed = DEFAULT_MIN_INPUT_SPEED;
        
        this.maxCursorSpeed = DEFAULT_MAX_CURSOR_SPEED;
        
		initDependencies();
	}
	
	public RobotMouseInteracter(int maxInputSpeed, int minInputSpeed)
    {
	    this.maxInputSpeed = maxInputSpeed;
	    this.minInputSpeed = minInputSpeed;
	    
	    this.maxCursorSpeed = DEFAULT_MAX_CURSOR_SPEED;
	    
        initDependencies();
    }
	
	public RobotMouseInteracter(int maxInputSpeed, int minInputSpeed, int maxCursorSpeed)
    {
        this.maxInputSpeed = maxInputSpeed;
        this.minInputSpeed = minInputSpeed;
        
        this.maxCursorSpeed = maxCursorSpeed;
        
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
	public void moveMouse(Direction dir)
	{
		updateMouseCoord();
		
		int x = dir.getAccX();
		int y = dir.getAccY();
		
		double mappedX = map( minInputSpeed , maxInputSpeed , 0 , 1 , x);
		double mappedY = map( minInputSpeed , maxInputSpeed , 0 , 1 , y);
		
		int speedX = (int) (Math.sin(mappedX)*maxCursorSpeed);
		int speedY = (int) (Math.sin(mappedY)*maxCursorSpeed);
		
		robo.mouseMove(mouseX+speedX, mouseY+speedY);
		
	}
	



    private void updateMouseCoord()
	{
		Point loc = MouseInfo.getPointerInfo().getLocation();
		this.mouseX = (int) loc.getX();
		this.mouseY = (int) loc.getY();
		loc=null;
	}
    
    private double map ( 
            int startOfOriginalInterval ,
            int endOfOriginalInterval ,
            int startOfMappedInterval ,
            int endOfMappedInterval ,
            int valueToBeMapped) 
    {
        return (valueToBeMapped*1.0 - startOfOriginalInterval*1.0) 
                    * 
                    (endOfMappedInterval*1.0 - startOfMappedInterval*1.0)
                    / 
                    (endOfOriginalInterval*1.0 - startOfOriginalInterval*1.0) 
                    + startOfMappedInterval*1.0;
    }

    
    public int getMaxCursorSpeed () {
    
        return maxCursorSpeed;
    }

    
    public void setMaxCursorSpeed ( int maxCursorSpeed ) {
    
        this.maxCursorSpeed = maxCursorSpeed;
    }

    
    public int getMaxInputSpeed () {
    
        return maxInputSpeed;
    }

    
    public void setMaxInputSpeed ( int maxInputSpeed ) {
    
        this.maxInputSpeed = maxInputSpeed;
    }

    
    public int getMinInputSpeed () {
    
        return minInputSpeed;
    }

    
    public void setMinInputSpeed ( int minInputSpeed ) {
    
        this.minInputSpeed = minInputSpeed;
    }

    
    public int getMouseX () {
    
        return mouseX;
    }

    
    public int getMouseY () {
    
        return mouseY;
    }
}
