/*
 * Nicholas Colonna & Evan Gutch 
 * Group 12
 * Assignment 5
 * Exercise 6.23
 * CS 501WS
 * "I pledge my honor that I have abided by the Stevens Honor System." -ncolonna  -egutch
 */
import java.util.*;

public class C6E23CountOccurrences {
	
	public static int count(String str, char a) {	//counts occurrences of a character in a word
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == a) {
				count++;
			}
		}
		return count;
	}
	
	public static void checkString(String str) throws Exception {		//checks if a string is valid
		if (str == null) {
			System.exit(0);
		}
		if (str.length() == 0) {
			Exception ex = new Exception("Input empty. You must enter a string.");
			throw ex;
		}
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isLetterOrDigit(str.charAt(i)) && str.charAt(i) != ' ') {
				Exception ex = new Exception("String must contain only letters and digits.");
				throw ex;
			}
		}
	}
	
	public static void checkCharacter(String c) throws Exception {		//checks if a character is valid
		checkString(c);
		if (c.length() > 1) {
			Exception ex = new Exception("Input must be one character.");
			throw ex;
		} else if (c.length() == 0) {
			Exception ex = new Exception("Input empty. You must enter a character.");
			throw ex;
		}
	}
	
	public static void main(String[] args) {
		System.out.println("This program will take in a string and a character input and display the number of ocurrences of the character within the string.\n");
		
		Scanner input = new Scanner(System.in);
		
		int firstLoopInt = 1; 
		int secondLoopInt = 1;
		String word = "";
		String character = "";
		
		while (firstLoopInt == 1) {
			try {
				System.out.print("Please enter a string of letters and/or digits: ");	//takes word input
				word = input.nextLine();
				
				checkString(word);		//checks that word is a valid string
				secondLoopInt = 1;
			} catch (Exception ex) {
				System.out.println("Error: Would you like to try again? (1 for yes, 0 for no");
				int repeat = 0;
				if (repeat == 1) {
					System.exit(0);
				} else {
					secondLoopInt = 0;
				}
			}
			
			while (secondLoopInt == 1) {
				try {
					System.out.print("Please enter a single character: ");		//takes character input
					character = input.nextLine();
					
					checkCharacter(character);		//checks that character is a valid character
					int occurrences = count(word, character.charAt(0));		//count occurrences of character in word

					//displays number of occurrences of the character in the string
					System.out.println("The number of occurrences of \'" + character + "\' in \"" + word + "\" is: " + occurrences + "\n");
					
					//asks user if they want to try another character
					System.out.print("Would you like to try another character (enter 1 for yes or 0 for no)?: ");
					secondLoopInt = input.nextInt();
					input.nextLine();
				} catch (Exception ex) {
					System.out.println("Error: Would you like to try again? (1 for yes, 0 for no");
					int repeat = 0;
					if (repeat == 1) {
						System.exit(0);
					} else {
						secondLoopInt = 0;
					}
				}
			}
			//asks user if they want to try another word
			System.out.print("Would you like to try another word (enter 1 for yes or 0 for no)?: ");
			firstLoopInt = input.nextInt();
			input.nextLine();
		}
		
		input.close();	//closes scanner
		System.exit(0);
	}
}
