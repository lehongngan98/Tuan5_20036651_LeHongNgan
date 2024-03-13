package com.se.employeeservice.repository;

import com.se.employeeservice.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {
    private List<Employee> employees = new ArrayList<>();

    public Employee addEmployee(Employee employee) {
        employees.add(employee);
        return employee;
    }

    public List<Employee> findAll() {
        return employees;
    }

    public Employee findById(Long id) {
        return employees.stream().filter(it -> it.id().equals(id)).findFirst().orElseThrow();
    }

    public List<Employee> findByDepartment(Long departmentId) {
        return employees.stream().filter(it -> it.departmentId().equals(departmentId)).toList();
    }
}
