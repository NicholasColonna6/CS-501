/*
 * Nicholas Colonna & Evan Gutch
 * Group 12
 * Assignment 6
 * Exercise 12.5
 * CS 501WS
 * "I pledge my honor that I have abided by the Stevens Honor System." -ncolonna  -egutch
 */

public class IllegalTriangleException extends Exception{
	//default constructor
	public IllegalTriangleException() {	}
	
	//constructor
	public IllegalTriangleException(String ex) {
		super(ex);
	}
}
