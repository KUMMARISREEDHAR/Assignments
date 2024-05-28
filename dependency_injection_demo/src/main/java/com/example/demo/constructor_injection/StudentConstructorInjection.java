package com.example.demo.constructor_injection;

import com.example.demo.entity.Student;

public class StudentConstructorInjection {

	Student student;
	StudentConstructorInjection(Student s) {
		this.student = s;
	}
	
	public void disp() {
		System.out.println(student.getRollNumber()+"\n"+student.getSname()+"\n"+student.getSchoolName());
	}
}
