/*
 * Nicholas Colonna & Evan Gutch
 * Assignment 3
 * Exercise 5.22
 * CS 501WS
 * "I pledge my honor that I have abided by the Stevens Honor System." -ncolonna  -egutch
 */
import java.util.Scanner;

public class C5E22LoanAmortization {

	public static void main(String[] args) {
		System.out.println("This program will calculate the loan amortization schedule based on user inputs.\n");
		
		Scanner input = new Scanner(System.in); //creates scanner
		int repeatInt = 1;
		
		while(repeatInt == 1) {	//repeat loop
			//prompts user for loan amount and assigns to variable
		    System.out.print("Loan Amount: ");
		    double loanAmount = input.nextDouble();
		    
		    //prompts user for number of years for loan and assigns to variable
		    System.out.print("Number of Years: ");
		    int numberOfYears = input.nextInt();
		    
		    //prompts user for interest rate and assigns to variable
		    System.out.print("Annual Interest Rate: ");
		    double annualInterestRate = input.nextDouble();
			
		    //calculate monthly rate and payment
		    double monthlyInterestRate = (annualInterestRate / 100) / 12;
		    double monthlyPayment = (loanAmount * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -(numberOfYears*12)));
		    
		    System.out.println("\nMonthly Payment: " + String.format("%.2f", monthlyPayment));
		    System.out.println("Total Payment: " + String.format("%.2f", monthlyPayment * 12));
		    
		    //creates amortization schedule
		    double interest, principal;
		    double balance = loanAmount;
		    System.out.println("\nPayment#\tInterest\tPrincipal\tBalance");
			for(int i=1; i<=numberOfYears * 12; i++) {
				interest = monthlyInterestRate * balance;
				principal = monthlyPayment - interest;
				balance = balance - principal;
				System.out.println(i + "\t\t" + String.format("%.2f", interest) + "\t\t" + String.format("%.2f", principal) + "\t\t" + String.format("%.2f", balance));
			}
			
			//checks if program should run again
			System.out.print("\nRepeat program (enter 1 for yes or 0 for no)?: ");
			repeatInt = input.nextInt();
			System.out.println("\n");
		}
		
		input.close();		//closes scanner
	}
}
