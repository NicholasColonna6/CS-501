/*
 * Nicholas Colonna & Evan Gutch
 * Assignment 2
 * Exercise 4.2
 * CS 501WS
 * "I pledge my honor that I have abided by the Stevens Honor System." -ncolonna  -egutch
 */
import java.util.Scanner;

public class C4E2GreatCircleDistance {
	public static void main(String[] args) {
		System.out.println("This program will calculate the distance between 2 points, given latitude and longitude of each.\n");
		
		Scanner input = new Scanner(System.in);	//creates Scanner
		
		//prompts and takes input for point 1
		System.out.print("Enter point 1 (latitude and longitude) in degrees: ");
		double p1_lat = input.nextDouble();
		double p1_long = input.nextDouble();
		
		//prompts and takes input for point 2
		System.out.print("Enter point 2 (latitude and longitude) in degrees: ");
		double p2_lat = input.nextDouble();
		double p2_long = input.nextDouble();	
	
		//calculates distance between the 2 points
		double earth_radius = 6371.01;
		double distance = earth_radius * (Math.acos(Math.sin(Math.toRadians(p1_lat)) * Math.sin(Math.toRadians(p2_lat)) 
				+ Math.cos(Math.toRadians(p1_lat)) * Math.cos(Math.toRadians(p2_lat)) * Math.cos(Math.toRadians(p1_long - p2_long))));
		
		//prints output
		System.out.println("The distance between the two points is " + distance + " km");
	
		input.close();
	}

}
