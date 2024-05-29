package com.demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.demo.entity.Employee;

public class EmpJDBC {

	//jdbc configuration details
	private final String driverName = "org.h2.Driver";
	private final String url = "jdbc:h2:~/testdb";
	private final String user = "sa";
	private final String password = "";
	
	//SQL queries 
	private final String insertQuery = "insert into emp2(name, gender, role) values (?, ?, ?);";
	private final String selectQuery = "select * from  emp2;";
	private final String updateQuery = "update table emp2 set name = ?, gender = ?, role = ? where id = ?;";
	private final String deleteQuery = "delete from emp2 where id = ?;";

	
	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(url, user, password);
			
		}catch(ClassNotFoundException d) {
			d.printStackTrace();
		}catch(SQLException s) {
			s.printStackTrace();
		}
		return con;
	}
	
	public void insertEmp(Employee e) {
		try(Connection con = getConnection(); PreparedStatement pst = con.prepareStatement(insertQuery);) {
			pst.setNString(1, e.getName());
			pst.setNString(2, e.getGender());
			pst.setNString(3, e.getRole());
			pst.executeUpdate();

		}catch(SQLException s) {
			s.printStackTrace();
		}
	}
	public Employee findEmpById(int id) {
		Employee e = null;
		try(Connection con = getConnection(); PreparedStatement pst = con.prepareStatement(selectQuery);) {
			pst.setInt(0, id);
			ResultSet s = pst.executeQuery();
			while(s.next()) {
				e.setName(s.getString("name"));
				e.setGender(s.getString("gender"));
				e.setRole(s.getString("role"));
			}

		}catch(SQLException s) {
			s.printStackTrace();
		}
		return e;
	}
	
	public void updateEmp(Employee e) {
		try(Connection con = getConnection(); PreparedStatement pst = con.prepareStatement(updateQuery);) {
			pst.setNString(1, e.getName());
			pst.setNString(2, e.getGender());
			pst.setNString(3, e.getRole());
			pst.setNString(4, e.getId());
			pst.executeUpdate();

		}catch(SQLException s) {
			s.printStackTrace();
		}
	}
	
	public void deleteEmp(int id) {
		try(Connection con = getConnection(); PreparedStatement pst = con.prepareStatement(deleteQuery);) {
			pst.setInt(1, id);
			pst.executeUpdate();
			
		}catch(SQLException s) {
			s.printStackTrace();
		}
	}
	
}
