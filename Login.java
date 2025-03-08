package com.Student.App;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.Student.DAO.StudentDAOClass;
import com.Student.DTO.Student;

public class Login {

	public static Student login() {
		Scanner sc = new Scanner (System.in);
		StudentDAOClass sdao = new StudentDAOClass();
		System.out.println("Enter the mail id ");
		String mail = sc.next();
		System.out.println("Enter the password");
		String password = sc.next();
		Student s1 =sdao.getStudent(mail, password);
		if(s1!=null) {
			System.out.println("Login Succesfull");
			System.out.println("Welcome "+s1.getName());
			int choice =0;
			
			do {
				
			System.out.println("1. View Credtial");
			System.out.println("2. Update Credential");
			System.out.println("3. Back to main menu");
			
			if(s1.getId()==1) {
				
				System.out.println("4. View all users");
				System.out.println("5. Delete user");
			}
			
			choice =sc.nextInt();
			
			
			switch(choice) {
			case 1: System.out.println(s1+"/n");
			break;
			
			case 2:Update.update();
			break;
			
			case 3:System.out.println("loading...");
			break;
			
			case 4:System.out.println("Student List:");
		    List<Student> listall = sdao.getStudent();
		    Iterator<Student> it=listall.iterator();
		    while(it.hasNext()) {
		    Student l=it.next();
		    System.out.println(l);
		    }
			
			
			case 5:System.out.println("Enter the id of the record");
			int a= sc.nextInt();
			boolean b =sdao.deleteStudent(a);
			if(b) {
				System.out.println("Record deleted succesfully");
			}
			else {
				System.out.println("Failed to delete record");
			}
			}
			
			}while(choice!=3);
			
		}
		return s1;
		
	}

}
