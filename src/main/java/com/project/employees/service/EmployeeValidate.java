package com.project.employees.service;

import com.project.employees.constants.Err;
import com.project.employees.core.handle.ApiReturnException;
import com.project.employees.entity.Employee;
import com.project.employees.utils.UtilsValidate;

import org.springframework.http.HttpStatus;

abstract class EmployeeValidate {

    protected void validateObjBeforeCreate(Employee employee) throws ApiReturnException {

        validateObjNull(employee);

        validateName(employee);

        validateEmail(employee);

        validateDepartment(employee);

        validateBirthDate(employee);

        validateSalary(employee);

    }

    protected void validateObjBeforeUpdate(Employee employee) throws ApiReturnException {

        validateObjNull(employee);

        validateIdNull(employee);

        validateName(employee);

        validateEmail(employee);

        validateDepartment(employee);

        validateBirthDate(employee);

        validateSalary(employee);

    }

    protected void validateObjIdNull(Long id) throws ApiReturnException {
        validateIdNull(id);
    }

    private void validateIdNull(Employee employee) throws ApiReturnException {
        if (employee.getId() == null)
            throw new ApiReturnException(HttpStatus.NOT_FOUND, Err.ERR_1_11);

    }

    private void validateIdNull(Long id) throws ApiReturnException {
        if (id == null)
            throw new ApiReturnException(HttpStatus.NOT_FOUND, Err.ERR_1_11);

    }

    private void validateBirthDate(Employee employee) throws ApiReturnException {
        if (employee.getBirthDate() == null)
            throw new ApiReturnException(HttpStatus.BAD_REQUEST, Err.ERR_1_7);

    }

    private void validateSalary(Employee employee) throws ApiReturnException {
        if (!UtilsValidate.isFloatValid(employee.getSalary(), false))
            throw new ApiReturnException(HttpStatus.BAD_REQUEST, Err.ERR_1_6);

    }

    private void validateDepartment(Employee employee) throws ApiReturnException {
        if (employee.getDepartment() == null)
            throw new ApiReturnException(HttpStatus.BAD_REQUEST, Err.ERR_1_5);

        if (employee.getDepartment().length() > 255)
            throw new ApiReturnException(HttpStatus.BAD_REQUEST, Err.ERR_1_10);

    }

    private void validateEmail(Employee employee) throws ApiReturnException {
        if (employee.getEmail() == null)
            throw new ApiReturnException(HttpStatus.BAD_REQUEST, Err.ERR_1_2);

        if (!UtilsValidate.isEmailValid(employee.getEmail(), false))
            throw new ApiReturnException(HttpStatus.BAD_REQUEST, Err.ERR_1_3);

        if (employee.getEmail().length() > 255)
            throw new ApiReturnException(HttpStatus.BAD_REQUEST, Err.ERR_1_9);

    }

    private void validateName(Employee employee) throws ApiReturnException {
        if (employee.getName() == null)
            throw new ApiReturnException(HttpStatus.BAD_REQUEST, Err.ERR_1_1);

        if (employee.getName().length() > 255)
            throw new ApiReturnException(HttpStatus.BAD_REQUEST, Err.ERR_1_8);
    }

    private void validateObjNull(Employee employee) throws ApiReturnException {
        if (employee == null)
            throw new ApiReturnException(HttpStatus.BAD_REQUEST, Err.ERR_1_1);
    }

}
