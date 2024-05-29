package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.entity.Employee;
import com.demo.jdbc.EmpJDBC;

public class EmpDriver extends HttpServlet{

	Employee e = new Employee();
	EmpJDBC emp = new EmpJDBC();
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		
		e.setName(req.getParameter("name"));
		e.setGender(req.getParameter("gender"));
		e.setRole(req.getParameter("role"));
		emp.insertEmp(e);
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		e = emp.findEmpById(Integer.parseInt(req.getParameter("id")));
		try {
			PrintWriter out = res.getWriter(); 
			res.setContentType("text/html");
			out.println("<!DOCTYPE html>");
			out.println("<html lang = \"en\"");
			out.println("<head> <title> Emp details </title> </head>");
			out.println("<body> <h3>"+e.getName()+"</h3>");
			out.println("<h3>"+e.getGender()+"</h3>");
			out.println("<h3>"+e.getRole()+"</h3>");
			out.println("</body>  </html>");
			out.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
