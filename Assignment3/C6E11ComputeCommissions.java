/*
 * Nicholas Colonna & Evan Gutch
 * Assignment 3
 * Exercise 6.11
 * CS 501WS
 * "I pledge my honor that I have abided by the Stevens Honor System." -ncolonna  -egutch
 */
public class C6E11ComputeCommissions {

	public static void main(String[] args) {
		System.out.println("This program will calculate the a table showing commissions for various sales amount.\n");
		
		System.out.println("Sales Amount \tCommission");
		for(double salesAmount = 10000; salesAmount <= 100000; salesAmount += 5000) {
			System.out.print(String.format("%.0f", salesAmount));
			System.out.println("\t\t" + String.format("%.1f", computeCommission(salesAmount)));
		}
	}
	
	public static double computeCommission(double salesAmount) {
		if(salesAmount > 0 && salesAmount <= 5000) {
			return 0.08 * salesAmount;
		}else if(salesAmount <= 10000) {
			return 0.08 * 5000 + 0.10 * (salesAmount - 5000);
		}else if(salesAmount > 10000) {
			return 0.08 * 5000 + 0.10 * 5000 + 0.12 * (salesAmount - 10000);
		}else {
			return 0;
		}
	}

}
