package com.synergisticit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synergisticit.dao.EmployeeRepository;
import com.synergisticit.domain.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
   
	@Autowired EmployeeRepository employeeRepository;
	
	@Override
	public Employee save(Employee e) {
		return employeeRepository.save(e);
	}

	@Override
	public Employee findById(int empId) {
		Optional<Employee> optEmployee = employeeRepository.findById(empId);
		if(optEmployee.isPresent()) {
			return optEmployee.get();
		}else {
			return null;
		}
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee UpdateById(int empId) {
		
		return null;
	}

	@Override
	public void deleteById(int empId) {
		employeeRepository.deleteById(empId);

	}

}
