package com.synergisticit.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.synergisticit.domain.Employee;
import com.synergisticit.domain.EmployeeType;
import com.synergisticit.domain.Gender;
import com.synergisticit.service.EmployeeService;
import com.synergisticit.validation.EmployeeValidator;

import jakarta.validation.Valid;

@Controller
public class EmployeeController {
	
	@Autowired EmployeeService  employeeService;
	@Autowired EmployeeValidator employeeValidator;
	
	@RequestMapping("employeeForm")
	public ModelAndView employeeForm(Employee e, ModelMap m) {
		/*
		Changes made to show that Lombok is working.
		e.setName(null);
		e.getDob();
		e.toString();
		e = new Employee();
		e = new Employee(1, "Dinesh", "instructor", 15000);
		*/
		ModelAndView mav = new ModelAndView();
		mav.setViewName("xForm");
		mav.addObject(getModel(m));
		return mav;
	}
	
	
	
	@RequestMapping("saveEmployee")
	public String saveEmployee(@Valid @ModelAttribute Employee e, BindingResult br, ModelMap model
			) {
		employeeValidator.validate(e, br);
		if(br.hasFieldErrors()) {
			System.out.println("FieldErrors: "+br.hasFieldErrors());
			getModel(model);
			return "xForm";
		}else {
			employeeService.save(e);
			getModel(model);
			return "redirect:employeeForm";
		}
		
	}
	
	
	
	@RequestMapping("update")
	public String updateEmployee(Employee emp, ModelMap m) {
		Employee e = employeeService.findById(emp.getEmpId());
		System.out.println("Update()-e:"+e);
		
		m.addAttribute("e", e);
		m.addAttribute("rGender", e.getGender());
		m.addAttribute("rSkills", e.getSkills());
		m.addAttribute("rSpokenLanguages", e.getSpokenLanguages());
		m.addAttribute("rHobbies",  Arrays.asList(e.getHobbies()) );
		m.addAttribute("rEmployeeType", e.getEmployeeType());
		m.addAttribute("rInsured", e.isInsured());
		
		getModel(m);
		return "xForm";
	}
	
	
	@RequestMapping("delete")
	public String deleteEmployee(Employee emp,  ModelMap model) {
		employeeService.deleteById(emp.getEmpId());
		getModel(model);
		return "xForm";
	}
	
	private ModelMap getModel(ModelMap m) {	
		List<String> skills  = new ArrayList<>();
		skills.add("Java");
		skills.add("MySQL");
		skills.add("Hibernate");
		
		List<String> spokenLanguages = new ArrayList<>();
		spokenLanguages.add("English");
		spokenLanguages.add("French");
		spokenLanguages.add("German");
		spokenLanguages.add("Hindi");
		spokenLanguages.add("Chinese");
		spokenLanguages.add("Others");
		
		String[] hobbies = new String[] {"Swimming", "Football", "Volleyball"};
		
		m.addAttribute("employees",  employeeService.findAll())
		.addAttribute("skills", skills)
		.addAttribute("genders", Arrays.asList(Gender.values()))
		.addAttribute("spokenLanguages", spokenLanguages)
		.addAttribute("hobbies", hobbies)
		.addAttribute("employeeType", Arrays.asList(EmployeeType.values()));
		
		return m;
	}
}
