package org.example.easy_excel;

import java.util.List;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;

public class CustomExcelWriter<T> {
    private WriteSheet writeSheet;
    private ExcelWriter writer;
    private boolean fileClosed = false;
    private int batchCount = 0;

    public void write(T t) {
        if (fileClosed) {
            writer
        }
        // Write the data row by row or in small batches to minimize memory usage
        writer.write(List.of(t) , writeSheet);

        // Increment the batch count and flush periodically
        batchCount++;
        if (batchCount % 100 == 0) { // Adjust batch size as needed
            writer.finish();
            fileClosed = true;
        }
    }

    public void initWriter(ExcelWriter writer, WriteSheet writeSheet) {
        this.writer = writer;
        this.writeSheet = writeSheet;
    }

    public void finish() {
        writer.finish();
    }
}