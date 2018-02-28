package com.crusaders.gauntlet.java.fileManagement;

import java.io.File;

public interface FileWriter {
    void assignFile(File file);
    void writeToFile(String str);
}
