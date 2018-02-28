package com.crusaders.gauntlet.java.codeGenerationJava;

import java.awt.event.KeyEvent;

public class CodeGeneratorJava{
	
	public static final String separator = "|";
	
	private StringBuilder code;
	
	public CodeGeneratorJava() 
	{
		initDependecies();
	}
	
	private void initDependecies() {
		code = new StringBuilder();
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
		int extendedKeyCode=0;
		for (int i = 0; i < chars.length; i++) {
			System.out.println(chars[i]);
			if(Character.isLowerCase(chars[i])){
				extendedKeyCode = KeyEvent.getExtendedKeyCodeForChar(chars[i]);
				this.code.append(extendedKeyCode+separator);
			}else{
				extendedKeyCode = KeyEvent.getExtendedKeyCodeForChar(chars[i]);
				
				this.code.append(KeyEvent.VK_SHIFT+separator+extendedKeyCode+separator+KeyEvent.VK_SHIFT+separator);
			}
		}
	}
	
	public void clearCode()
	{
		this.code = new StringBuilder();
	}
	
	public static void main(String[] args)
	{
		System.out.println(KeyEvent.getExtendedKeyCodeForChar('a'));
		System.out.println(KeyEvent.getExtendedKeyCodeForChar('A'));
	}
}
