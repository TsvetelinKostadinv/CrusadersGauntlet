package com.crusaders.gauntlet.java.fileManagement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Reader implements FileReader{

	@Override
	public String readFile(File file) {
		
		StringBuilder lines = new StringBuilder();
		
		try {
			BufferedReader reader = new BufferedReader(new java.io.FileReader(file));
			
			String line = reader.readLine();
			
			while(line!=null){
				lines.append(line);
				line = reader.readLine();
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lines.toString();
	}

}
