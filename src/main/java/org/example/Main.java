package org.example;

import org.example.processor.IExcelProcessor;
import org.example.processor.ExcelProcessor;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!\n");

        final String filepath = "";
        IExcelProcessor processor = new ExcelProcessor();
        processor.process("filenamessd");
    }
}