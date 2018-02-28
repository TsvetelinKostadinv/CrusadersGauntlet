package com.crusaders.gauntlet.java.models;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;

public class SpecialCharactersHandler {
	
	private HashMap<Character, ArrayList<Integer>> specials;
	
	private static SpecialCharactersHandler instance = null;
	
	private SpecialCharactersHandler()
	{
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
		recipe.add(KeyEvent.VK_SHIFT);
		readyRecipes.add(new ArrayList<Integer>(recipe));
		recipe.clear();
		
		
		recipe.add(KeyEvent.VK_SHIFT);
		recipe.add(KeyEvent.getExtendedKeyCodeForChar('1'));
		recipe.add(KeyEvent.VK_SHIFT);
		readyRecipes.add(new ArrayList<Integer>(recipe));
		recipe.clear();
		
		recipe.add(KeyEvent.VK_SHIFT);
		recipe.add(KeyEvent.getExtendedKeyCodeForChar('2'));recipe.add(KeyEvent.VK_SHIFT);
		readyRecipes.add(new ArrayList<Integer>(recipe));
		recipe.clear();
		
		recipe.add(KeyEvent.VK_SHIFT);
		recipe.add(KeyEvent.getExtendedKeyCodeForChar('3'));recipe.add(KeyEvent.VK_SHIFT);
		readyRecipes.add(new ArrayList<Integer>(recipe));
		recipe.clear();
		
		recipe.add(KeyEvent.VK_SHIFT);
		recipe.add(KeyEvent.getExtendedKeyCodeForChar('4'));recipe.add(KeyEvent.VK_SHIFT);
		readyRecipes.add(new ArrayList<Integer>(recipe));
		recipe.clear();
		
		recipe.add(KeyEvent.VK_SHIFT);
		recipe.add(KeyEvent.getExtendedKeyCodeForChar('5'));recipe.add(KeyEvent.VK_SHIFT);
		readyRecipes.add(new ArrayList<Integer>(recipe));
		recipe.clear();
		
		recipe.add(KeyEvent.VK_SHIFT);
		recipe.add(KeyEvent.getExtendedKeyCodeForChar('6'));recipe.add(KeyEvent.VK_SHIFT);
		readyRecipes.add(new ArrayList<Integer>(recipe));
		recipe.clear();
		
		recipe.add(KeyEvent.VK_SHIFT);
		recipe.add(KeyEvent.getExtendedKeyCodeForChar('7'));recipe.add(KeyEvent.VK_SHIFT);
		readyRecipes.add(new ArrayList<Integer>(recipe));
		recipe.clear();
		
		recipe.add(KeyEvent.VK_SHIFT);
		recipe.add(KeyEvent.getExtendedKeyCodeForChar('8'));recipe.add(KeyEvent.VK_SHIFT);
		readyRecipes.add(new ArrayList<Integer>(recipe));
		recipe.clear();
		
		recipe.add(KeyEvent.VK_SHIFT);
		recipe.add(KeyEvent.getExtendedKeyCodeForChar('9'));recipe.add(KeyEvent.VK_SHIFT);
		readyRecipes.add(new ArrayList<Integer>(recipe));
		recipe.clear();
		
		recipe.add(KeyEvent.VK_SHIFT);
		recipe.add(KeyEvent.getExtendedKeyCodeForChar('0'));recipe.add(KeyEvent.VK_SHIFT);
		readyRecipes.add(new ArrayList<Integer>(recipe));
		recipe.clear();
		
		recipe.add(KeyEvent.VK_SHIFT);
		recipe.add(KeyEvent.getExtendedKeyCodeForChar('-'));recipe.add(KeyEvent.VK_SHIFT);
		readyRecipes.add(new ArrayList<Integer>(recipe));
		recipe.clear();
		
		recipe.add(KeyEvent.VK_SHIFT);
		recipe.add(KeyEvent.getExtendedKeyCodeForChar('='));recipe.add(KeyEvent.VK_SHIFT);
		readyRecipes.add(new ArrayList<Integer>(recipe));
		recipe.clear();
		
		recipe.add(KeyEvent.VK_SHIFT);
		recipe.add(KeyEvent.getExtendedKeyCodeForChar('['));recipe.add(KeyEvent.VK_SHIFT);
		readyRecipes.add(new ArrayList<Integer>(recipe));
		recipe.clear();
		
		recipe.add(KeyEvent.VK_SHIFT);
		recipe.add(KeyEvent.getExtendedKeyCodeForChar(']'));recipe.add(KeyEvent.VK_SHIFT);
		readyRecipes.add(new ArrayList<Integer>(recipe));
		recipe.clear();
		
		recipe.add(KeyEvent.VK_SHIFT);
		recipe.add(KeyEvent.getExtendedKeyCodeForChar(';'));recipe.add(KeyEvent.VK_SHIFT);
		readyRecipes.add(new ArrayList<Integer>(recipe));
		recipe.clear();
		
		recipe.add(KeyEvent.VK_SHIFT);
		recipe.add(KeyEvent.getExtendedKeyCodeForChar('\''));recipe.add(KeyEvent.VK_SHIFT);
		readyRecipes.add(new ArrayList<Integer>(recipe));
		recipe.clear();
		
		recipe.add(KeyEvent.VK_SHIFT);
		recipe.add(KeyEvent.getExtendedKeyCodeForChar('\\'));recipe.add(KeyEvent.VK_SHIFT);
		readyRecipes.add(new ArrayList<Integer>(recipe));
		recipe.clear();
		
		recipe.add(KeyEvent.VK_SHIFT);
		recipe.add(KeyEvent.getExtendedKeyCodeForChar(','));recipe.add(KeyEvent.VK_SHIFT);
		readyRecipes.add(new ArrayList<Integer>(recipe));
		recipe.clear();
		
		recipe.add(KeyEvent.VK_SHIFT);
		recipe.add(KeyEvent.getExtendedKeyCodeForChar('.'));recipe.add(KeyEvent.VK_SHIFT);
		readyRecipes.add(new ArrayList<Integer>(recipe));
		recipe.clear();
		
		recipe.add(KeyEvent.VK_SHIFT);
		recipe.add(KeyEvent.getExtendedKeyCodeForChar('/'));recipe.add(KeyEvent.VK_SHIFT);
		readyRecipes.add(new ArrayList<Integer>(recipe));
		recipe.clear();
		
		
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
