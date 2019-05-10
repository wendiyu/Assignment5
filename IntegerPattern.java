/****************************************************************************
 *
 * Created by: Wendi Yu
 * Created on: Apr 25 2018
 * Created for: ICS4U
 * This program for generate integer pattern using recursive
 * Ex : 1 2 1, 1 2 1 3 1 2 1, ....
 *
 ****************************************************************************/

import java.util.Scanner;

public class IntegerPattern {
	public static void main(String[] args) { 		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a positive integer less than 15: ");
		if(input.hasNextInt()) {
			int userNum = input.nextInt();
			String numPattern = symmetricPattern(userNum);		
			System.out.print(numPattern);
		}
		else {
			System.out.println("Please! Input a vaild number.");
		}
	}
	
	// method that produces a symmetric pattern about n where each half before and after n is also symmetric around n-1
	public static String symmetricPattern(int num) {
		
		// make a variable to hold the text for where the whole pattern is contained (output)
		String output = "";
		
		// make a variable to hold the text for where the repetitions (1 2 1) is contained (nextOutput)
		String nextOuput;
		
		// returns error if number is greater than/equal to 15 or number is less than 1
		if(num >= 15 || num < 1) {
			output = "Please! Input a vaild number.";
			return output;
		}
		else if(num == 1) {
			// base case (n = 1), prints out " 1 " if number is 1
			output = " 1 ";
			return output;
		}
		else {
			// for numbers greater than one but less or equal to 15
			nextOuput = symmetricPattern(num - 1);
			// assign recursion to variable nextOutput so you don't need to type in that same line of code over and over
			if(num <= 5) {
				//if number is less than or equal to 5, let the output be assigned nextOuput (recursion) + number + nextOutput(recursion)
				output = nextOuput + num + nextOuput;
			}
			else {
				//if the number is greater than 5, do the same thing from if statement, except add a new line before the next recursion (new line after each int greater than 5)
				output = nextOuput + num + "\n" + nextOuput;
			}
			//return output after if-else
			return output;
		}
	}
}
