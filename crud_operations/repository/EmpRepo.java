package com.crud_operations.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud_operations.entity.Employee;

public interface EmpRepo extends JpaRepository<Employee, Integer> {

	public Employee findById(int id);
}
