package org.example.easy_excel;

import com.alibaba.excel.context.AnalysisContext;
import org.example.models.Employee;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;

public class ProcessorHandler {
    private boolean reading = false;
    private Employee currentEmployee;
    private final CustomExcelWriter<Employee> writer;

    public ProcessorHandler () {
        this.writer = new CustomExcelWriter<>();
    }

    public void setWriter(ExcelWriter writer, WriteSheet writeSheet) {
        this.writer.initWriter(writer, writeSheet);
    }

    public void handle(EmployeeRow row, AnalysisContext rowContext) {
        boolean newEmployeeFound = row.getName() != null;
        if (newEmployeeFound) {
            if (currentEmployee != null) {
                System.out.println("Writting index: " + rowContext.readRowHolder().getRowIndex());
                process(currentEmployee);
            }
            initEmployee(row);
            reading = true;
        }

        if (!newEmployeeFound && reading) {
            currentEmployee.getStartedDates().add(row.getStartedDate());
            currentEmployee.getEndDates().add(row.getEndDate());
        }
    } 

    public void initEmployee(EmployeeRow row) {
        currentEmployee = new Employee();
        currentEmployee.setFullname(row.getName());
        currentEmployee.getStartedDates().add(row.getStartedDate());
        currentEmployee.getEndDates().add(row.getEndDate());
    }

    public void finish() {
        process(currentEmployee);
    }

    private void process(Employee employee){
        System.out.println("Empleado: " + employee.getFullname());       
        // employee.getStartedDates().forEach(System.out::println);
        
        try {
            write(employee);
        } catch (Exception err) {
           err.printStackTrace();
        }
    }

    private void write(Employee employee) {
        writer.write(employee);
    }

}