package com.studentproject.studentmarks.model;

import java.io.Serializable;



public class studentmarks implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	

	private int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	private String name;
	private int marks;

}
