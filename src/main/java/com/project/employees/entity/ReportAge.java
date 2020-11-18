package com.project.employees.entity;

public class ReportAge {

    private Employee younger;
    private Employee older;
    private String average;

    public ReportAge(Employee younger, Employee older, String average) {
        this.younger = younger;
        this.older = older;
        this.average = average;
    }

    

    public Employee getYounger() {
        return younger;
    }

    public void setYounger(Employee younger) {
        this.younger = younger;
    }

    public Employee getOlder() {
        return older;
    }

    public void setOlder(Employee older) {
        this.older = older;
    }

    public String getAverage() {
        return average;
    }

    public void setAverage(String average) {
        this.average = average;
    }


    

}