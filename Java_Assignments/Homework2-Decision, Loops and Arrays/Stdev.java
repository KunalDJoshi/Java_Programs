//Joshi Kunal Deepak 
//ISTE-200 Java for Programmers 
//This program will calculate Standard Deviation of number set entered by user

import java.util.*;
public class Stdev {
    public static void main(String[] args) {
        int N = 0;

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter no. of elements you want to enter:");
        N = scan.nextInt();

        double numArray[] = new double[N];

        System.out.println("Enter all the elements: ");
        for (int i = 0; i < N; i++) {
            numArray[i] = scan.nextInt();
        }
        double standardDeviation = calcStaDev(numArray);
        System.out.println("Standard Deviation = " + standardDeviation);
    }



    public static double calcStaDev(double numArray[]) {
        double sum = 0.0, average = 0.0, SD = 0.0;
        int length = numArray.length;

        //calculating average of numbers
        for (double num: numArray) {
            sum = sum + num;
        }

        average = sum / length;


        //calculating standard deviation

        for (double num: numArray) {
            SD = SD + Math.pow((num - average), 2);
        }

        return Math.sqrt(SD / length);
    }

}