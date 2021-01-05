/*
 * Nicholas Colonna & Evan Gutch
 * Assignment 4
 * Exercise 10.9
 * CS 501WS
 * "I pledge my honor that I have abided by the Stevens Honor System." -ncolonna  -egutch
 */

public class Course {
	private String courseName;
	private String[] students = new String[0];  //creates students array
	private String[] grades = new String[0];	//creates grades array
	private int numberOfStudents;
	
	//adds a course
	public Course(String courseName) {
		this.courseName = courseName;
	}
	
	//adds a student
	public void addStudent(String student) {
		//creates student and grades array that have space for one more student
		String[] newStudentArray = new String[1 + numberOfStudents];	
		String[] newStudentGrades = new String[1 + numberOfStudents];
		
		//loops through both arrays, copying the current list of students and grades
		for(int i=0; i<numberOfStudents; i++) {
			newStudentArray[i] = students[i];
			newStudentGrades[i] = grades[i];
		}
		
		//saves the new, larger array to the global variables
		students = newStudentArray;
		grades = newStudentGrades;
		students[numberOfStudents] = student;	//adds new student
		numberOfStudents++;		//increments amount of students by 1
	}
	
	//adds grade and checks if its valid input
	public void addGrade(String grade, int index) {
		if(!(grade.equals("A")) && !(grade.equals("B")) && !(grade.equals("C")) && !(grade.equals("D")) && !(grade.equals("F"))) {
			throw new IllegalArgumentException("Invalid Input: Grade must be A, B, C, D, or F");		//throws exception if not A,B,C,D or F
		}
		grades[index] = grade;
	}
	
	//returns students
	public String[] getStudents() {
		return students;
	}
	
	//returns grades
	public String[] getGrades() {
		return grades;
	}
	
	//returns number of students
	public int getNumberOfStudents() {
		return numberOfStudents;
	}
	
	//returns course name
	public String getCourseName() {
		return courseName;
	}
	
	//removes a student from the course
	public void dropStudent(String student) {
		int indexOfStudent = -1;
		for(int i=0; i<numberOfStudents; i++) {		//loops through students to see if student being dropped exists, saves index if found
			if(students[i].equals(student)) {
				indexOfStudent = i;
			}
		}
		
		if(indexOfStudent == -1) {		//if student wasn't found, print not in course
			System.out.println(student + " is not entrolled in " + courseName);
		}else {		//else, remove student and their grade
			String[] newStudentArray = new String[numberOfStudents - 1];
			String[] newGradeArray = new String[numberOfStudents - 1];
			for(int i=0; i<newStudentArray.length; i++) {
				if(i >= indexOfStudent) {		//everything after the student being removed shifts to the left one space
					newStudentArray[i] = students[i+1];
					newGradeArray[i] = grades[i+1];
				}else {			//anything before student being removed stays same
					newStudentArray[i] = students[i];
					newGradeArray[i] = grades[i];
				}
			}
			students = newStudentArray;
			grades = newGradeArray;
			numberOfStudents--;
		}
	}
	
	//removes all students from course
	public void clear() {
		//sets student and grade arrays to empty and number of students to 0
		students = new String[0];
		grades = new String[0];
		numberOfStudents = 0;
	}
}
