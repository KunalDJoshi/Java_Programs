// This program will compute the hypotenuse of a right triangle 
// using the Pythagorean theorem:  
//           (a*a) + (b*b) = (c*c) 
// where a, b are the two shorter sides of the triangle and c is  
// the longest side. 
// 
// When you run the program, pass the lengths of the two shorter  
// sides of the triangle in as parameters on the command line.  
// For example: 
//   java Hypot 7 12 
  
 public class Hypot {   
    static double hypotenuse; // Declared hypotenuse variable as static variable 
	static double d1;// Declared d1 variable as static variable
	static double d2; //Missing semicolon added here and Declared d2 variable as static variable
    public static void main(String [] args) {
	

 
 
 // verify that two arguments were entered on the command line.  
 if (args.length != 2) {
 System.out.println("You need to enter two args.");
 System.exit(1);
 }
 // assuming the two string values entered are really numbers,
 // try to convert them to doubles.
 try {
      d1 = Double.parseDouble(args[0]);//Missing semicolon added here
	  d2 =  Double.parseDouble(args[1]);//new keyword removed
	  } // Non numbers entered, catch the error and gracefully exit.
	  catch(NumberFormatException nfe) {
	  System.out.println("Arguments need to be numbers.");
	  System.exit(2);
	  }
	 
     // calculate the hypotenuse length  
     //Made correction in below code snipet as:- replaced a and b variables which were given in original code by d1 and d2 variables respectively.
    hypotenuse = Math.sqrt(((d1*d1)+(d2*d2)));//Added missing braces
	 System.out.print("The hypotenuse of a right triangle with sides of ");
	 System.out.println(d1 + " and " + d2);
	 System.out.println(" is " + hypotenuse);
	 }
} 