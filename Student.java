package studentdatabaseapp;

import java.util.Scanner;

public class Student {
	private String firstName, lastName, currentYear;
	private String courses = "";
	private String studentId;
	private int tuitionBalance = 0;
	private static int costOfCourse = 600;
	private static int id = 1000;
	
	// Constructor that prompts user to enter student's name and year
	public Student() {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter student's first name: ");
		this.firstName = in.nextLine();
		
		System.out.print("Enter student's last name: ");
		this.lastName = in.nextLine();
		
		System.out.print("1 - 1st year\n2 - 2nd year\n3 - 3rd year\n4 - 4th year\nEnter student's class level: ");
		this.currentYear = in.nextLine();
				
		setStudentId();

	}
	
	// Generate an ID
	private void setStudentId() {
		id++;
		this.studentId = currentYear + "" + id;
	}
	
	// Enroll in courses
	public void enroll() {
		do {
			System.out.print("Enter course to enroll (Q to quit): ");
			Scanner in = new Scanner(System.in);
			String course = in.nextLine();
			
			if(!course.equals("Q") && !course.equals("q")) {
				courses = courses + "\n   " + course;
				tuitionBalance = tuitionBalance + costOfCourse;
			}
			else {
				break;
			}
		} while (1 != 0);		
	}
	
	// View balance
	public void viewBalance() {
		System.out.println("Your balance is: $" + tuitionBalance);
	}
	
	// Pay tuition
	public void payTuition() {
		viewBalance();
		System.out.print("Enter your payment: $");
		Scanner in = new Scanner(System.in);
		int payment = in.nextInt();
		tuitionBalance = tuitionBalance - payment;
		System.out.println("Thank you for your payment of $" + payment);
		viewBalance();
	}
	
	// Show status
	public String showInfo() {
		return "Name: " + firstName + " " + lastName +
				"\nYear: " + currentYear +
				"\nStudent ID: " + studentId + 
				"\nCourses enrolled: " + courses + 
				"\nBalance: $" + tuitionBalance;
	}

}
