package org.example;

import org.example.processor.IExcelProcessor;
import org.example.processor.ExcelProcessor;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!\n");

        final File file = new File("./resources/inputs/movimientos de obra 2023.xls");
        final File output = new File("./resources/outputs/movimientos de obra 2023.xls");
        try {
            if (!output.exists()) output.createNewFile();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        IExcelProcessor processor = new ExcelProcessor();
        processor.process(file, output);
    }
}