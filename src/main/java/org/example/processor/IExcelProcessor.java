package org.example.processor;

import java.io.File;

public interface IExcelProcessor {
    void process(File file, File outputFile);
}