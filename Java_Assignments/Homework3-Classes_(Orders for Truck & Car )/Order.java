/**
<h1>Orders for Truck & Car</h1>
*The prgram implements an application that simply takes input from user as order 
*and display user output on the screen.
*@author Kunal Joshi
*version 1.0
*@since 2019-09-24
*/
import java.util.*;
public class Order {
    /**
    This is the main method which calls methods in Car and Truck classes. 
    * @param args Unused.
    * @return Nothing.
    * @exception IOException On input error.
    * @see IOException
    */
    public static void main(String args[]) {
        System.out.println("Kunal Joshi's Ordering System (218-HW2)");
        Collection < Character > specificChars = Arrays.asList('T', 't', 'C', 'c');
        Collection < Character > specificChars1 = Arrays.asList('Y', 'N');
        ArrayList < String > order = new ArrayList < > ();
        Scanner scan = new Scanner(System.in);
        String s3;

        do {
            System.out.println("Do you want to order a Truck (T/t) or Car (C/c)?");
            char c = scan.next().charAt(0);
            //System.out.println("c = "+c); 
            if (!specificChars.contains(c)) {
                System.out.println("Invalid Input");
            } else
                System.out.println("You have entered: " + c);

            String s = Character.toString(c);


            if (s.equals("T") || s.equals("t")) {
			       Truck truck= new Truck();
                System.out.println(truck);
                order.add(truck.toString()); 
				
				
            }


            if (s.equals("C") || s.equals("c")) {
			       Car car= new Car();
                System.out.println(car);
                order.add(car.toString()); 
            }

            System.out.println("Do you want to order another vehicle?(Y/N)");
            char ch = scan.next().charAt(0);
            if (!specificChars1.contains(ch)) {
                System.out.println("Invalid Input");
            } else
                System.out.println("You have entered: " + ch);

            s3 = Character.toString(ch);
        }
        while (s3.equals("Y"));



        if (s3.equals("N")) {
            for (String orderList: order) {

                System.out.println(orderList);

            }

            System.out.println("Thank you for using Kunal Joshi's Ordering System.");

        }
    }
}