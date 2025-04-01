package com.synergisticit.validation;

import java.time.LocalDate;
import java.time.Period;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.SpringConstraintValidatorFactory;

import com.synergisticit.domain.Employee;

import io.micrometer.common.util.StringUtils;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.ValidatorFactory;


@Component
public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Employee.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Employee e = (Employee)target;
		
		if(e.getSalary() <15000) {
			errors.rejectValue("salary", "e.salary.min", "Salary can not be less than 15K.");
		}
		
		if(e.getSalary() >50000) {
			errors.rejectValue("salary", "e.salary.max", "Salary can not be greater than 50K.");
		}
		
		if(e.getDob()==null) {
			errors.rejectValue("dob", "e.dob.value", "Dob is a required field.");
		}
		
		if(e.getGender()==null) {
			errors.rejectValue("gender", "e.gender.value", "Gender is a required field.");
		}
		
		if(e.getSkills().isEmpty()) {
			errors.rejectValue("skills", "e.skills.value", "Skills is a required field.");
		}
		
		if(e.getSpokenLanguages().isEmpty()) {
			errors.rejectValue("spokenLanguages", "e.spokenLanguages.value", "Spoken Languages is a required field.");
		}
		
		if(e.getHobbies().length<1) {
			errors.rejectValue("hobbies", "e.hobbies.value", "Hobbies is a required field.");
		}
		
		if(e.getEmployeeType()==null) {
			errors.rejectValue("employeeType", "e.employeeType.value", "EmployeeType is a required field.");
		}
		
		if(e.getEmailId().isEmpty() || e.getEmailId().isBlank()) {
			errors.rejectValue("emailId", "e.emailId.value", "EmailId is a required field.");
		}
		
		if(e.getMobileNo().isEmpty() || e.getMobileNo().isBlank()) {
			errors.rejectValue("mobileNo", "e.mobileNo.value", "MobileNo is a required field.");
		}
		
		if(e.getDob()!=null) {
			Period p = Period.between(e.getDob(), LocalDate.now());
			if(p.getYears()<21) {
				errors.rejectValue("dob", "e.age.value", "Your age is less than 21 years.");
			}
		}
		
		if(e.getName().length()<2) {
			errors.rejectValue("name", "e.name.length", "Name should not be less that 2 characters.");
		}
		
		if(e.getMobileNo().length()<10 || e.getMobileNo().length()>10) {
			errors.rejectValue("mobileNo", "e.mobileNo.length", 
					"\""+e.getMobileNo() + "\" has length "+ e.getMobileNo().length() +". MobileNo should be 10 characters.");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "empId", "e.empId.value",  "empId should not be blank.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "e.name.value",  "Name should not be blank.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "designation", "e.designation.value",  "designation should not be blank.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "salary", "e.salary.min",  "salary should not be blank.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "salary", "e.salary.max",  "salary should not be blank.");
		
		if(StringUtils.isEmpty(e.getName())) {
			errors.rejectValue("name", "e.name.value", "Name should not be empty.");	
		}
		
		System.out.println("Jakarta Validation Errors: ");
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		jakarta.validation.Validator validator = factory.getValidator();
		Set<ConstraintViolation<Employee>> violations = validator.validate(e);
		for(ConstraintViolation<Employee> violation : violations) {
			System.out.println(violation.getMessage() +" - invalid Value:"+ violation.getInvalidValue());
		}
		
	}

}
