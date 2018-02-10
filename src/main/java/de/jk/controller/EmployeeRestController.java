package de.jk.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import de.jk.model.Employee;

@RestController
public class EmployeeRestController {

	@GetMapping(path = "/employee/{id}")
	public Employee getEmployeeById(@PathVariable("id") long id) {
		return new Employee("ich ", "test");
	}

	
	@GetMapping(path = "/save")
	public Employee save( ) {
		System.out.println("save called");
		return new Employee("ich ", "test");
	}
@GetMapping("/employee")
public List<Employee> getAllEmployees(){
	List<Employee> t=new ArrayList<>();
	for (int i = 0; i < 400; i++) {
		t.add(new Employee("ich "+i,i+"test","kk","ii"));
	}
	return t;


}}
