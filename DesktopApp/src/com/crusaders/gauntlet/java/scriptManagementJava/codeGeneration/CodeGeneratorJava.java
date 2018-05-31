package com.crusaders.gauntlet.java.scriptManagementJava.codeGeneration;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import com.crusaders.gauntlet.java.models.SpecialCharactersHandler;

public class CodeGeneratorJava{
	
	public static final String separator = "|";
	
	private StringBuilder code;
	private SpecialCharactersHandler specialHandler;
	
	public CodeGeneratorJava() 
	{
		initDependecies();
	}
	
	private void initDependecies() {
		code = new StringBuilder();
		specialHandler = SpecialCharactersHandler.getInstance();
	}
	
	public String getCode()
	{
		return code.toString();
	}
	
	public void insertKeys(String code)
	{
		Character[] chars = new Character[code.length()];
		for (int i = 0; i < chars.length; i++) {
			chars[i] = code.charAt(i);
		}
		
		for (int i = 0; i < chars.length; i++) {
			//System.out.println(chars[i]);
			//System.out.println(specialHandler.isASpecialCharacter(chars[i]));
			
			if(specialHandler.isASpecialCharacter(chars[i]))
			{ 
				ArrayList<Integer> combination = specialHandler.getCombinationFor(chars[i]);
				//System.out.println(combination.toString());
				insertArrayList(combination);
				combination = null;
				continue;
			}
			if(Character.isSpaceChar(chars[i])){ insertSpaceCode(); continue; }
			if(Character.isLetterOrDigit(chars[i])){ insertLetterOrDigit(chars[i]);continue; }
		}
		chars = null;
	}
	
	private void insertArrayList(ArrayList<Integer> combination) {
		for(Integer i : combination)
		{
			code.append(i+separator);
		}
		
	}

	private void insertSpaceCode() {
		this.code.append(KeyEvent.VK_SPACE+separator);
		
	}

	private void insertLetterOrDigit(Character character) {
		int extendedKeyCode=0;
		if(Character.isLowerCase(character)){
			extendedKeyCode = KeyEvent.getExtendedKeyCodeForChar(character);
			this.code.append(extendedKeyCode+separator);
		}else{
			extendedKeyCode = KeyEvent.getExtendedKeyCodeForChar(character);
			
			this.code.append(KeyEvent.VK_SHIFT+separator+extendedKeyCode+separator+KeyEvent.VK_SHIFT+separator);
		}
	}
	
	public void insertLeftClick()
	{
		code.append(KeyEvent.BUTTON1_DOWN_MASK + separator);
	}

	public void insertRightClick()
	{
		code.append(KeyEvent.BUTTON2_DOWN_MASK + separator);
	}
	
	public void insertMiddleClick()
	{
		code.append(KeyEvent.BUTTON3_DOWN_MASK + separator);
	}
	
	
	public void clearCode()
	{
		this.code = new StringBuilder();
	}
	
}
