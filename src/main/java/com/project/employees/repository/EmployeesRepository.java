package com.project.employees.repository;

import java.util.List;

import com.project.employees.entity.Employee;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesRepository extends JpaRepository<Employee ,Long>,  JpaSpecificationExecutor<Employee> {

    @Query("select obj from #{#entityName} obj")
    List<Employee> selectOneByPageable(Pageable pageable );

}