package com.crusaders.gauntlet.java.fileManagement.reading;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Stream;

public class Reader implements IFileReader{

	@Override
	public String readFile(File file) throws IOException 
	{
		
		StringBuilder lines = new StringBuilder();
		
			BufferedReader reader = new BufferedReader(new FileReader(file));
			
			String line = reader.readLine();
			
			while(line!=null){
				lines.append(line);
				line = reader.readLine();
			}
			reader.close();
			reader = null;

		return lines.toString();
	}

    @Override
    public String readFile ( String path ) throws IOException 
    {
        File file = new File( path );
        return readFile( file );
    }

    @Override
    public String readLineFromFile ( File file , int line ) throws IOException 
    {
        Stream<String> allLines = Files.lines(file.toPath());
        String rowNeeded = allLines.skip(line-1).findFirst().get();
        allLines.close();
        return rowNeeded;
    }

    @Override
    public String readLineFromFile ( String path , int line ) throws IOException 
    {
        File file = new File(path);
        return readLineFromFile( file , line );


    }

}
