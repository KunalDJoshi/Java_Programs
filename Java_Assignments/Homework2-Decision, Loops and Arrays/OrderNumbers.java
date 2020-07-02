//Joshi Kunal Deepak 
//ISTE-200 Java for Programmers 
//This program will display three numbers entered by user in ascending order
 
import java.util.*;
public class OrderNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter first number: ");
        int firstNum = scan.nextInt();

        System.out.println("Enter second number: ");
        int secondNum = scan.nextInt();

        System.out.println("Enter third number: ");
        int thirdNum = scan.nextInt();

        if (firstNum < secondNum) {
            if (firstNum < thirdNum) {
                if (secondNum < thirdNum) {
                    System.out.println("Ordered numbers are: " + firstNum + "," + secondNum + "," + thirdNum);
                } //goes in else when secondNum>=thirdNum
                else {
                    System.out.println("Ordered numbers are: " + firstNum + "," + thirdNum + "," + secondNum);
                } //goes in else when firstNum>=thirdNum
            } else {
                System.out.println("Ordered numbers are: " + thirdNum + "," + firstNum + "," + secondNum);
            } //goes in else when firstNum>=secondNum
        } else
        if (secondNum < thirdNum) {
            if (firstNum < thirdNum) {
                System.out.println("Ordered numbers are: " + secondNum + "," + firstNum + "," + thirdNum);
            } //goes in else when firstNum>=thirdNum
            else {
                System.out.println("Ordered numbers are: " + secondNum + "," + thirdNum + "," + firstNum);
            } //goes in else when secondNum>=thirdNum
        } else {
            System.out.println("Ordered numbers are: " + thirdNum + "," + secondNum + "," + firstNum);
        }
    }
}