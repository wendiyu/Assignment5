import java.util.Scanner;

public class Startpattern {

	public static void main(String args[]){
		Scanner userInput = new Scanner(System.in);
		int hourglassInput;
		System.out.print("Please enter a value higher than 0: ");
		System.out.println("");
		
		hourglassInput = userInput.nextInt();
		
		if (hourglassInput < 1){
			System.out.print("Invalid number! Please enter a value which is greater than 0.");
			System.exit(0);
		}
		
		Caluclations obj = new Caluclations();
		obj.Downhourglass(hourglassInput, 0);
		obj.uphourglass(hourglassInput, 0);
		
	}
}
