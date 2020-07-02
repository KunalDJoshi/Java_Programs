import java.util.ArrayList;
public class TestStudent {
    public static void main(String args[]) {
        Student s1 = new Student("Jay Can", "CS", 4.00, 1123);
        Student s2 = new Student("Ed Holdum", "SE", 3.45, 3256);
        Student s3 = new Student("Mike Floatsman", "IST", 3.53, 7765);
        Student s4 = new Student("Kunal Joshi", "IST", 4.00, 3220);


        /* System.out.println("s1:"+s1.getName()+
                                 s1.getMajor()+
        						 s1.getGpa()+
        						 s1.getStudent_ID()); */
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);

        /* Student Student1=new Student("Jay Can","CS",4.00,1123);
        Student1.gpa=3.66; */

        //Changing Jay Can's major to IST 
        s1.setMajor("IST");
        System.out.println("New record after Changing Jay Can's major to IST: " + s1);

        //System.out.println(s2.setGpa(getGpa()));

        //creating arraylist of objects of Student class
        ArrayList < Student > al = new ArrayList < Student > ();
        al.add(s1); //adding Student class object  
        al.add(s2);
        al.add(s3);
        al.add(s4);

        System.out.println("Printing all the objects' information implicitly using toString and for each loop:");
        //Traversing the arraylist using for each loop
        for (Student s: al) {
            System.out.println(s.toString());
        }

        for (Student s: al) {
            if (s == s2) {
                System.out.println("After adding 0.1 to Ed Holdum's GPA: " + String.format("%,.2f", s2.getGpa() + 0.1));
            }

        }
    }
}