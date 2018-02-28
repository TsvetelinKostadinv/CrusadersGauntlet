package com.crusaders.gauntlet.java.main;

import com.crusaders.gauntlet.java.GUI.MainWindow;
import com.crusaders.gauntlet.java.models.macroFunctionality.MacroSet;

public class Main {
	
	private MainWindow mainWindow;
	@SuppressWarnings("unused")
	private MacroSet macroSet;
	
	public Main() 
	{
		initDependencies();
	}

	private void initDependencies() 
	{
		mainWindow = new MainWindow();
		macroSet = new MacroSet("", "");
	}
	
	private void run()
	{
		mainWindow.run();
	}
	
	public static void main(String[] args)
	{
		Main process = new Main();
		
		process.run();
		
	}
	
}
