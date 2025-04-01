package com.synergisticit.actuator.custom;

import com.synergisticit.domain.Customer;
import com.synergisticit.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Endpoint(id = "customer")
public class CustomerEndPoint{

    @Autowired
    CustomerRepository customerRepository;

    @ReadOperation
    public ResponseEntity<List<Customer>> findALlCustomers(){

        return new ResponseEntity<List<Customer>>(customerRepository.findAll(), HttpStatus.OK);
    }


}
