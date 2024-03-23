package com.coldie.mysqljpaapp.service;

import com.coldie.mysqljpaapp.model.Employee;
import com.coldie.mysqljpaapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> retrieveEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> retrieveEmployeeById(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }
}
