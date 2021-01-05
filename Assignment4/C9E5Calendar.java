/*
 * Nicholas Colonna & Evan Gutch
 * Assignment 4
 * Exercise 9.5
 * CS 501WS
 * "I pledge my honor that I have abided by the Stevens Honor System." -ncolonna  -egutch
 */
import java.util.*;

public class C9E5Calendar {

	public static void main(String[] args) {
		System.out.println("This program will use the GregorianCalendar class to display today's date and another date based off of milliseconds.");
		
		//creates calendar object
		GregorianCalendar calendar = new GregorianCalendar();
		
		//gets the month, day and year of current date
		int currentMonth = 1 + calendar.get(Calendar.MONTH);
		int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
		int currentYear = calendar.get(Calendar.YEAR);
		
		//prints out current date on Gregorian calendar
		System.out.println("\nToday's date on the Gregorian calendar is: (mm/dd/yyyy)");
		System.out.println(currentMonth + "/" + currentDay + "/" + currentYear);
		
		
		//sets new date based off of milliseconds and saves date to variables
		calendar.setTimeInMillis(1234567898765L);
		int newMonth = 1 + calendar.get(Calendar.MONTH);
		int newDay = calendar.get(Calendar.DAY_OF_MONTH);
		int newYear = calendar.get(Calendar.YEAR);
		
		//prints out current date on Gregorian calendar
		System.out.println("\nThe new date based off of milliseconds on the Gregorian calendar is: (mm/dd/yyyy)");
		System.out.println(newMonth + "/" + newDay + "/" + newYear);		
	}

}
