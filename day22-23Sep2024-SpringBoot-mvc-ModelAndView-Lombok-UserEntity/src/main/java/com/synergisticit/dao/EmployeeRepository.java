package com.synergisticit.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synergisticit.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
