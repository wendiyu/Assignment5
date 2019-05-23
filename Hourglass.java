import java.util.Scanner;
import java.lang.Math;
import java.util.ArrayList;

public class Hourglass {
	
	//--------------------------
    static int getInput() { 
		//gets input from user 

		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.println("Please input a number:");
			try {
				//check if response is an integer
				String input = scanner.nextLine();
				int inputNumber = Integer.parseInt(input);
				
				//check if input is not less than 1
				if (inputNumber >=1) {
					return inputNumber;
				} else {
					System.out.println("Error: Invalid input!");
					return -1;
				}
			}catch (IllegalArgumentException x) { 
				System.out.println("Insert an integer!");
			}
		}
		
	}
	   
	//--------------------------
	 static void hourglass(int inputNum, int currentLine, int space) {   
			
			
		   	if (inputNum != 0) {
		   		 //if input is not 0
				
		   		if (currentLine!= inputNum) {
			   		if (inputNum > currentLine) {
			   			//decreasing
			   			space+= 1;
			   		} else {
			   			//increasing
			   			space-= 1;
			   		}
			   		//print space
			   		for ( int i= 0; i < space; i++ ) {  
			    		//print line
						System.out.print(" ");
			   		}
			   		//print asterisks
			   		for ( int index= 1; index <= Math.abs(inputNum-currentLine); index++ ) {  
			    		//print line
						System.out.print("* ");
			   		}
			   		//---------------------
			   		System.out.print("\n");
		   		} else {
		   			space+= 1;
		   		}
			   	if (currentLine < inputNum*2) {
		   			hourglass(inputNum, currentLine+1, space);
		   		}
	
		   	}	
	   }
	

		public static void main(String[] args) {
			//try
			
			//call the  class	
			Hourglass recursion= new Hourglass(); 
			
	
			System.out.println("Hourglass:");
			recursion.hourglass(getInput(), 0, -1);
			
		}    
}
