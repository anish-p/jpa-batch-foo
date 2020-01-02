package com.thoughtworks.jpabatch.rest;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static java.lang.String.format;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void createEmployees() {
        this.employeeRepository.saveAll(getEmployees());
    }

    private Iterable<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<>();
        for (int count = 0; count < 10; count++) {
            employees.add(new Employee(UUID.randomUUID().toString(), format("first-name-%d", count + 1), format("last-name-%d", count + 1)));
        }
        return employees;
    }
}
