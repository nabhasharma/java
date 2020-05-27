package com.nacrosolution.dao;

public class StudentNotFoundException  extends Exception{
	private String message;

	public StudentNotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	

}
