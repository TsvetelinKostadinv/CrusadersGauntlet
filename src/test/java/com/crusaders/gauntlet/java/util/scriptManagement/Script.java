package com.crusaders.gauntlet.java.util.scriptManagement;

import java.io.File;

public class Script
{
    private File fileScript;
    
    public Script(File fileScript)
    {
        if(fileScript == null)
        {
            throw new IllegalArgumentException("The file assigned should not be null");
        }else if(!fileScript.exists())
        {
            throw new IllegalArgumentException("The file assigned should exist");
        }else if(!fileScript.isDirectory())
        {
            throw new IllegalArgumentException("The file assigned should be a file not a directory");
        }
        this.fileScript = fileScript;
    }
    
    public File getScript()
    {
        return fileScript;
    }
    
    public void setScript(File fileScript)
    {
        if(fileScript == null)
        {
            throw new IllegalArgumentException("The file assigned should not be null");
        }else if(!fileScript.exists())
        {
            throw new IllegalArgumentException("The file assigned should exist");
        }else if(!fileScript.isDirectory())
        {
            throw new IllegalArgumentException("The file assigned should be a file not a directory");
        }
        this.fileScript = fileScript;
    }
}
