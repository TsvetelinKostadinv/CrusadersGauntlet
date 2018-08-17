package com.crusaders.gauntlet.java.util.fileManagement.creation;

import java.io.File;
import java.io.IOException;

public class Creator  implements IFileCreator
{

	@Override
	public File createDirectory(File dir) 
	{
		if(!dir.exists())  dir.mkdirs();
		return dir;
	}

	@Override
	public File createDirectory(String directoryPath) 
	{
		File dir = new File( directoryPath );
		createDirectory( dir );
		return dir;
	}

	@Override
	public File createFile(File file) throws IOException 
	{
	    createDirectory( file.getParent() );
	    
		if( !file.exists() ) { file.createNewFile(); }
		
		return file;
		
	}

    @Override
	public File createFile(String path) throws IOException 
	{
		File file = new File( path );
		createFile( file );
		return file;
	}
    
}
