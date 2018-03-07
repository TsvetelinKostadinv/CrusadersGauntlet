package com.crusaders.gauntlet;

import com.crusaders.gauntlet.java.GUI.MainMenu;
import com.crusaders.gauntlet.java.models.macroFunctionality.MacroSet;

public final class StarterClass 
{
	private static MainMenu menuWind;
	
	
	private static Session session;
	
	public static void main(String[] args)
	{
		init();
		run();
	}
	
	private static void init()
	{
		menuWind = new MainMenu();
		session = Session.getInstance();
		initSession();
	}
	

	private static void run()
	{
		menuWind.run();
	}
	
	
	private static void initSession() {
		session.addAttribute("macros", new MacroSet("", ""));
		
	}
	
}
