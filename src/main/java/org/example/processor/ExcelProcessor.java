package org.example.processor;

import java.io.File;
import java.io.FileOutputStream;


import org.example.easy_excel.EmployeeRow;
import org.example.easy_excel.ExcelListener;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;

public class ExcelProcessor implements IExcelProcessor {
    private final ExcelListener excelListener;

    public ExcelProcessor() {
        this.excelListener = new ExcelListener();
    }

    @Override 
    public void process(File file, File outputFile) {
        System.out.println(file);
        try (ExcelWriter writer = EasyExcel.write(new FileOutputStream(outputFile), EmployeeRow.class).build()) {
            WriteSheet writeSheet = EasyExcel.writerSheet(0).build();
            excelListener.setWriter(writer, writeSheet);
            EasyExcel.read(file, EmployeeRow.class, excelListener).sheet(2).doRead();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}