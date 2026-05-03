package com.employee.service;

import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public Employee getById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id " + id));
    }

    public List<Employee> searchByName(String term) {
        if (term == null || term.isBlank()) {
            return getAll();
        }
        List<Employee> byFirst = employeeRepository.findByFirstNameContainingIgnoreCase(term);
        List<Employee> byLast = employeeRepository.findByLastNameContainingIgnoreCase(term);
        // naive merge; could be improved to remove duplicates
        byLast.stream()
                .filter(e -> !byFirst.contains(e))
                .forEach(byFirst::add);
        return byFirst;
    }

    public List<Employee> byDepartment(String department) {
        if (department == null || department.isBlank()) {
            return getAll();
        }
        return employeeRepository.findByDepartmentIgnoreCase(department);
    }

    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee update(Long id, Employee data) {
        Employee existing = getById(id);
        existing.setFirstName(data.getFirstName());
        existing.setLastName(data.getLastName());
        existing.setEmail(data.getEmail());
        existing.setJobTitle(data.getJobTitle());
        existing.setDepartment(data.getDepartment());
        existing.setPhone(data.getPhone());
        existing.setLocation(data.getLocation());
        return employeeRepository.save(existing);
    }

    public void delete(Long id) {
        Employee existing = getById(id);
        employeeRepository.delete(existing);
    }
}

