package com.employee.repository;

import com.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByDepartmentIgnoreCase(String department);

    List<Employee> findByLastNameContainingIgnoreCase(String lastName);

    List<Employee> findByFirstNameContainingIgnoreCase(String firstName);
}

