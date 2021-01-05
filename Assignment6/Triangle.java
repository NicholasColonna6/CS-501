/*
 * Nicholas Colonna & Evan Gutch
 * Group 12
 * Assignment 6
 * Exercise 11.1
 * CS 501WS
 * "I pledge my honor that I have abided by the Stevens Honor System." -ncolonna  -egutch
 */

public class Triangle extends GeometricObject{
	double side1;
	double side2;
	double side3;
	
	//default constructor
	public Triangle() {
		this.side1 = 1.0;
		this.side2 = 1.0;
		this.side3 = 1.0;
	}
	
	//Constructor
	public Triangle(double s1, double s2, double s3) throws IllegalTriangleException{
		//check if triangle rule is violated
		if(s1+s2<=s3 || s1+s3<=s2 || s2+s3<=s1) {
			throw new IllegalTriangleException("Invalid Triangle: The sum of two sides must be greater than the third side. \nPlease try again.\n");
		}
		
		this.side1 = s1;
		this.side2 = s2;
		this.side3 = s3;
	}
	
	//Getters
	public double getSide1() {
		return side1;
	}
	
	public double getSide2() {
		return side2;
	}
	
	public double getSide3() {
		return side3;
	}
	
	//Setters
	public void setSide1(double s1) {
		this.side1 = s1;
	}
	
	public void setSide2(double s2) {
		this.side2 = s2;
	}
	
	public void setSide3(double s3) {
		this.side3 = s3;
	}
	
	//calculates the area of a triangle
	public double getArea() {
		//Using Heron's formula
		double s = (side1 + side2 + side3) / 2;
		return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
	}
	
	//calculates the perimeter of a triangle
	public double getPerimeter() {
		return side1 + side2 + side3;
	}
	
	//returns triangle in string form
	public String toString() {
		return "Triangle: side1 = " + side1 + ", side2 = " + side2 + ", side3 = " + side3 + "\n" + super.toString();
	}
}
