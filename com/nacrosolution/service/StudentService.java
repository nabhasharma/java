package com.nacrosolution.service;

import java.util.List;

import com.nacrosolutions.hibernate.entity.Student;



public interface StudentService {
public Student createStudent(Student student);
public List<Student> getAllStudent();
public Student getStudent(int id);
public void removeStudent(int id);
public Student updateStudent(int id);
}


