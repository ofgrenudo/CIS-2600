/*******************************************************************************
* Programmer: Joshua Winters-Brown
* ClassID: jmb8687
* Task 01: Gather input from user.
* Task 02: Calculate BMI.
* Task 03: Print out BMI in a nice format. 
* CIS 2600: Business Application Programming
* Fall 2024
* Due date: 09/20/24
* Date completed: 09/19/24
********************************************************************************
* Program Explanation
* This program will run, and take 4 variables. The users name, age, weight, and 
* height. Once its take all of these parameters, it will then calculate the 
* users BMI.
*******************************************************************************/

// Import the Scanner class to allow for us to get input from the user
import java.util.Scanner; 

// Define the class, Program
public class Program {
    
    // Declare global variables below
    static String   name;    // Create a string variable called name.
    static int      age;        // Create a integer variable called age.
    static double   weight;  // Create a double variable called weight. Note it must be a double to store fractional numbers.
    static double   height;  // Create a double variable called height. Note it must be a double to store fractional numbers.
    static double   BMI;     // Create a double variable called BMI. Note it must be a double to store fractional numbers.
    static Scanner  reader = new Scanner(System.in); //I Initialize and create a new scanner called reader.
    
    // Create a function called main, that takes a argument String[] args
    public static void main(String[] args) {
        System.out.println("**************************************"); // print beautifying mark.
        
        System.out.print("** Please enter your name  : "); // print string requesting name.
        name = reader.nextLine(); // read next line as string stored under name.
        
        System.out.print("** Please enter your age   : "); // print string requesting age.
        age = reader.nextInt(); // read next line as an int.
        
        System.out.print("** Please enter your weight: "); // print string requesting weight.
        weight = reader.nextDouble(); // read next line as double.
        
        System.out.print("** Please enter your height: "); // print string reuqesting height.
        height = reader.nextDouble(); // read next line as double.
        
        System.out.println("**************************************"); // print beautifying mark.
        
        BMI = calculateBMI(weight, height); // Call on our method, and pass the arguemtns weight and height.
        System.out.println("\nYour BMI is: " + BMI); // print out returned calculated BMI.
    }
        
    /* 
    *   Create a function called BMI, that takes an input_weight and an input_height
    *   both as a double. Then calculates the BMI of the individual. Note this method
    *   takes input in american units so LB and IN.
    *
    *   To Calculate the BMI we must do the following:
    *       BMI = weight / height^2
    *   
    *   Note the signature is a double. It is this way because we will want to return
    *   the calculated BMI.
    */
    public static double calculateBMI(double input_weight, double input_height){
        // Because there is no square function in java, we can recieve the same result
        // by multiply the item against its self.
        double input_height_squared = input_height * input_height;
        // Here we will calculate the temporary BMI using the new input_height_squared
        // variable. I suppose we could have just returned the result of this operation
        // but why not just save it? Do we lose anything or does it cause an ineficiency.
        double tempBMI = input_weight / input_height_squared * 703;
        // Finally, return our stored variable.
        return tempBMI;
    }  
    
}
