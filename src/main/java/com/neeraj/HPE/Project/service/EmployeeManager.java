package com.neeraj.HPE.Project.service;

import com.neeraj.HPE.Project.model.Employee;
import com.neeraj.HPE.Project.repo.Employees;

import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class EmployeeManager {
    private final Employees employees;

    @Autowired
    public EmployeeManager(Employees employees) {
        this.employees = employees;
    }

    public List<Employee> getAllEmployees() {
        return employees.findAll();
    }

    public Optional<Employee> getEmployeeById(int employeeId) {
        return employees.findById(employeeId);
    }

    public Employee addEmployee(Employee employee) {
        return employees.save(employee);
    }

    public void deleteEmployee(int employeeId) {
        employees.deleteById(employeeId);
    }

}