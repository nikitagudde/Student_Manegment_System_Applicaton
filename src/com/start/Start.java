package com.start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.entity.Student;
import com.studentDao.studentDao;


public class Start {

	public static void main(String[] args) throws IOException {
		System.out.println("welcome to Student Management System Application");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean go=true;
		while(go)
		{
			System.out.println("press 1 to ADD new Student");
			System.out.println("press 2 to delete Student");
			System.out.println("press 3 to display Student");
			System.out.println("press 4 to update Student");
			System.out.println("press 5 to exit Application");
			
			
			int c=Integer.parseInt(br.readLine());
			
			switch (c) 
			{
			case 1: //add student
				System.out.println("enter Student id :");
				int id = Integer.parseInt(br.readLine());
				
				System.out.println("Enter Student name :");
				String name= br.readLine();
				
				System.out.println("Enter Student phone no :");
				String phone= br.readLine();
				
				System.out.println("Enter Student city :");
				String city= br.readLine();
				
				//create student object to store the data 
				Student st = new Student(id,name, phone,city);
				
				
				boolean ans = studentDao.insertStudent(st);
				
				if(ans)
				{
					System.out.println("student is added successfully");
				}
				else
				{
					System.out.println("Something went wrong");
				}
				System.out.println(st);
				break;
			
			case 2: // delete student
				System.out.println("enter student id which you want to delete");
				int userId=Integer.parseInt(br.readLine());
				
				boolean f=studentDao.deleteStudent(userId);
				if(f)
				{
					System.out.println("Student deleted successfully");
				}
				else
				{
					System.out.println("Something went wrong...!");
				}
				break;
			
			case 3: // display students 
				studentDao.showAllStudent();
	
				break;
				
			case 4://update student
				System.out.println("enter student id whose data you want to update");
				int userId2 = Integer.parseInt(br.readLine());
				
				System.out.println("enter Student id :");
				int id2 = Integer.parseInt(br.readLine());
				
				System.out.println("Enter Student name :");
				String name2= br.readLine();
				
				System.out.println("Enter Student phone no :");
				String phone2= br.readLine();
				
				System.out.println("Enter Student city :");
				String city2= br.readLine();
				
				//create student object to store the data 
				Student st2 = new Student(id2,name2, phone2,city2);
				
				boolean ans2 =studentDao.updateStudent(st2,userId2);
				
				if(ans2)
				{
					System.out.println("student is updated successfully");
				}
				else
				{
					System.out.println("Something went wrong");
				}
				System.out.println(st2);
				break;
				
				
			case 5: // exit
				go=false;
				break;
				
				
			default:
				System.out.println("wrong choice try again");
			}
			
			
			
			}
		System.out.println("thankyou for using my application!!");
			
			
		}

	}