package com.crusaders.gauntlet.java.keyPress;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class RobotKeyPresser implements KeyPresser {
	
	Robot robo;
	
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
	public boolean pressKey(int key) {
		System.out.println(KeyEvent.getExtendedKeyCodeForChar(key));
		System.out.println(KeyEvent.VK_0);
		return false;
		
	}

	@Override
	public boolean pressKey(String keys) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public static void main(String args[])
	{
		RobotKeyPresser presser = new RobotKeyPresser();
		presser.pressKey('0');
	}
	
}
