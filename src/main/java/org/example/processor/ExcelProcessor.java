package org.example.processor;

public class ExcelProcessor implements IExcelProcessor {
    @Override 
    public void process(String filename) {
        System.out.println(filename);
    }
}