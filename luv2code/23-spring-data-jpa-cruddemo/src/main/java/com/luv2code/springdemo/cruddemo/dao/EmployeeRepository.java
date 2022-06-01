package com.luv2code.springdemo.cruddemo.dao;

import com.luv2code.springdemo.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
