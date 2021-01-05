/*
 * Nicholas Colonna & Evan Gutch
 * Assignment 3
 * Exercise 7.9, 7.10, 7.20
 * CS 501WS
 * "I pledge my honor that I have abided by the Stevens Honor System." -ncolonna  -egutch
 */
import java.util.Scanner;

public class C7E9E10E20TenNumbers {

	public static void main(String[] args) {
		System.out.println("This program will prompt the user to enter 10 numbers and give the minimum, the index of the minimum, and perform a revised selction sort.\n");
		
		Scanner input = new Scanner(System.in);  //creates scanner
		int repeatInt = 1;
		
		while(repeatInt == 1) {
			//prompts user to enter ten numbers and saves to variable
			System.out.print("Enter ten numbers: ");
			double[] numbers = new double[10];
			for(int i=0; i<numbers.length; i++) {
				numbers[i] = input.nextDouble();
			}
			
			//calls the function to find the minimum and prints
			double min = min(numbers);
			System.out.println("The minimum number is: " + min);
			
			//calls the function to find the index of the minimum and prints
			int indexOfMin = indexOfSmallestElement(numbers);
			System.out.println("The index of the minimum number is: " + indexOfMin);
			
			//calls the function to sort the array with a revised version of selection sort
			double[] sortedArray = revisedSelectionSort(numbers);
			System.out.print("The sorted array is: ");
			for(int i=0; i<sortedArray.length; i++) {
				System.out.print(sortedArray[i] + " ");
			}
			
			//checks if user wants to run program again
			System.out.print("\n\nRepeat program (enter 1 for yes or 0 for no)?: ");
			repeatInt = input.nextInt();
			System.out.println("\n");
		}
		
		input.close(); 	//closes scanner
	}
	
	//finds the smallest element in an array
	public static double min(double [] array) {
		double min = array[0];  //initialize min as first element
		
		//loops through array checking if element is smaller than current min, changes value if true
		for(int i=1; i<array.length; i++) {
			if(array[i] < min) {
				min = array[i];
			}
		}

		return min;
	}
	
	//finds index of the smallest element in an array
	public static int indexOfSmallestElement(double[] array) {
		int index = 0;
		double min = array[0];
		
		//loops through array checking if element is smaller than current min, changes value if true
		//also keeps track of index where that smallest value was found
		for(int i=1; i<array.length; i++) {
			if(array[i] < min) {
				min = array[i];
				index = i;
			}
		}
		
		return index;
	}
	
	//revised version of selection sort
	//finds largest number and swaps it with the last until array is sorted
	public static double[] revisedSelectionSort(double[] array) {
		//loop through whole array starting from the end and moving to the beginning
		for(int i=array.length - 1; i>0; i--) {
			double max = array[i];
			int indexOfMax = i;
			
			//loop to find max and index of the max
			for(int j=i-1; j >= 0; j--) {
				if(max < array[j]) {
					max = array[j];
					indexOfMax = j;
				}
			}
			
			//swaps max value with the value at i if necessary 
			if(indexOfMax != i) {
				array[indexOfMax] = array[i];
				array[i] = max;
			}
		}
		return array;
	}

}
