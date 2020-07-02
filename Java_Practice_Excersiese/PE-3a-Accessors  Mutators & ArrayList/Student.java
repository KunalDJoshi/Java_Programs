public class Student {
    private String name;
    private String major;
    private double gpa;
    private int student_ID;

    //Constructor of Student class to set values of each attribute
    public Student(String _name, String _major, double _gpa, int _student_ID) {
        this.name = _name;
        this.major = _major;
        this.gpa = _gpa;
        this.student_ID = _student_ID;
    }



    // Getter i.e., Accessor for name
    public String getName() {
        return name;
    }

    // Getter i.e., Accessor for major
    public String getMajor() {
        return major;
    }

    // Getter i.e., Accessor for gpa
    public double getGpa() {
        return gpa;
    }

    // Getter i.e., Accessor for student_ID
    public int getStudent_ID() {
        return student_ID;
    }


    /* // Setter i.e., Mutator for name
    public void setName(String newName)
    {
    this.name=newName;
    } */

    // Setter i.e., Mutator for major
    public void setMajor(String _major) {
        this.major = _major;
    }

    // Setter i.e., Mutator for gpa
    public void setGpa(double _gpa) {
        this.gpa = _gpa;
    }

    /* // Setter i.e., Mutator for student_ID
    public void setStudent_ID(int newStudent_ID)
    {
    this.student_ID=newStudent_ID;
    } */

    /** Return a string representation of this object */
    public String toString() {
        String retVal = "name= " + getName() + ", major= " + getMajor() + ", gpa= " + String.format("%,.2f", getGpa()) + ", student_ID= " + getStudent_ID();
        return retVal;
    }

}