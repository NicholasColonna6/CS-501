/*
 * Nicholas Colonna & Evan Gutch
 * Group 12
 * Assignment 6
 * Exercise 10.13
 * CS 501WS
 * "I pledge my honor that I have abided by the Stevens Honor System." -ncolonna  -egutch
 */
import java.util.*;

public class C10E13TestMyRectangle2D {
	
	static double checkWandH(double val) {
		if(val <= 0) {
			throw new IllegalArgumentException("Error: Cannot have zero or negative side length.");
		}else {
			return val;
		}
	}
	
	public static void main(String[] args) {
		System.out.println("This program allows the user to enter rectangles and test them with the MyRectangle2D functions.\n");
		
		Scanner input = new Scanner(System.in);
		
		int repeat_program = 1;
		int repeat_base = 1;
		int repeat_test = 1;
		
		while(repeat_program == 1) {
			repeat_base = 1;
			MyRectangle2D base;
			MyRectangle2D test;
			
			while(repeat_base == 1) {
				repeat_test = 1;
				double x_base=0, y_base=0, w_base=0, h_base=0;
				
				System.out.print("Please enter the x coordinate of the center of the base rectangle: ");
				boolean x_valid = false;
				while(x_valid == false) {
					try{
						x_base = input.nextDouble();
						x_valid = true;
					}catch(InputMismatchException ex) {
						input.nextLine();
						System.out.println("Error: Must have a numeric value for x.");
						System.out.print("Please enter the x coordinate of the center of the base rectangle: ");
					}
				}
				
				System.out.print("Please enter the y coordinate of the center of the base rectangle: ");
				boolean y_valid = false;
				while(y_valid == false) {
					try{
						y_base = input.nextDouble();
						y_valid = true;
					}catch(InputMismatchException ex) {
						input.nextLine();
						System.out.println("Error: Must have a numeric value for y.");
						System.out.print("Please enter the y coordinate of the center of the base rectangle: ");
					}
				}
				
				System.out.print("Please enter the width of the base rectangle: ");
				while(w_base == 0) {
					try{
						w_base = checkWandH(input.nextDouble());
					}catch(IllegalArgumentException ex){
						System.out.println("Error: Cannot have zero or negative width.");
						System.out.print("Please enter the width of the base rectangle: ");
					}catch(InputMismatchException ex) {
						input.nextLine();
						System.out.println("Error: Must have a numeric width.");
						System.out.print("Please enter the width of the base rectangle: ");
					}
				}

				System.out.print("Please enter the height of the base rectangle: ");
				while(h_base == 0) {
					try{
						h_base = checkWandH(input.nextDouble());
					}catch(IllegalArgumentException ex) {
						System.out.println("Error: Cannot have zero or negative height.");
						System.out.print("Please enter the height of the base rectangle: ");
					}catch(InputMismatchException ex) {
						input.nextLine();
						System.out.println("Error: Must have a numeric height.");
						System.out.print("Please enter the height of the base rectangle: ");
					}
				}
				
				base = new MyRectangle2D(x_base, y_base, w_base, h_base);
				System.out.println("\nArea of base rectangle: " + base.getArea());
				System.out.println("Perimeter of base rectangle: " + base.getPerimeter());
				
				while(repeat_test == 1) {
					double x_test=0, y_test=0, w_test=0, h_test=0;
										
					System.out.print("\nPlease enter the x coordinate of the center of the test rectangle: ");
					x_valid = false;
					while(x_valid == false) {
						try{
							x_test = input.nextDouble();
							x_valid = true;
						}catch(InputMismatchException ex) {
							input.nextLine();
							System.out.println("Error: Must have a numeric value for x.");
							System.out.print("Please enter the x coordinate of the center of the test rectangle: ");
						}
					}
					
					System.out.print("Please enter the y coordinate of the center of the test rectangle: ");
					y_valid = false;
					while(y_valid == false) {
						try{
							y_test = input.nextDouble();
							y_valid = true;
						}catch(InputMismatchException ex) {
							input.nextLine();
							System.out.println("Error: Must have a numeric value for y.");
							System.out.print("Please enter the y coordinate of the center of the test rectangle: ");
						}
					}
					
					System.out.print("Please enter the width of the test rectangle: ");
					w_test = 0;
					while(w_test == 0) {
						try{
							w_test = checkWandH(input.nextDouble());
						}catch(IllegalArgumentException ex){
							System.out.println("Error: Cannot have zero or negative width.");
							System.out.print("Please enter the width of the test rectangle: ");
						}catch(InputMismatchException ex) {
							input.nextLine();
							System.out.println("Error: Must have a numeric width.");
							System.out.print("Please enter the width of the test rectangle: ");
						}
					}
					
					System.out.print("Please enter the height of the test rectangle: ");
					h_test = 0;
					while(h_test == 0) {
						try{
							h_test = checkWandH(input.nextDouble());
						}catch(IllegalArgumentException ex) {
							System.out.println("Error: Cannot have zero or negative height.");
							System.out.print("Please enter the height of the test rectangle: ");
						}catch(InputMismatchException ex) {
							input.nextLine();
							System.out.println("Error: Must have a numeric height.");
							System.out.print("Please enter the height of the test rectangle: ");
						}
					}
					
					test = new MyRectangle2D(x_test, y_test, w_test, h_test);
					System.out.println("\nArea of test rectangle: " + test.getArea());
					System.out.println("Perimeter of test rectangle: " + test.getPerimeter());
						
					if(base.contains(test) == true) {
						System.out.println("\nThe base rectangle contains the test rectangle.");
					}else {
						System.out.println("\nThe base rectangle does not contain the test rectangle.");
					}
					if(base.overlaps(test) == true) {
						System.out.println("The test rectangle overlaps the base rectangle.");
					}else {
						System.out.println("The test rectangle does not overlap the base rectangle.");
					}
					if(base.abuts(test) == true) {
						System.out.println("The test rectangle abuts the base rectangle (overlaps on boundary).");
					}else{
						System.out.println("The test rectangle does not abut the base rectangle (no overlap on boundary).");
					}
					
					//checks if another test rectangle should run again
					System.out.print("\nTry a different test rectangle (enter 1 for yes or 0 for no)?: ");
					repeat_test = input.nextInt();
					input.nextLine();
				}
				
				//checks if another base rectangle should be entered should run again
				System.out.print("\nTry a different base rectangle (enter 1 for yes or 0 for no)?: ");
				repeat_base = input.nextInt();
				input.nextLine();
			}
			
			//checks if program should run again
			System.out.print("\nRepeat program (enter 1 for yes or 0 for no)?: ");
			repeat_program = input.nextInt();
			input.nextLine();
		}
		
		input.close();
		
		
//		//our test cases
//		MyRectangle2D r1 = new MyRectangle2D(2, 3, 7.5, 9.5);
//		System.out.println("First Rectangle (r1): x=2, y=3, width=7.5 and height=9.5");
//		System.out.println("Area of r1: " + r1.getArea());
//		System.out.println("Perimeter of r1: " + r1.getPerimeter());
//		
//		MyRectangle2D r2 = new MyRectangle2D();
//		System.out.println("\nSecond Rectangle (r2): x=0, y=0, width=1 and height=1");
//		MyRectangle2D r3= new MyRectangle2D(4, 5, 7.5, 9.5);
//		System.out.println("Third Rectangle (r3): x=4, y=5, width=7.5 and height=9.5");
//		
//		//checks point contains function
//		System.out.println("\nr1 contains the point (1, 1), check: " + r1.contains(1, 1));
//		System.out.println("r2 does not contain the point (10, 10), check: " + r2.contains(10, 10));
//		
//		//checks rectangle contains function
//		System.out.println("\nr1 contains r2, check: " + r1.contains(r2));
//		System.out.println("r1 does not contain r3, check: " + r1.contains(r3));
//
//		//checks rectangle overlap function
//		System.out.println("\nr1 does not overlap r2, check: " + r1.overlaps(r2));
//		System.out.println("r1 overlaps r3, check: " + r1.overlaps(r3));
	}

}
