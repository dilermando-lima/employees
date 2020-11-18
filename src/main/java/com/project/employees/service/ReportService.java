package com.project.employees.service;

import java.util.List;

import com.project.employees.core.handle.ApiReturnException;
import com.project.employees.entity.Employee;
import com.project.employees.entity.ReportAge;
import com.project.employees.entity.ReportSalary;
import com.project.employees.repository.EmployeesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ReportService extends ReportAux {

    @Autowired
    private EmployeesRepository repository;

    public ReportAge employeesAge() throws ApiReturnException {

        List<Employee> youngerListEmployee = repository.selectOneByPageable(PageRequest.of(0, 1, Sort.by(Sort.Direction.DESC, "birthDate")));
        List<Employee> olderListEmployee = repository.selectOneByPageable(PageRequest.of(0, 1, Sort.by(Sort.Direction.ASC, "birthDate")));

        return new ReportAge( 
                        getFirstEmployeeFromList(youngerListEmployee), 
                        getFirstEmployeeFromList(olderListEmployee), 
                        getAverageSalaryFromEmployees(youngerListEmployee, olderListEmployee));
    }

    public ReportSalary employeesSalary() throws ApiReturnException {

        List<Employee> lowestListEmployee = repository.selectOneByPageable(PageRequest.of(0, 1, Sort.by(Sort.Direction.ASC, "salary")));
        List<Employee> highestListEmployee = repository.selectOneByPageable(PageRequest.of(0, 1, Sort.by(Sort.Direction.DESC, "salary")));


        return new ReportSalary(
                        getFirstEmployeeFromList(lowestListEmployee), 
                        getFirstEmployeeFromList(highestListEmployee),  
                        getAverageSalaryFromEmployees(lowestListEmployee, highestListEmployee));

    }

}
