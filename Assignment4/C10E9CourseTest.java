/*
 * Nicholas Colonna & Evan Gutch
 * Assignment 4
 * Exercise 10.9
 * CS 501WS
 * "I pledge my honor that I have abided by the Stevens Honor System." -ncolonna  -egutch
 */
import java.util.*;

public class C10E9CourseTest {

	public static void main(String[] args) {
		System.out.println("This program tests the Course class by entering information and displaying the resulting students.\n");
		
		Scanner input = new Scanner(System.in);    //creates scanner object		
		
		//creates a course
		Course cs501 = new Course("CS 501");
		
		//adds four students to course
		cs501.addStudent("Nick Colonna");
		cs501.addStudent("Evan Gutch");
		cs501.addStudent("Jane Smith");
		cs501.addStudent("John Doe");
		
		//prompts user to enter grades for each student and adds to respective students profile
		String[] students = cs501.getStudents();
		for(int i=0; i<cs501.getNumberOfStudents(); i++) {
			System.out.print("Enter the grade for " + students[i] + ": ");
			String grade = input.nextLine();
			try{		//try to add grade for student
				cs501.addGrade(grade, i);
			}catch(IllegalArgumentException ex) {	//if inputs not valid, catch exception
				System.out.println("Invalid Input: Grade must be A, B, C, D, or F.");
				i--;
			}
		}
		
		//removes a student
		cs501.dropStudent("Jane Smith");
		
		//displays the students in the course and their grade
		System.out.println("Number of students in " + cs501.getCourseName() + ": " + cs501.getNumberOfStudents());
		students = cs501.getStudents();
		String[] grades = cs501.getGrades();
		System.out.println("\nStudent\t\tGrade");
		for(int i=0; i< cs501.getNumberOfStudents(); i++) {
			System.out.println(students[i] + "\t" + grades[i]);
		}
		
		input.close();   //closes scanner
	}

}
