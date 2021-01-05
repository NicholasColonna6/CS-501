/*
 * Nicholas Colonna & Evan Gutch 
 * Group 12
 * Assignment 5
 * Exercise 6.18
 * CS 501WS
 * "I pledge my honor that I have abided by the Stevens Honor System." -ncolonna  -egutch
 */
import java.util.*;

public class C6E18CheckPassword {
	
	static boolean passwordValid(String password) {
		//must be at least 8 characters
		//must be only letters and digits
		//must contain at least 2 digits
		
		//checks password length
		if(password.length() < 8) {
			//return false;
			throw new InputMismatchException("Invalid Password: Does not contain at least 8 characters");
		}
		
		//checks if all characters are a letter or digit
		for(int i=0; i<password.length(); i++) {
			if(Character.isLetterOrDigit(password.charAt(i)) == false) {
				//return false;
				throw new InputMismatchException("Invalid Password: Does not contain only letters or digis");
			}
		}
		
		//checks if at least 2 digits
		int num_digits = 0;
		for(int i=0; i<password.length(); i++) {
			if(Character.isDigit(password.charAt(i)) == true) {
				num_digits++;
			}
		}
		if(num_digits < 2) {
			//return false;
			throw new InputMismatchException("Invalid Password: Does not contain at least 2 digits");
		}
		
		//only reaches this statement if all tests passed
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println("This program checks whether a string is a valid password based on 3 rules.\n");

		Scanner input = new Scanner(System.in);  //create scanner object
		int repeatInt = 1;
		
		while(repeatInt == 1) {
			boolean is_valid = false;
			//Prompts user to enter password and gives rules
			System.out.println("Password Rules:\n  -Must contain at least 8 characters.\n  -Must consist of only letters and digits.\n  -Must contain at least 2 digits.");
			System.out.print("\nEnter a password: ");
			String password = input.nextLine();		//reads in password
			
			try {   //trys to check if password is valid and print valid
				is_valid = passwordValid(password);
				System.out.println("Valid Password\n");
			}catch(InputMismatchException ex) {		//catches error and prints invalid
				System.out.println("Invalid Password\n");
			}
			
			//checks if program should run again if valid password was found
			if(is_valid == true) {
				System.out.print("Repeat program (enter 1 for yes or 0 for no)?: ");
				repeatInt = input.nextInt();
				System.out.println("\n");
				input.nextLine();
			}
		}
		
		input.close();
	}
}
