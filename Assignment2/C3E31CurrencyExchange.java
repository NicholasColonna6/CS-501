/*
 * Nicholas Colonna & Evan Gutch
 * Assignment 2
 * Exercise 3.31
 * CS 501WS
 * "I pledge my honor that I have abided by the Stevens Honor System." -ncolonna  -egutch
 */
import java.util.Scanner;

public class C3E31CurrencyExchange {
	public static void main(String[] args) {
		System.out.println("This program will calculate the conversion from yuan to dollars and vice versa, based off of given exchange rate.\n");

		Scanner input = new Scanner(System.in);	 	//creates scanner
	    
	    System.out.print("Enter the exchange rate from dollars to RMB: ");
	    double exchange_rate = input.nextDouble();
	    
	    System.out.print("Enter 0 to convert dollars to RMB and 1 vice versa: ");
	    int which_conversion = input.nextInt();
	    
	    String start_currency;
	    if(which_conversion == 0) {
	    	start_currency = "dollar";
	    }else {
	    	start_currency = "RMB";
	    }
	    
	    System.out.print("Enter the " + start_currency + " amount: ");
	    double amount = input.nextDouble();
	    
	    double conversion;
	    if(which_conversion == 0) {
		    conversion = amount * exchange_rate;
	    	System.out.println("$" + amount + " is " + conversion + " yuan");
	    }else {
		    conversion = amount / exchange_rate;
	    	System.out.println(amount + " yuan is $" + String.format("%.2f", conversion));
	    }
	    
	    input.close();
	}
	
}
