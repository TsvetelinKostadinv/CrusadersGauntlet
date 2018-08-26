package com.crusaders.gauntlet.java.util;

/**
 * 
 * A reference enum for frequently used values throughout the code
 * 
 * @author Tsvetelin
 *
 */
public enum Reference{
    
    ;  // this is here because Java requires the values in the enum to be the very first thing you define
    
    /**
     * 
     * The values in this enum are associated with <code>Scripts</code>
     * 
     * @author Tsvetelin
     *
     */
    public static enum ScriptInfo
    {
        DEFAULT_FILE_DRECTORY ("C:/CrusadersGauntlet/"),
        DEFAULT_NAME ("ActionOfMacro");
        
        private String value = null;
        
        private ScriptInfo(String value) { this.value = value; }
        
        public String getValue() { return value; }
    }
    
    /**
     * 
     * The values in this enum are associated with Characters and String literals which should be globally accessible
     * 
     * @author Tsvetelin
     *
     */
    public static enum CrusadersGauntletSpecialSymbols
    {
        DATA_SEPARATION_SYMBOL ( "|" ),
        DATA_TERMINATION_SYMBOL ( "#" );
        
        private String value = null;
        
        private CrusadersGauntletSpecialSymbols(String value) { this.value = value; }
        
        public String getValue() { return value; }
    }
    
    /**
     * 
     * The values in this enum are associated with the receiving of data from the Gauntlet and it's default states
     * 
     * @author Tsvetelin
     *
     */
    public static enum DataTransmissionInfo
    {
        DATA_TRANSMISSION_TEMPLATE ("XXXXX|YYYYY|ZZZZ|BTN_1_PUSHED|BTN_2_PUSHED|BTN_3_PUSHED|BTN_4_PUSHED|#");
        
        private String value = null;
        
        private DataTransmissionInfo(String value) { this.value = value; }
        
        public String getValue() { return value; }
    }    
    
}
