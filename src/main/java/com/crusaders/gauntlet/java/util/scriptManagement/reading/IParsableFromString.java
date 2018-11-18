package com.crusaders.gauntlet.java.util.scriptManagement.reading;

@FunctionalInterface
public interface IParsableFromString<T extends IParsableFromString<T>>
{
    /**
     * 
     * Parses the given string into the object <code>T</code>
     * 
     * @param str - the provided string to be parsed
     * @return the parsed object <code>T</code>
     */
    public T parse(String str);
}
