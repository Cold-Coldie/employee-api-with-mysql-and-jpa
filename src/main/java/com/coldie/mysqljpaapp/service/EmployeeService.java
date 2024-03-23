package com.coldie.mysqljpaapp.service;

import com.coldie.mysqljpaapp.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> retrieveEmployees();

    Optional<Employee> retrieveEmployeeById(int id);

    void saveEmployee(Employee employee);

    void deleteEmployee(int id);
}
