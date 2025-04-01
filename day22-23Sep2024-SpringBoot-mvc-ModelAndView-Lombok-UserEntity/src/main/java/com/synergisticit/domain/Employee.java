package com.synergisticit.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.annotation.Order;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OrderBy;
import jakarta.persistence.OrderColumn;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Data
@NoArgsConstructor
@RequiredArgsConstructor //Required arguments are final fields and fields with constraints such as @NonNull. 
@Setter
@Getter
@ToString
@Entity //Specifies that the class is an entity, it will be mapped to a table, and its objects will become the record of the table.
public class Employee {
	
	 @NonNull
	 @Id   //Specifies the primary key of an entity. 
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
     private Integer empId;
	 
	 @NonNull
	 @NotEmpty
	 @Column(name="name")
     private String name;
	 
	 @NonNull
	 @NotEmpty
     private String designation;
     
	 @NonNull
	 @Min(value = 15000, message="Salary must be greater >= to 15000")
	 @Max(value = 50000)
     private Integer salary;
	 
	 @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
	 private LocalDate dob;
	 
	 @Enumerated(EnumType.STRING)
	 private Gender gender;
	 
	 @ElementCollection
	 private List<String> skills = new ArrayList<>();
	 
	 @ElementCollection
	 private List<String> spokenLanguages = new ArrayList<>();
	 
	 @OrderColumn
	 private String[] hobbies;
     
	 @Enumerated(EnumType.STRING)
	 private EmployeeType employeeType;
	 
	 private String emailId;
	 private String mobileNo;
	 private boolean insured;
	 
	 @Valid
	 @Embedded
	 private Address address;
	 
   /*
	public Employee(int empId, String name, String designation, int salary) {
		this.empId = empId;
		this.name = name;
		this.designation = designation;
		this.salary = salary;
	}

   */
}
