package com.beanscope;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beanscope.entity.PrototypeDemo;
import com.beanscope.entity.SingletoneDemo;

@SpringBootApplication
public class SingletoneAndPrototypeApplication {

	public static void main(String[] args) {
		ApplicationContext con = new ClassPathXmlApplicationContext("beanconfig.xml");
		SingletoneDemo std = (SingletoneDemo) con.getBean("singletonedemo");
		SingletoneDemo std2 = (SingletoneDemo) con.getBean("singletonedemo");

		PrototypeDemo ptd = (PrototypeDemo) con.getBean("prototypedemo");
		PrototypeDemo ptd2 = (PrototypeDemo) con.getBean("prototypedemo");
		
		System.out.println(std == std2); //singleton true
		System.out.println(ptd == ptd2); //prototype false
	}

}
