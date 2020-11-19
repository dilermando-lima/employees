package com.project.employees.service;

import java.util.List;

import com.project.employees.constants.Err;
import com.project.employees.core.handle.ApiReturnException;
import com.project.employees.entity.Employee;
import com.project.employees.repository.EmployeesRepository;
import com.project.employees.utils.UtilsMethods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService extends EmployeeValidate {
    

        @Autowired
        private EmployeesRepository repository;

        public List<Employee> list() throws ApiReturnException{
            /* ======  put here some business rules and filter strategies =======*/
            return repository.findAll(); 
        }

        public Employee detail(Long id) throws ApiReturnException{

            validateObjIdNull(id);

            Employee employee = repository.selectOneById(id);
            if(  employee == null ) throw new ApiReturnException(HttpStatus.NOT_FOUND, Err.ERR_1_11);

            return employee;
        }


        public Employee create(Employee employee) throws ApiReturnException{

            validateObjBeforeCreate(employee);

            employee = repository.save(employee);

            return employee;
        }

        public Employee update(Employee employee, Long id) throws ApiReturnException{

            validateObjBeforeUpdate(employee, id);

            Employee employeeToUpdate = repository.selectOneById(id);
            if(  employeeToUpdate == null ) throw new ApiReturnException(HttpStatus.NOT_FOUND, Err.ERR_1_11);

            employee.setId(id);

            employee = repository.save(employee);

            return employee;
        }

        public Employee delete(Long id) throws ApiReturnException{

            validateObjIdNull(id);

            Employee employeeToDelete = repository.selectOneById(id);
            if(  employeeToDelete == null ) throw new ApiReturnException(HttpStatus.NOT_FOUND, Err.ERR_1_11);

            Employee objCloneToReturn = UtilsMethods.cloneObject(employeeToDelete, Employee.class );

            
            repository.delete(employeeToDelete);

            return objCloneToReturn;
        }



}
