package com.example.demo.entity;

import java.util.List;
import java.util.Map;

public class Student {

	private int rollNumber;
	private String sname;
	private String schoolName;
	private List<String>sublist;
	private Map<String,Integer>marks;
	public int getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public List<String> getSublist() {
		return sublist;
	}
	public void setSublist(List<String> sublist) {
		this.sublist = sublist;
	}
	public Map<String, Integer> getMarks() {
		return marks;
	}
	public void setMarks(Map<String, Integer> marks) {
		this.marks = marks;
	}
}
