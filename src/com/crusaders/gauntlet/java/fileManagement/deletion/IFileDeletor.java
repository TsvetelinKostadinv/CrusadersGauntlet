package com.crusaders.gauntlet.java.fileManagement.deletion;

import java.io.File;

public interface IFileDeletor
{
    void delete (File file);
    void delete (String path);
}
