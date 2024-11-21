package exercise3_jmb8687;

// Create new class student
public class Student {
    private int year; // create int variable to store year.
    private String major; // create string variable to store major.
    private double GPA; // create double variable to store major.
    
    private static String defaultMajor = "UND"; // create default major. UND for undecidied.
    private static double defaultGPA = 0.0; // create default gpa. 0.0.
    
    // Constructor with all three requirements.
    public Student(int inYear, String inMajor, double inGPA){
        year = inYear; // assign year.
        major = inMajor; // assign major.
        GPA = inGPA; // assign default gpa.
    }

    // Constructor with only year and major.
    public Student(int inYear, String inMajor){
        year = inYear; // assign year.
        major = inMajor; // assign major.
        GPA = defaultGPA; // assign default gpa.
    }
    
    // Constructor with only year.
    public Student(int inYear){
        year = inYear; // assign year.
        major = defaultMajor; // assign major with default major.
        GPA = defaultGPA; // assign gpa with default gpa.
    }
    
    // this method saves me time when printing year and gpa.
    public void printStats(){
        System.out.println("Year: " + year + "\tMajor: " + major + "\tGPA: " + GPA + "\n"); // print stats out in repeatable way.
    }
    
    public int getYear(){return year;} //return year.
    public String getMajor(){return major;} //return major.
    public double getGPA(){return GPA;} //return gpa.
    
    public int setYear(int input){year = input; return 1;} //set year then return 1 as success code.
    public int setMajor(String input){major = input; return 1;}//set major then return 1 as success code.
    public int setGPA(int input){GPA = input; return 1;}//set gpa then return 1 as success code.
}
