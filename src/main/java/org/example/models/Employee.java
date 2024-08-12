package org.example.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {

    private String NSS;
    private String fullname;
    private List<Date> startedDates;
    private List<Date> endDates;

    public Employee() {
        this.startedDates = new ArrayList<>();
        this.endDates = new ArrayList<>();
    }
}