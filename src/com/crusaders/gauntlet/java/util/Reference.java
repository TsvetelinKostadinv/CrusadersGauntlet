package com.crusaders.gauntlet.java.util;

public enum Reference{
    
    ;  // this is here because Java requires the values in the enum to be the very first thing you define
    
    public static enum ScriptInfo
    {
        DEFAULT_FILE_DRECTORY ("C:/CrusadersGauntlet/"),
        DEFAULT_NAME ("ActionOfMacro");
        
        private String value = null;
        
        private ScriptInfo(String value) { this.value = value; }
        
        public String getValue() { return value; }
    }
    
    public static enum CrusadersGauntletSpecialSymbols
    {
        DATA_SEPARATION_SYMBOL ( "|" );
        
        private String value = null;
        
        private CrusadersGauntletSpecialSymbols(String value) { this.value = value; }
        
        public String getValue() { return value; }
    }
    
    
    
}
