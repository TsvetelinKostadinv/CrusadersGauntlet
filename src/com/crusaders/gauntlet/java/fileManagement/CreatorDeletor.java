package com.crusaders.gauntlet.java.fileManagement;

import java.io.File;
import java.io.IOException;

public class CreatorDeletor  implements FileCreatorDeletor{
	
	@Override
	public void createFile(File file, String path) {
		File dir = new File(path);
		if(!dir.isDirectory())
		{
			createDirectory(path);
		}
		
		if(!file.exists())
		{
			try {
				if(file.createNewFile())
				{
					System.out.println("Succesfully crated the file");
				}
			} catch (IOException e) {
				System.out.println("We are here");
				e.printStackTrace();
				e.getMessage();
			}
		}
		dir = null;
    }
	
	@Override
	public void createDirectory(String directoryPath) {
		System.out.println("Creating dir");
		File dir = new File(directoryPath);
		dir.mkdirs();
		dir = null;
	}
	
	
    @Override
    public void delete(String name, String path) {

    }
    
}
