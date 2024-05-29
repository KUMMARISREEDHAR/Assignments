package com.crud_operations.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud_operations.entity.Employee;
import com.crud_operations.repository.EmpRepo;

@Service
public class EmpService {

	@Autowired
	private EmpRepo repo;
	
	public Employee save(Employee e) {
		return repo.save(e);
	}
	
	public Employee update(Employee e) {
		if(repo.findById(e.getId()) != null)
		return  repo.save(e);
		else 
			return null;
	}
	
	public Employee findByEmpId(int id) {
		return  repo.findById(id);
	}
	
	public void deleteByEmpId(int id) {
		 repo.deleteById(id);
	}
}
