/*
 * Nicholas Colonna & Evan Gutch	
 * Assignment 0/1
 * Exercise 2.15
 * CS 501WS
 * "I pledge my honor that I have abided by the Stevens Honor System." -ncolonna  -egutch
 */
import java.util.Scanner;

public class C2E15Distance {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); 
		double [] xcords = new double[2];		//store x coordinates of points
		double [] ycords = new double[2];		//store y coordinates of points
		
		//Prompts user for points and saves coordinates in two arrays of doubles
		System.out.print("Enter x1 and y1: ");
		xcords[0] = scanner.nextDouble();
		ycords[0] = scanner.nextDouble();
		
		System.out.print("Enter x2 and y2: ");
		xcords[1] = scanner.nextDouble();
		ycords[1] = scanner.nextDouble();
		
		//Calculates the distance between two points
		double distance = Math.pow((Math.pow(xcords[1] - xcords[0], 2) + Math.pow(ycords[1] - ycords[0], 2)), 0.5);
		
		//Prints the distance between two points
		System.out.println("The distance between the two points is " + distance);
		
		//Close scanner
		scanner.close();
	}
}
