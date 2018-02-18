package com.crusaders.gauntlet.java.keyPress;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class RobotKeyPresser implements KeyPresser {
	
	Robot robo;
	
	private static boolean isShiftPressed = false; 
	
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
	public void pressKey(int key) {
		if(key == KeyEvent.VK_SHIFT){
			if(!isShiftPressed)
			{
				robo.keyPress(key);
			}else{
				robo.keyRelease(key);
			}
		}else{
			robo.keyPress(key);
			robo.keyRelease(key);
		}
		
	}
	
	//This method is because my robot really likes to hold the shift
	@Override
	public void releaseShift()
	{
		
		robo.keyRelease(KeyEvent.VK_SHIFT);
	}
}
