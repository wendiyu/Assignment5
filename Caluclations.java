public class Caluclations {
	public static void Downhourglass(int num, int format){
		
		if (num < 1)
		return;
		
		 // it is to makes spaces 
		for (int counterdown = 0; counterdown < format; counterdown++) 
	    System.out.printf(" ");  
		// for print *
		for (int counterdown = 0; counterdown < num; counterdown++) 
		System.out.print("* ");
		System.out.print("\n");	 
			
		Downhourglass(num - 1, format + 1); 
	}
		
	public static void uphourglass(int num, int format){
		
		 // Base condition
		  if (num < 1)   
		  return;  
		  
		  // Recursive call  
		  uphourglass(num - 1, format + 1); 
		  
		  // it is to makes spaces 
		  for (int counterup = 0; counterup < format; counterup++)  
		        System.out.printf(" ");  
		  // for print *
		  for (int counterup = 0; counterup < num; counterup++)   
			  	System.out.printf("* ");
		  // for next line 
		  		System.out.printf("\n");  
		  		
		  
	}  
}
