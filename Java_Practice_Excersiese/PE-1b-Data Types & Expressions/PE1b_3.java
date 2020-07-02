//import java.util.*;
public class PE1b_3
{
 //this is incomplete and won't compile!
 //final static float PI = 3.141579f;  // data type needed
 public static void main(String [ ] args)
 {
 int diameter = 25; // feet for a 25 foot diameter pool
 double poolArea;
 double radius = (double)diameter/2;
 System.out.println("radius: "+radius);
 // calculation for swimming pool area
 //poolArea= PI*radius*radius;
poolArea= Math.PI*radius*radius;
 System.out.println("The area of the pool is " +
                    poolArea + " square feet");

 }
} 