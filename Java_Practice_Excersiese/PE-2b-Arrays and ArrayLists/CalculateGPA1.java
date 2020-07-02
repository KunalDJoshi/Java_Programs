import java.util.*;
public class CalculateGPA1
{
public static void main(String[] args)
{


double totCredits=0;
double totPoints=0;

int course1=0;
int course2=0;
int course3=0;
int course4=0;
final int COURSES=4;
int[] grade_to_points=new int[COURSES];
double GPA;


int[] credits=new int[COURSES];     
char[] grades=new char[COURSES];   

Scanner scan = new Scanner(System.in);

for(int ctr=0;ctr<credits.length;ctr++)
{
	
	System.out.println("Enter credits for course " +(ctr+1)+ ": ");
	credits[ctr] = scan.nextInt();
	System.out.println("Enter grades for course " +(ctr+1)+ ": ");
	grades[ctr] = scan.next().charAt(0);	
}


//To calculate total number of credits
for(int i:credits)
{
System.out.println(i);
totCredits=totCredits+i;
}
System.out.println("Total number of credits: "+(int)totCredits);

for(int ctr=0;ctr<credits.length;ctr++)
{
if(grades[ctr]=='A'||grades[ctr]=='a')
{
 grade_to_points[ctr]=4;
}
else if(grades[ctr]=='B'||grades[ctr]=='b')
{
 grade_to_points[ctr]=3;	
}
else if(grades[ctr]=='C'||grades[ctr]=='c')
{
 grade_to_points[ctr]=2;	
}		
else if(grades[ctr]=='D'||grades[ctr]=='d')
{
 grade_to_points[ctr]=1;	
}
else if(grades[ctr]=='F'||grades[ctr]=='f')
{
 grade_to_points[ctr]=0;	
}
}

//To calculate total number of points

 for(int ctr=0;ctr<COURSES;ctr++)
{
		  totPoints=totPoints+credits[ctr]*grade_to_points[ctr];  
}

System.out.println("Total number of points: "+(int)totPoints);

//To calculate GPA

GPA=(totPoints/totCredits);
System.out.println("GPA :" +GPA);

}
}


