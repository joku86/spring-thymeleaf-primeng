package de.jk.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
 
import de.jk.model.Employee;
import de.jk.model.UserRepository;
 

@RestController
public class EmployeeRestController {
	
	
	@Autowired  
private UserRepository userRepository;

	@GetMapping(path = "/employee/{id}")
	public Employee getEmployeeById(@PathVariable("id") long id) {
		return new Employee("ich ", "test");
	}

	
	@GetMapping(path = "/save")
	public Employee save( ) {
		 
			Employee n = new Employee("dfsf","sadff");
			 
			Employee save = userRepository.save(n);
		 
		System.out.println("save called "+save);
		return new Employee("ich ", "test");
	}
@PostMapping("/employee")
public List<Employee> getAllEmployees(@RequestBody String data){
	System.out.println(data);
	List<Employee> t=new ArrayList<>();
	for (int i = 0; i < 400; i++) {
		t.add(new Employee("ich "+i,i+"test","kk","ii"));
	}
	return t;


}}
