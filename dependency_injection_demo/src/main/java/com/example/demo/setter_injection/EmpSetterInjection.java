package com.example.demo.setter_injection;

import com.example.demo.entity.Employee;

public class EmpSetterInjection {

	private Employee emp;
	
	public void setEmp(Employee e) {
		this.emp = e;
	}

	public void disp() {
		System.out.println(emp.getId());
		System.out.println(emp.getName());
	}
}
