/*
 * Nicholas Colonna & Evan Gutch	
 * Assignment 0/1
 * Exercise 2.19
 * CS 501WS
 * "I pledge my honor that I have abided by the Stevens Honor System." -ncolonna  -egutch
 */
import java.util.Scanner;

public class C2E19AreaTriangle {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double [] xcords = new double[3];		//store x coordinates of points
		double [] ycords = new double[3]; 		//store y coordinates of points
		double side1, side2, side3;
		
		//Prompts user for input and saves coordinates in two arrays of doubles
		System.out.print("Enter three points for a triangle: ");
		xcords[0] = scanner.nextDouble();
		ycords[0] = scanner.nextDouble();
		xcords[1] = scanner.nextDouble();
		ycords[1] = scanner.nextDouble();		
		xcords[2] = scanner.nextDouble();
		ycords[2] = scanner.nextDouble();	
		
		//Calculates side lengths
		side1 = Math.pow((Math.pow(xcords[1] - xcords[0], 2) + Math.pow(ycords[1] - ycords[0], 2)), 0.5);
		side2 = Math.pow((Math.pow(xcords[2] - xcords[1], 2) + Math.pow(ycords[2] - ycords[1], 2)), 0.5);
		side3 = Math.pow((Math.pow(xcords[2] - xcords[0], 2) + Math.pow(ycords[2] - ycords[0], 2)), 0.5);
		
		//Calculates perimeter and divides by 2
		double s = (side1 + side2 + side3) / 2;
		
		//Calculates area
		double area = Math.pow(s * (s - side1) * (s - side2) * (s - side3), 0.5);
		
		//Prints area of triangle
		System.out.println("The area of the triangle is " + area);
		
		//Closes scanner
		scanner.close();
	}
}
