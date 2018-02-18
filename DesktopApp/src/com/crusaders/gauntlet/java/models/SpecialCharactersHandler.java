package com.crusaders.gauntlet.java.models;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;

public class SpecialCharactersHandler {
	
	private HashMap<Character, ArrayList<Integer>> specials;
	
	private static SpecialCharactersHandler instance = null;
	
	private SpecialCharactersHandler()
	{
		//System.out.println("Instance created");
		initDependecies();
		fillSpecialsList();
	}

	private void initDependecies()
	{
		specials = new HashMap<Character, ArrayList<Integer>>();
	}
	
	public static SpecialCharactersHandler getInstance()
	{
		if(instance==null)
		{
			instance= new SpecialCharactersHandler();
		}
		return instance;
	}
	
	private void fillSpecialsList() 
	{
		Character[] specialsArray = {'~','!','@','#','$','%','^','&','*','(',')','_','+','{','}',':','"','|','<','>','?'};
		ArrayList<ArrayList<Integer>> recipes = new ArrayList<ArrayList<Integer>>();
		recipes = fillRecipes();
		for(int i = 0;i<specialsArray.length;i++)
		{
			//System.out.println(specialsArray[i]+": "+recipes.get(i));
			specials.put(specialsArray[i], recipes.get(i));
		}
	}
	
	//This is the method i am most disappointed to write because i am sure there is a better way
	private ArrayList<ArrayList<Integer>> fillRecipes() 
	{
		ArrayList<ArrayList<Integer>> readyRecipes = new ArrayList<ArrayList<Integer>>();
		
		ArrayList<Integer> recipe = new ArrayList<Integer>();
		
		recipe.add(KeyEvent.VK_SHIFT);
		recipe.add(KeyEvent.getExtendedKeyCodeForChar('`'));
		readyRecipes.add(new ArrayList<Integer>(recipe));
		recipe.clear();
		
		
		recipe.add(KeyEvent.VK_SHIFT);
		recipe.add(KeyEvent.getExtendedKeyCodeForChar('1'));
		readyRecipes.add(new ArrayList<Integer>(recipe));
		recipe.clear();
		
		recipe.add(KeyEvent.VK_SHIFT);
		recipe.add(KeyEvent.getExtendedKeyCodeForChar('2'));
		readyRecipes.add(new ArrayList<Integer>(recipe));
		recipe.clear();
		
		recipe.add(KeyEvent.VK_SHIFT);
		recipe.add(KeyEvent.getExtendedKeyCodeForChar('3'));
		readyRecipes.add(new ArrayList<Integer>(recipe));
		recipe.clear();
		
		recipe.add(KeyEvent.VK_SHIFT);
		recipe.add(KeyEvent.getExtendedKeyCodeForChar('4'));
		readyRecipes.add(new ArrayList<Integer>(recipe));
		recipe.clear();
		
		recipe.add(KeyEvent.VK_SHIFT);
		recipe.add(KeyEvent.getExtendedKeyCodeForChar('5'));
		readyRecipes.add(new ArrayList<Integer>(recipe));
		recipe.clear();
		
		recipe.add(KeyEvent.VK_SHIFT);
		recipe.add(KeyEvent.getExtendedKeyCodeForChar('6'));
		readyRecipes.add(new ArrayList<Integer>(recipe));
		recipe.clear();
		
		recipe.add(KeyEvent.VK_SHIFT);
		recipe.add(KeyEvent.getExtendedKeyCodeForChar('7'));
		readyRecipes.add(new ArrayList<Integer>(recipe));
		recipe.clear();
		
		recipe.add(KeyEvent.VK_SHIFT);
		recipe.add(KeyEvent.getExtendedKeyCodeForChar('8'));
		readyRecipes.add(new ArrayList<Integer>(recipe));
		recipe.clear();
		
		recipe.add(KeyEvent.VK_SHIFT);
		recipe.add(KeyEvent.getExtendedKeyCodeForChar('9'));
		readyRecipes.add(new ArrayList<Integer>(recipe));
		recipe.clear();
		
		recipe.add(KeyEvent.VK_SHIFT);
		recipe.add(KeyEvent.getExtendedKeyCodeForChar('0'));
		readyRecipes.add(new ArrayList<Integer>(recipe));
		recipe.clear();
		
		recipe.add(KeyEvent.VK_SHIFT);
		recipe.add(KeyEvent.getExtendedKeyCodeForChar('-'));
		readyRecipes.add(new ArrayList<Integer>(recipe));
		recipe.clear();
		
		recipe.add(KeyEvent.VK_SHIFT);
		recipe.add(KeyEvent.getExtendedKeyCodeForChar('='));
		readyRecipes.add(new ArrayList<Integer>(recipe));
		recipe.clear();
		
		recipe.add(KeyEvent.VK_SHIFT);
		recipe.add(KeyEvent.getExtendedKeyCodeForChar('['));
		readyRecipes.add(new ArrayList<Integer>(recipe));
		recipe.clear();
		
		recipe.add(KeyEvent.VK_SHIFT);
		recipe.add(KeyEvent.getExtendedKeyCodeForChar(']'));
		readyRecipes.add(new ArrayList<Integer>(recipe));
		recipe.clear();
		
		recipe.add(KeyEvent.VK_SHIFT);
		recipe.add(KeyEvent.getExtendedKeyCodeForChar(';'));
		readyRecipes.add(new ArrayList<Integer>(recipe));
		recipe.clear();
		
		recipe.add(KeyEvent.VK_SHIFT);
		recipe.add(KeyEvent.getExtendedKeyCodeForChar('\''));
		readyRecipes.add(new ArrayList<Integer>(recipe));
		recipe.clear();
		
		recipe.add(KeyEvent.VK_SHIFT);
		recipe.add(KeyEvent.getExtendedKeyCodeForChar('\\'));
		readyRecipes.add(new ArrayList<Integer>(recipe));
		recipe.clear();
		
		recipe.add(KeyEvent.VK_SHIFT);
		recipe.add(KeyEvent.getExtendedKeyCodeForChar(','));
		readyRecipes.add(new ArrayList<Integer>(recipe));
		recipe.clear();
		
		recipe.add(KeyEvent.VK_SHIFT);
		recipe.add(KeyEvent.getExtendedKeyCodeForChar('.'));
		readyRecipes.add(new ArrayList<Integer>(recipe));
		recipe.clear();
		
		recipe.add(KeyEvent.VK_SHIFT);
		recipe.add(KeyEvent.getExtendedKeyCodeForChar('/'));
		readyRecipes.add(new ArrayList<Integer>(recipe));
		recipe.clear();
		
		//System.out.println(readyRecipes);
		
		return readyRecipes;
		
	}

	public ArrayList<Integer> getCombinationFor(Character ch)
	{
		//System.out.println(specials.get(ch));
		return isASpecialCharacter(ch) ? specials.get(ch) : null;
	}

	public boolean isASpecialCharacter(Character ch) {
		return specials.containsKey(ch);
	}
	
}
