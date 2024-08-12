package org.example.easy_excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;

public class ExcelListener extends AnalysisEventListener<EmployeeRow> {
    private final ProcessorHandler processorHandler;

    public ExcelListener() {
        this.processorHandler = new ProcessorHandler();
    }
    
    public void setWriter(ExcelWriter writer, WriteSheet writeSheet) {
        this.processorHandler.setWriter(writer, writeSheet);
    }

    @Override
    public void invoke(EmployeeRow employee, AnalysisContext context) {
        try {
            // Your row processing logic
            processorHandler.handle(employee, context);
        } catch (Exception e) {
            // Handle specific row errors
            System.err.println("Error processing row: " + e.getMessage());
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        processorHandler.finish();
        System.out.println("All data processed with exception handling.");
    }  
}
