package com.synergisticit.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.synergisticit.domain.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	NamedParameterJdbcTemplate nPJT;
	
	@Override
	public Employee save(Employee e) {
		String sql = "insert into employee(empId, name, designation, salary) " +
				"values(:empId, :name, :designation, :salary)";
		MapSqlParameterSource msp = new MapSqlParameterSource();
		msp.addValue("empId", e.getEmpId());
		msp.addValue("name", e.getName());
		msp.addValue("designation", e.getDesignation());
		msp.addValue("salary", e.getSalary());
		int rowsAffected =  nPJT.update(sql, msp);
		if(rowsAffected == 1){
			System.out.println("employee records saved: " + rowsAffected);
		} else {
			System.out.println("Problem in saving employee Record");
		}
		return e;
	}

	@Override
	public Employee findById(int empId) {
		String sql = "select * from employee where empId=:empId";
		Map<String, Object> map = new HashMap<>();
		map.put("emp", empId);
		nPJT.queryForObject("sql", map, new BeanPropertyRowMapper<>(Employee.class));
		return null;
	}

	@Override
	public List<Employee> findAll() {
		return nPJT.query("Select * from Employee", new BeanPropertyRowMapper<>(Employee.class));
	}

	@Override
	public void update(Employee e) {

		String sql = "update employee set name=:name, salary=:salary, designation=:designation where empId=:empId";
		Map<String, Object> map = new HashMap<>();
		map.put("name", e.getName());
		map.put("salary", e.getSalary());
		map.put("designation", e.getDesignation());
		map.put("emp", e.getEmpId());
		int rowsAffected = nPJT.update("sql", map);
		if(rowsAffected == 1){
			System.out.println("employee records updated: " + rowsAffected);
		} else {
			System.out.println("Problem in updating employees");
		}

	}

	@Override
	public void deleteById(int empId) {
		String sql = "delete from employee where empId=:empId";
		Map<String, Object> map = new HashMap<>();
		map.put("emp", empId);
		int rowsAffected = nPJT.update("sql", map);
		if(rowsAffected == 1){
			System.out.println("employee records deleted: " + rowsAffected);
		} else {
			System.out.println("Problem in deleting employees");
		}
	}

}
