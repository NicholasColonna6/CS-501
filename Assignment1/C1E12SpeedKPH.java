/*
 * Nicholas Colonna & Evan Gutch
 * Assignment 0/1
 * Exercise 1.12
 * CS 501WS
 * "I pledge my honor that I have abided by the Stevens Honor System." -ncolonna  -egutch
 */
public class C1E12SpeedKPH {
	public static void main(String[] args) {
		double miles = 24.0;		//distance ran
		double hours = 1.0 + (40.0/60.0) + ((35.0/60.0)/60.0);	//time running in terms of hours
		
		double kilometers = miles * 1.6;	//converts miles to kilometers
		double kph = kilometers / hours;	//calculates speed in kilometers per hour 
		
		//Prints out the speed in kilometers per hour
		System.out.println("The average speed in kilometers per hour is " + kph);	
	}
}
