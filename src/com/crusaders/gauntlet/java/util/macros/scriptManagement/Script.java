package com.crusaders.gauntlet.java.util.macros.scriptManagement;

import java.io.File;

public class Script
{
    private File fileScript;
    
    public Script(File fileScript)
    {
        this.fileScript = fileScript;
    }
    
    public File getScript()
    {
        return fileScript;
    }
}
