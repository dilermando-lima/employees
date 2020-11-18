package com.project.employees.entity;

public class ReportSalary {

    private Employee lowest;
    private Employee highest;
    private String average;

    public ReportSalary(Employee lowest, Employee highest, String average) {
        this.lowest = lowest;
        this.highest = highest;
        this.average = average;
    }

  
    

    public Employee getLowest() {
        return lowest;
    }

    public void setLowest(Employee lowest) {
        this.lowest = lowest;
    }

    public Employee getHighest() {
        return highest;
    }

    public void setHighest(Employee highest) {
        this.highest = highest;
    }

    public String getAverage() {
        return average;
    }

    public void setAverage(String average) {
        this.average = average;
    }



}