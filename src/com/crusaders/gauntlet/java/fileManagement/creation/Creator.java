package com.crusaders.gauntlet.java.fileManagement.creation;

import java.io.File;
import java.io.IOException;

public class Creator  implements IFileCreator
{

	@Override
	public void createDirectory(File dir) 
	{
		if(!dir.exists())  dir.mkdirs();
		
	}

	@Override
	public void createDirectory(String directoryPath) 
	{
		File dir = new File( directoryPath );
		createDirectory( dir );
		
	}

	@Override
	public void createFile(File file) throws IOException 
	{
	    createDirectory( file.getParent() );
	    
		if(!file.exists())
		{
		    file.createNewFile();
		}
		
	}

    @Override
	public void createFile(String path) throws IOException 
	{
		File file = new File( path );
		createFile( file );
		
	}
    
}
