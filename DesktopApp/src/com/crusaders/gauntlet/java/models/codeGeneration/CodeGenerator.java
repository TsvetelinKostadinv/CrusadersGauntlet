package com.crusaders.gauntlet.java.models.codeGeneration;

import java.util.HashMap;

public interface CodeGenerator {
    void fillLines();
    public HashMap<String, String> getDefLines();
    public String generateDefaultCode();
	public boolean exists(String command);
}
