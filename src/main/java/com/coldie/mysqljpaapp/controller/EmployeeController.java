package com.coldie.mysqljpaapp.controller;

import com.coldie.mysqljpaapp.model.Employee;
import com.coldie.mysqljpaapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public List<Employee> getAllEmployees() {
        return employeeService.retrieveEmployees();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        Optional<Employee> optionalEmployee = employeeService.retrieveEmployeeById(id);

        if (optionalEmployee.isEmpty()) {
            throw new RuntimeException("Employee with id " + id + " not found.");
        } else {
            return optionalEmployee.get();
        }
    }

    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employee/{id}")
    public Employee deleteEmployee(@PathVariable int id) {
        Optional<Employee> employee = employeeService.retrieveEmployeeById(id);

        if (employee.isEmpty()) {
            throw new RuntimeException("Employee with id " + id + " not found.");
        } else {
            employeeService.deleteEmployee(id);
            return employee.get();
        }



    }
}
