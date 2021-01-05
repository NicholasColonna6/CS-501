/*
 * Nicholas Colonna & Evan Gutch
 * Assignment 2
 * Exercise 4.3
 * CS 501WS
 * "I pledge my honor that I have abided by the Stevens Honor System." -ncolonna  -egutch
 */
import java.util.Scanner;

public class C4E3EstimateAreas {
	public static void main(String[] args) {
		System.out.println("This program will calculate the area between Atlanta, GA, Orlando, FL, Savannah, GA and Charlote, NC.\n");
		
		Scanner input = new Scanner(System.in);
		
		//Atlanta coordinates
		double x_atlanta = 33.7489954;
		double y_atlanta = -84.3879824;
		System.out.println("The location of Atlanta, GA is latitude: " + x_atlanta + ", longitude: " + y_atlanta);
		
		//Orlando coordinates
		double x_orlando = 28.5383355;
		double y_orlando = -81.37923649999999;
		System.out.println("The location of Orlando, FL is latitude: " + x_orlando + ", longitude: " + y_orlando);
		
		//Savannah coordinates
		double x_savannah = 32.0835407;
		double y_savannah = -81.09983419999998;
		System.out.println("The location of Savannah, GA is latitude: " + x_savannah + ", longitude: " + y_savannah);
		
		//Charlotte coordinates
		double x_charlotte = 35.2270869;
		double y_charlotte = -80.84312669999997;
		System.out.println("The location of Charlotte, NC is latitude: " + x_charlotte + ", longitude: " + y_charlotte);
		
		
		//Triangle 1 creation
		double Atl_to_Orl = greatCircleDistance(x_atlanta, y_atlanta, x_orlando, y_orlando);
		double Orl_to_Sav = greatCircleDistance(x_orlando, y_orlando, x_savannah, y_savannah);
		double Sav_to_Atl = greatCircleDistance(x_savannah, y_savannah, x_atlanta, y_atlanta);
		
		//Triangle 2 creation
		double Cha_to_Atl = greatCircleDistance(x_charlotte, y_charlotte, x_atlanta, y_atlanta);
		double Atl_to_Sav = greatCircleDistance(x_atlanta, y_atlanta, x_savannah, y_savannah);
		double Sav_to_Cha = greatCircleDistance(x_savannah, y_savannah, x_charlotte, y_charlotte);
		
		//Triangle areas
		double area_triangle1 = getTriangleArea(Atl_to_Orl, Orl_to_Sav, Sav_to_Atl);
		System.out.println("The area of triangle 1 is: " + area_triangle1);
		double area_triangle2 = getTriangleArea(Cha_to_Atl, Atl_to_Sav, Sav_to_Cha);
		System.out.println("The area of triangle 2 is: " + area_triangle2);

		//combines areas and prints
		double area_btw_cities = area_triangle1 + area_triangle2;
		System.out.println("The area in the polygon created by connecting Atlanta, Orlando, Savannah, and Charlotte is: " + area_btw_cities + " square kms");
	
		input.close();
	}
	
	//function used to calculate the area of a triangle given the 3 sides
	public static double getTriangleArea(double side1, double side2, double side3) {
		//Calculates perimeter and divides by 2
		double s = (side1 + side2 + side3) / 2;
		
		//Calculates area
		double area = Math.pow(s * (s - side1) * (s - side2) * (s - side3), 0.5);
		
		return area;
	}
	
	//function used to calculate the great circle distance between points
	public static double greatCircleDistance(double x1, double y1, double x2, double y2) {
		double earth_radius = 6371.01;
		
		//calculates distance
		double distance = earth_radius * (Math.acos(Math.sin(Math.toRadians(x1)) * Math.sin(Math.toRadians(x2)) 
				+ Math.cos(Math.toRadians(x1)) * Math.cos(Math.toRadians(x2)) * Math.cos(Math.toRadians(y1 - y2))));
		
		return distance;
	}

}
