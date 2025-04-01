package com.synergisticit.service;

import java.util.List;

import com.synergisticit.domain.Employee;

public interface EmployeeService {
   public Employee save(Employee e);
   public Employee findById(int empId);
   public List<Employee> findAll();
   public Employee UpdateById(int empId);
   public void deleteById(int empId);
   
   
}
