package com.synergisticit.actuator.custom;

import com.synergisticit.domain.Employee;
import com.synergisticit.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Endpoint(id = "employee")
public class CustomerEndPoint{

    @Autowired
    EmployeeRepository employeeRepository;

    @ReadOperation
    public ResponseEntity<List<Employee>> findALlEmployees(){

        return new ResponseEntity<List<Employee>>(employeeRepository.findAll(), HttpStatus.OK);
    }

    @ReadOperation
    public ResponseEntity<Employee> findByNameAndId(@Selector String name, @Selector int empId) {
        return new ResponseEntity<Employee>(employeeRepository.findById(empId).get(), HttpStatus.OK);
    }

    @ReadOperation
    public ResponseEntity<Employee> findById(@Selector int empId) {
        return new ResponseEntity<Employee>(employeeRepository.findById(empId).get(), HttpStatus.OK);
    }

//    @ReadOperation
//    public ResponseEntity<List<Employee>> findByName(@Selector String name) {
//        return new ResponseEntity<List<Employee>>(employeeRepository.findByName(name), HttpStatus.OK);
//    }

    @DeleteOperation
    public void deleteEmployeeById(@Selector int empId){
        employeeRepository.deleteByEmpId(empId);
    }


}
