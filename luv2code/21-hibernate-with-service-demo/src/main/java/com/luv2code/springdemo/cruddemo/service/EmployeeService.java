package com.luv2code.springdemo.cruddemo.service;

import com.luv2code.springdemo.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> findAll();

    public Employee findById(int id);

    public void save(Employee employee);

    public void deleteById(int id);
}
