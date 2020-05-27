package com.nacrosolution.main;

import java.util.List;
import java.util.Scanner;

import com.nacrosolution.service.StudentService;
import com.nacrosolution.service.StudentServiceImpl;
import com.nacrosolutions.hibernate.entity.Student;


public class App {
	private static Scanner scanner = new Scanner(System.in);
	private static StudentService service;
static
	{
		service = new StudentServiceImpl();
	}

	public static void main( String[] args )
    {
    	int choice=-1;
       
        	do {
        		System.out.println("1.create student.");
            	System.out.println("2.display all student.");
            	System.out.println("3.find a student.");
            	System.out.println("4.remove a student.");
            	System.out.println("5. update student");
            	System.out.println("0.exit.");
            	System.out.print(".chose your choice: ");
            	choice=scanner.nextInt();
            	switch (choice) {
    			case 1:
    				System.out.print("first name: ");
    				String fName=scanner.next();
    				System.out.print("last name: ");
    				String lName=scanner.next();
    				System.out.print("email: ");
    				String email=scanner.next();
    				
    				Student student=App.service.createStudent(new Student(fName, lName, email));
    				System.out.println(student);
    				break;
    			case 2:
    				List<Student> students=App.service.getAllStudent();
    				for(Student c:students)
    				{
    					
    					//Customer customer1=(Customer)c;
    					System.out.println(c.getDetails());
    				}
    				break;
    			case 3:
    				System.out.print("id: ");
    				int id=scanner.nextInt();
    				Student student2=App.service.getStudent(id);
    				if(student2==null)
    				{
    					System.out.println("no such record found");
    				}
    				else
    				{
    					System.out.println(student2);
    				}
    				
    				break;
    			case 4:
    				System.out.print("id: ");
    				int id1=scanner.nextInt();
    				App.service.removeStudent(id1);
    				break;
    			case 5:
    				System.out.print("id: ");
    				int id3=scanner.nextInt();
    				Student c=App.service.updateStudent(id3);
    				System.out.println(c);
    				break;
    			case 0:
    				System.out.println("bye");
    				System.exit(0);
    				break;
    			default:
    				break;
    			}
            
    			
    		} while (choice!=0);
	
			
    }
        	    
}
