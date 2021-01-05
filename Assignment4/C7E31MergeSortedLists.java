/*
 * Nicholas Colonna & Evan Gutch
 * Assignment 4
 * Exercise 7.31
 * CS 501WS
 * "I pledge my honor that I have abided by the Stevens Honor System." -ncolonna  -egutch
 */
import java.util.*;

public class C7E31MergeSortedLists {

	public static void main(String[] args) {
		System.out.println("This program will merge two sorted lists into a new sorted list.\n");
		
		Scanner input = new Scanner(System.in);	   //creates scanner object
		int repeatInt = 1;
		
		
		while(repeatInt == 1) {  //repeat loop
			System.out.println("The first number entered for each list is the number of elements that will be entered after.");
			//prompts user for list1 and saves to variable
			System.out.print("Enter list1: ");
			int[] list1 = new int[input.nextInt()];
			for(int i=0; i<list1.length; i++) {
				list1[i] = input.nextInt();
			}
			
			//prompts user for list2 and saves to variable
			System.out.print("Enter list2: ");
			int[] list2 = new int[input.nextInt()];
			for(int i=0; i<list2.length; i++) {
				list2[i] = input.nextInt();
			}
			
			//calls method merge to merge the 2 lists
			int[] merged_list = merge(list1, list2);
			
			//prints the merged list
			System.out.print("The merged list is ");
			for(int i=0; i<merged_list.length; i++) {
				System.out.print(merged_list[i] + " ");
			}
			System.out.println();
			
			
			//checks if program should run again
			System.out.print("\nRepeat program (enter 1 for yes or 0 for no)?: ");
			repeatInt = input.nextInt();
			System.out.println();
		}
		
		input.close();   //closes scanner
	}

	public static int[] merge(int[] list1, int[] list2) {
		int[] merged_list = new int[list1.length + list2.length];  //create list of right size
		
		//copies list1 to combined list
		for(int i=0; i<list1.length; i++) {
			merged_list[i] = list1[i];
		}
		
		//copies list2 to combined list
		for(int i=0; i<list2.length; i++) {
			merged_list[i + list1.length] = list2[i]; 
		}
		
		Arrays.sort(merged_list);   //sorts the list
		
		return merged_list;
	}
}
