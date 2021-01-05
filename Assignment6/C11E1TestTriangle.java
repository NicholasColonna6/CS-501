/*
 * Nicholas Colonna & Evan Gutch
 * Group 12
 * Assignment 6
 * Exercise 11.1
 * CS 501WS
 * "I pledge my honor that I have abided by the Stevens Honor System." -ncolonna  -egutch
 */
import java.util.Scanner;

public class C11E1TestTriangle {
	public static void main(String[] args) {
		System.out.println("This program takes 3 sides as input from the user and prints various aspects of about the triangle they create.\n");
		
		Scanner input = new Scanner(System.in);
		
		int repeat_program = 1;
		while(repeat_program == 1) {
			Triangle tri = new Triangle();	  //initialize triangle
			
			boolean is_valid = false;
			while(is_valid == false) {	//repeat input if it wasn't a valid triangle
				System.out.println("Enter the three side lengths of your triangle:");
				
				System.out.print("Enter side 1: ");
				double s1 = input.nextDouble();
				
				System.out.print("Enter side 2: ");
				double s2 = input.nextDouble();
				
				System.out.print("Enter side 3: ");
				double s3 = input.nextDouble();
				
				try {		//try to create the try triangle, catch if its not possible
					tri = new Triangle(s1, s2, s3);
					is_valid = true;
					input.nextLine();
				} catch (IllegalTriangleException e) {
					System.out.println(e.getMessage());
				}
			}
			
			//prompts user to enter color and saves
			System.out.print("What color is the triangle? ");
			String color = input.nextLine();
			tri.setColor(color);
			
			//prompts user to enter filled/not filled and saves
			System.out.print("Is the triangle filled? (true/false) ");
			boolean filled = input.nextBoolean();
			tri.setFilled(filled);
			
			//prints out details about triangle
			System.out.println("\nThe following details are about your triangle:\n");
			System.out.println(tri.toString());
			
			//checks if program should run again
			System.out.print("\nRepeat program (enter 1 for yes or 0 for no)?: ");
			repeat_program = input.nextInt();
			input.nextLine();
			System.out.println();
		}
		
		input.close();	//close scanner
	}

}
