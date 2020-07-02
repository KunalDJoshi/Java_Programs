import java.util.*;
public class CalculateGPA
{
public static void main(String[] args)
{
// int A=4;
// int a=4;
// int B=3;
// int b=3;
// int C=2;
// int c=2;
// int D=1;
// int d=1;
// int F=0;
// int f=0;
int A,a=4;
int B,b=3;
int C,c=2;
int D,d=1;
int F,f=0;
int totCredits=0;
int totGrades=0;


Scanner scan = new Scanner(System.in);
System.out.println("Enter Credits for course 1:");
int credC1 = scan.nextInt();
System.out.println("Enter grade for course 1:");
char gradeC1 = scan.next().charAt(0);
System.out.println("Enter Credits for course 2:");
int credC2 = scan.nextInt();
System.out.println("Enter grade for course 2:");
char gradeC2 = scan.next().charAt(0);
System.out.println("Enter Credits for course 3:"); 
int credC3 = scan.nextInt();
System.out.println("Enter grade for course 3:");
char gradeC3 = scan.next().charAt(0);
System.out.println("Enter Credits for course 4:");
int credC4 = scan.nextInt();
System.out.println("Enter grade for course 4:");
char gradeC4 = scan.next().charAt(0);
//System.out.println("Entered:"+ credC1+ ""+gradeC1);

int course1=0;
int course2=0;
int course3=0;
int course4=0;

//To calculate total number of points
course1=credC1*gradeC1;
course2=credC2*gradeC2;
course3=credC3*gradeC3;
course4=credC4*gradeC4;
System.out.println("course1: "+course1);

int[] credits={credC1,credC2,credC3,credC4};
char[] grades={gradeC1,gradeC2,gradeC3,gradeC4};

//To calculate total number of credits
for(int i:credits)
{
System.out.println(i);
totCredits=totCredits+i;
}
System.out.println("Total number of credits: "+totCredits);


// int course1=0;
// int course2=0;
// int course3=0;
// int course4=0;
// 
// //To calculate total number of points
// course1=credC1*gradeC1;
// course2=credC2*gradeC2;
// course3=credC3*gradeC3;
// course4=credC4*gradeC4;
// System.out.println("course1: "+course1);


}
}


