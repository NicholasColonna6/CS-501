/*
 * Nicholas Colonna & Evan Gutch 
 * Group 12
 * Assignment 5
 * Exercise 12.13
 * CS 501WS
 * "I pledge my honor that I have abided by the Stevens Honor System." -ncolonna  -egutch
 */
import java.util.*;	
import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class C12E13CountCharWordLines {
	//Checks if file is a .txt file, throws exception if not
	static void isCorrectFileType(File file) throws Exception{
		String nameFile = file.getName();
		if(nameFile.lastIndexOf('.') == -1 || nameFile.substring(nameFile.lastIndexOf('.') + 1).equals("txt") == false) {
			throw new Exception("File is not of type '.txt'");
		}
	}
	
	//counts characters in a line
	static int countChars(String line) {
		return line.length();
	}
	
	//counts words in a line
	static int countWords(String line) {
		String[] removedSpaces = line.split("\\s+");  //creates an array where each element is split based on spaces (from stackoverflow)
		return removedSpaces.length;
	}
	
	//main function
	public static void main(String[] args) {
		System.out.println("This program counts the number of characters, words and lines in a file.");
		
		Scanner input = new Scanner(System.in);
		JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		chooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
		int repeatInt = 1;
		
		while(repeatInt == 1) {
			int returnValue = chooser.showOpenDialog(null);
			
			if(returnValue == JFileChooser.APPROVE_OPTION) {
				int charCount = 0;
				int wordCount = 0;
				int lineCount = 0;
				String line = null;
				
				try {
					File inputFile = chooser.getSelectedFile();
					isCorrectFileType(inputFile);
					
					FileReader fileReader = new FileReader(inputFile);
					BufferedReader bufferedReader = new BufferedReader(fileReader);
					
					line = bufferedReader.readLine();
					while(line != null) {
						charCount += countChars(line);
						wordCount += countWords(line);
						lineCount++;
						line = bufferedReader.readLine();
					}
					
					System.out.println("The results for the file '" + inputFile.getName() + "' are the following:");
					System.out.println("Character Count = " + charCount);
					System.out.println("Word Count = " + wordCount);
					System.out.println("Line Count = " + lineCount);
					
					bufferedReader.close();
					fileReader.close();
					
				}catch(FileNotFoundException ex) {
					System.out.println("Error: File not found.");
				}catch(IOException ex) {
					System.out.println("Error: An I/O exception occurred");
				}catch(Exception ex) {
					System.out.println("Error: An exception occurred");
				}
			}
			
			//checks if program should run again if valid password was found
			System.out.print("Repeat program (enter 1 for yes or 0 for no)?: ");
			repeatInt = input.nextInt();
		}
		
		input.close();	//close scanner
	}
}
