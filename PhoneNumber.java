import java.util.ArrayList;
import java.util.Scanner;

public class PhoneNumber {
	
	// possible letter values
	// global variables
	
	static String[] allLetters = new String[] {"0", "1", "ABC",
			"DEF","GHI","JKL","MNO","PQRS","TUV","WXYZ"};
    static int NUMBER_OF_DIGITS = 10; // defines combo array length
    // stores the base values of "allLetters" based on what the user inputs
	static String[] comboPossibilities = new String[NUMBER_OF_DIGITS];
	
    public static void main(String args[])
    {
    	System.out.println("Enter Telephone Number: ");
        Scanner scan = new Scanner(System.in);
     	String phoneNumber = "";

     	// try and catch to catch errors
        try 
        {
        	phoneNumber = String.valueOf(Integer.parseInt(scan.nextLine()));
        	 // length the mnemonics solution must have
    	    NUMBER_OF_DIGITS = phoneNumber.length();
    	    // goes to procedure which then leads to the recursive function
    	    solveMnemonic(phoneNumber);  
     	} 	
     	catch (NumberFormatException error) 
     	{	
     		System.err.println("NOT AN VALID PHONE NUMBER!");		    
     	}    
    }
    
    // creates an array of the letter values of the telephone number
    public static void transformValues(int numVal, int location)
    {
	    String possibleLetters = allLetters[numVal];
	    comboPossibilities[location] = possibleLetters;
    }

    // function adds the values to an arraylist using recursion
    public static ArrayList<String> getMnemonicValues(String finalString, int startVal, int indexVal, 
    		ArrayList <String> possibleValues )
    {
	    String currentInfo = comboPossibilities[indexVal];
	    String singleLetter = "";
	    String finalVal = "";

	    // goes through every possible scenario
	    for (int count1 = 0; count1 < currentInfo.length(); count1 ++)
	    {
		    singleLetter = currentInfo.substring(count1, count1 + 1);
		    finalVal = finalString + singleLetter;

		    // uses only the possible combinations
		    if(finalVal.length() == NUMBER_OF_DIGITS)
		    {
		        possibleValues.add(finalVal);
		    }
		    else
		    {
		    	// calls function again
		    	getMnemonicValues(finalVal, startVal - 1, indexVal + 1, possibleValues);		
		    }
        }
	    
	    return possibleValues;
    }
		
    // procedure that leads to the main recursive function
    public static void solveMnemonic(String phoneNumber)
    {       
	    int stringVal;
	    ArrayList<String> mnemonics = new ArrayList<String>();
	
	    // loop to find the string values of each digit in the phone number
	    for (int count = 1; count <= phoneNumber.length(); count ++)
	    {
		    stringVal = Integer.parseInt(phoneNumber.substring(count - 1, count));
		    transformValues(stringVal, count - 1);
	    }	
	    mnemonics = getMnemonicValues("", NUMBER_OF_DIGITS, 0, mnemonics);
	    
	    // prints out solution
	    for(String value : mnemonics){
			System.out.println(value);
		}
    }
}
