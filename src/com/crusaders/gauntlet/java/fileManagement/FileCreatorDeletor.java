package com.crusaders.gauntlet.java.fileManagement;

import java.io.File;

public interface FileCreatorDeletor {
    void delete (String name, String path);
    void createDirectory(String directoryPath);
	void createFile(File file, String dirPath);
}
