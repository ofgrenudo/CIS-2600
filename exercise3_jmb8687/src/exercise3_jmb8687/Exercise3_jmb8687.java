package exercise3_jmb8687;

/*******************************************************************************
* Programmer: Joshua Winters-Brown
* ClassID: jmb8687
* Task 01: Create Student.Java.
* Task 02: Define default Student values.
* Task 03: Create default Constructor.
* Task 04: Define overloaded constructor methods.
* CIS 2600: Business Application Programming
* Fall 2024
* Due date: 10/4/24
* Date completed: 10/3/24
********************************************************************************
* Program Explanation
* This exercise is to demonstration my abbility to create classes as well as my 
* abbility to overload functions.
*******************************************************************************/

import exercise3_jmb8687.Student; // import our class Student from exercise3_jmb8687

public class Exercise3_jmb8687 {

    public static void main(String[] args) {
        Student joe = new Student(1); // testing year only constructor
        Student shmo = new Student(3, "MAT"); // testing year and major constructor
        Student doe = new Student(3, "ICS", 3.6); // testing year, major and gpa constructor.
        
        System.out.print("Student 1\n==========\n"); // print beautifying mark
        joe.printStats(); // run student class printStats method
        System.out.print("Student 2\n==========\n"); // print beautifying mark
        shmo.printStats(); // run student class printStats method
        System.out.print("Student 3\n==========\n"); // print beautifying mark
        doe.printStats(); // run student class printStats method
    }
    
}
