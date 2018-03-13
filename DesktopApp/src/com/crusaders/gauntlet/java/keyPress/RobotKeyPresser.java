package com.crusaders.gauntlet.java.keyPress;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class RobotKeyPresser implements KeyPresser {
	
	Robot robo;

	
	
	private static boolean isShiftPressed = false; 
	private static boolean isMouseButton1Pressed = false; 
	private static boolean isMouseButton2Pressed = false; 
	private static boolean isMouseButton3Pressed = false;
	
	public RobotKeyPresser()
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
	public void pressKey(Integer key) {
		//System.out.println("Is left click: "+(key==KeyEvent.BUTTON1_DOWN_MASK));
		//System.out.println("Is middle click: "+(key==KeyEvent.BUTTON2_DOWN_MASK));
		//System.out.println("Is right click: "+(key==KeyEvent.BUTTON3_DOWN_MASK));
		
		if(key == null)
		{
			return;
		}
		
		switch (key.intValue()) {
		case KeyEvent.VK_SHIFT:
			if(!isShiftPressed)
			{
				isShiftPressed= true;
				robo.keyPress(key);
			}else{
				isShiftPressed = false; 
				releaseShift();
			}
			break;
			
		case KeyEvent.BUTTON1_DOWN_MASK:
			System.out.println("Its left click!!!");
			if(!isMouseButton1Pressed)
			{
				
				isMouseButton1Pressed= true;
				robo.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
			}else{
				isMouseButton1Pressed = false; 
				robo.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
			}
			break;
		case KeyEvent.BUTTON2_DOWN_MASK:
			if(!isMouseButton2Pressed)
			{
				isMouseButton2Pressed= true;
				robo.mousePress(KeyEvent.BUTTON2_DOWN_MASK);
			}else{
				isMouseButton2Pressed = false; 
				robo.mouseRelease(KeyEvent.BUTTON2_DOWN_MASK);
			}
			break;
		case KeyEvent.BUTTON3_DOWN_MASK:
			if(!isMouseButton3Pressed)
			{
				isMouseButton3Pressed= true;
				robo.mousePress(KeyEvent.BUTTON3_DOWN_MASK);
			}else{
				isMouseButton3Pressed = false; 
				robo.mouseRelease(KeyEvent.BUTTON3_DOWN_MASK);
			}
			break;
		default:
			robo.keyPress(key);
			robo.keyRelease(key);
			break;
		}
		
	}
	
	//This method is because my robot really likes to hold the shift
	@Override
	public void releaseShift(){	robo.keyRelease(KeyEvent.VK_SHIFT); }
}
