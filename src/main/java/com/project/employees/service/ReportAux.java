package com.project.employees.service;

import java.util.List;

import com.project.employees.entity.Employee;

abstract class ReportAux {
    
    public Employee getFirstEmployeeFromList(List<Employee> listEmployee){
        if( listEmployee == null ||  listEmployee.isEmpty() )
            return null;
        else
            return listEmployee.get(0);
    }



    public String getAverageSalaryFromEmployees(List<Employee>  empList1,List<Employee>  empList2 ){

        Employee emp1 = getFirstEmployeeFromList(empList1);
        Employee emp2 = getFirstEmployeeFromList(empList2);

        /* =============== if both are null return null =============================*/
        if( ( emp1 == null || emp1.getSalary() == null ) &&  (  emp2 == null || emp2.getSalary() == null ) )
             return null;
        /* =============== if younger are null wil return older =============================*/
        else if(  emp1.getSalary()  == null )
             return emp2.getSalary();
        /* =============== if older are null wil return younger =============================*/
        else if(  emp2.getSalary()  == null )
             return emp2.getSalary();
        /* =============== if both have values will be made the mean  =============================*/
        else
            return String.valueOf(  ( Float.parseFloat(emp1.getSalary()) +  Float.parseFloat(emp2.getSalary()) ) / 2 );

    }



}
