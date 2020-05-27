package com.nacrosolution.service;

import java.util.List;

import com.nacrosolution.dao.StudentDAO;
import com.nacrosolution.dao.StudentDAOImpl;
import com.nacrosolutions.hibernate.entity.Student;



 

public class StudentServiceImpl implements StudentService {
	private StudentDAO dao;
	
	public StudentServiceImpl() {
		dao=new StudentDAOImpl();
	}

	@Override
	public Student createStudent(Student student) {
		return dao.createStudent(student);
	
		
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return dao.getAllStudent();
	}

	@Override
	public Student getStudent(int id) {
		// TODO Auto-generated method stub
		return dao.getStudent(id);
	}

	@Override
	public void removeStudent(int id) {
		// TODO Auto-generated method stub
		dao.removeStudent(id);
	}

	@Override
	public Student updateStudent(int id) {
		// TODO Auto-generated method stub
		return dao.updateStudent(id);
	}

}
