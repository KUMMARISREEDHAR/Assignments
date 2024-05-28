package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.demo.constructor_injection.StudentConstructorInjection;
import com.example.demo.setter_injection.EmpSetterInjection;

@SpringBootApplication
public class DependencyInjectionDemoApplication {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		EmpSetterInjection ee = (EmpSetterInjection) context.getBean("empsi");
		StudentConstructorInjection ss = (StudentConstructorInjection) context.getBean("studentci");
		ee.disp();
		ss.disp();
	}

}
