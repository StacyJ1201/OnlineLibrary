package com.synergisticit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.synergisticit.dao.RoleRepository;
import com.synergisticit.domain.Role;
import com.synergisticit.service.RoleService;

import org.springframework.http.ResponseEntity;

@Controller
public class RoleController {

	@Autowired RoleService roleService;
	@RequestMapping("role/save")
	ResponseEntity<Role> createRole(@RequestParam String roleName){
		
		Role role = new Role(roleName);
		Role savedRole = roleService.save(role);
		return new ResponseEntity<Role>(savedRole, HttpStatus.OK);
	}
}
