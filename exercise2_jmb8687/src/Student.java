package exercise3_jmb8687;

// Create new class student
public class Student {
    private int year; // create int variable to store year.
    private String major; // create string variable to store major.
    private double GPA; // create double variable to store major.
    
    private static String defaultMajor = "UND";
    private static double defaultGPA = 0.0;
    
    // Constructor with all three requirements.
    public Student(int inYear, String inMajor, double inGPA){
        year = inYear;
        major = inMajor;
        GPA = inGPA;
    }

    // Constructor with only year and major.
    public Student(int inYear, String inMajor){
        year = inYear;
        major = inMajor;
        GPA = defaultGPA;
    }
    
    // Constructor with only year.
    public Student(int inYear){
        year = inYear;
        major = defaultMajor;
        GPA = defaultGPA;
    }
    
    public int getYear(){return year;} //return year.
    public String getMajor(){return major;} //return major.
    public double getGPA(){return GPA;} //return gpa.
    
    public int setYear(int input){year = input; return 1;} //set year then return 1 as success code.
    public int setMajor(String input){major = input; return 1;}//set major then return 1 as success code.
    public int setGPA(int input){GPA = input; return 1;}//set gpa then return 1 as success code.
}
