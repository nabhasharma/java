package com.nacrosolution.dao;

import java.util.List;

import com.nacrosolutions.hibernate.entity.Student;



public interface StudentDAO {
public Student createStudent(Student student);
public List<Student> getAllStudent();
public Student getStudent(int id);
public void removeStudent(int id);
public Student updateStudent(int id);
}
