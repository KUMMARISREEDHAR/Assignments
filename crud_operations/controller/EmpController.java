package com.crud_operations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud_operations.entity.Employee;
import com.crud_operations.service.EmpService;

@RestController
public class EmpController {

	@Autowired
	private EmpService service;
	
	@PostMapping("/save")
	public Employee save(@RequestBody Employee e) {
		return service.save(e);
	}
	
	@GetMapping("/findbyId/{id}")
	public Employee findById(int id) {
		return service.findByEmpId(id);
	}
	
	@GetMapping("/update")
	public Employee updateEmp(Employee e) {
		return service.update(e);
	}
	
	@GetMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		service.deleteByEmpId(id);
	}
}
