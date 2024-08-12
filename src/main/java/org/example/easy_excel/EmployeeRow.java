package org.example.easy_excel;

import java.util.Date;

import com.alibaba.excel.annotation.ExcelProperty;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class EmployeeRow {
    @ExcelProperty(index=1)
    private String NSS;

    @ExcelProperty(index=3)
    private String name;

    @ExcelProperty(index = 5)
    private Date startedDate;

    @ExcelProperty(index = 6)
    private Date endDate;
}