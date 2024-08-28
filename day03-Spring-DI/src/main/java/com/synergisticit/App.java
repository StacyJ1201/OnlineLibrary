package com.synergisticit;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.synergisticit.domain.Address;
import com.synergisticit.domain.Employee;

public class App {
	
    public static void main( String[] args ){
    	
    	//Legacy way of creating object an setting the dependency manually usng
    	Employee  e1 = new Employee(1, "Ben", "Programmer", 15000);
        System.out.println( "e1: "+e1 );
        
        Address address = new Address();
        address.setAddressLine1("al1");
        address.setAddressLine2("al2");
        address.setCity("Washington City");
        address.setState("Washington");
        address.setCountry("USA");
        
        address.setZipCode("123456");
        e1.setAddress(address);  //dependency injection: address object being set(injected) using a setter method.
        System.out.println( "e1: "+e1 );
        
        
        Address zesangAddress = new Address();
        zesangAddress.setAddressLine1("al1");
        zesangAddress.setAddressLine2("al2");
        zesangAddress.setCity("MyCity");
        zesangAddress.setState("MyState");
        zesangAddress.setCountry("MyCountry");
        zesangAddress.setZipCode("6789123");
        
        Employee  e2 = new Employee(2, "Gesang", "Programmer", 15555, zesangAddress); //dependency injection using Constructor
        System.out.println( "e2: "+e2 );
        
        System.out.println("\n==========IoC and DI using Spring==================");
        
      //  ApplicationContext context =  new ClassPathXmlApplicationContext("beans.xml");
       AbstractApplicationContext context =  new ClassPathXmlApplicationContext("beans.xml");
        Employee  e3 = (Employee)context.getBean("e3");
        System.out.println("e3: "+e3);
        
        Employee  e4 = (Employee)context.getBean("e4");
        System.out.println("e4: "+e4);
        
        System.out.println("\n==========ApplicatonContext is contaner of beans.==================");
        System.out.println("No. of beans: "+ context.getBeanDefinitionCount());
        
        String[] beans = context.getBeanDefinitionNames();
        for(String bean : beans) {
        	System.out.println(bean);
        }
        context.close();
    }
}

/*
mysql> show databases;

mysql> create database springdb;
Query OK, 1 row affected (0.00 sec)

*/