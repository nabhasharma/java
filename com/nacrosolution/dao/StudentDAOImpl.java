package com.nacrosolution.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nacrosolutions.hibernate.entity.Student;



public class StudentDAOImpl  implements StudentDAO{
	
	private SessionFactory factory;
	private static Scanner scanner=new Scanner(System.in);
	
	private Session session;

	{
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class)
				.buildSessionFactory();
	session = factory.openSession();
	}

	@Override
	public Student createStudent(Student student) {
		session.getTransaction().begin();
		session.save(student);
		session.getTransaction().commit();
		return student;
	}

	@Override
	public List<Student> getAllStudent() {
		TypedQuery<Student> query=session.createQuery("from Student ",Student.class);
		return query.getResultList();
		
	}

	@Override
	public Student getStudent(int id) {
		Student student =null;
		try {
			student=session.get(Student.class,id);
			if(student==null) {
				throw new StudentNotFoundException("The student with this id not found"+id);
			}
		}
		catch(StudentNotFoundException e) {
			System.out.println(e.getMessage());
			
		}
		return student;
	}

	@Override
	public void removeStudent(int id) {
	 Student student =null;
	 try {
		student=session.get(Student.class, id);
		if(student==null) {
			throw new StudentNotFoundException("The student with this id not found"+id);
		}
	 }
		catch(StudentNotFoundException e) {
			System.out.println(e.getMessage());
			
		}
	 session.getTransaction().begin();
		session.remove(student);
		session.getTransaction().commit();
		System.out.println("student removed sucessfully.");
	}

	@Override
	public Student updateStudent(int id) {
		
		 Student student =null;
		 try {
			student=session.get(Student.class, id);
			if(student==null) {
				throw new StudentNotFoundException("The student with this id not found"+id);
			}
		 }
			catch(StudentNotFoundException e) {
				System.out.println(e.getMessage());
				
			}
		 
		 
		 System.out.print("first name: ");
			String fName=scanner.next();
			System.out.print("last name: ");
			String lName=scanner.next();
			System.out.print("email: ");
			String email=scanner.next();
			System.out.print("amount: ");
			int amount=scanner.nextInt();
			student.setFirstName(fName);
			student.setLastName(lName);
			student.setEmail(email);
			session.getTransaction().begin();
			session.update(student);
			session.getTransaction().commit();
			return student;
	}
	

}
