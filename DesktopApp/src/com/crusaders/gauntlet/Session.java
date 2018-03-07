package com.crusaders.gauntlet;

import java.util.HashMap;

public final class Session {

	private final HashMap<Object, Object> attributes = new HashMap<Object, Object>();
	
	private static Session instance = null;
	
	private Session(){}
	
	public static Session getInstance()
	{
		if(instance==null) instance = new Session();
		return instance;
	}
	
	public void addAttribute(Object name, Object value)
	{
		attributes.put(name, value);
	}
	
	public Object getAttribute(Object name)
	{
		return attributes.get(name);
	}
	
}
