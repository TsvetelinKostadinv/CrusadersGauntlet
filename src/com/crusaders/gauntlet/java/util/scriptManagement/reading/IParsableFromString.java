package com.crusaders.gauntlet.java.util.scriptManagement.reading;


public interface IParsableFromString<T extends IParsableFromString<T>>
{
    public T parse(String str);
}
