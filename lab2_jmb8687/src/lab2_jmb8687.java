/*******************************************************************************
* Programmer: Joshua Winters-Brown
* ClassID: jmb8687
* CIS 2600: Business Application Programming
* Fall 2024
* Due date: 10/27/24
* Date completed: 10/27/24
********************************************************************************
* Program Explanation
* This program will call on CreatePurchase to make a new purchase of an object.
* It will run for as many purchase as you would like and will gracefully exit when
* you desire.
*******************************************************************************/
import java.util.Scanner; // import scanner tool.

// my main java file.
public class lab2_jmb8687 {

    // main function
    public static void main(String[] args) {
        boolean running = true; // set loop condition
        Scanner myScanner = new Scanner(System.in); // make scanner for user input
        
        // start loop while running is true
        while(running) {
            System.out.println("\n\n\n\n\n\n\n\n"); // comment a bunch of new lines to make spaces.
            System.out.println("Welcome to Lab 2!"); // print welcome
            System.out.println("Please enter the number of the operation you would like to run!"); // print
            System.out.println(" 0 > Purchase New Item"); // print option
            System.out.println(" 9 > Exit Program"); // print option
            System.out.println(""); // print new line for space

            System.out.print("lab2> "); // print console input
            int operationInput = myScanner.nextInt(); // get the next number the user provides.
            
            // switch to compare the two options we support
            switch (operationInput) {
                case 0 -> { // if user provided 0 do this
                    CreatePurchase newPurchase = new CreatePurchase(); // we create a new purchase object.
                    newPurchase.run(); // we run the CreatePurchase loop.
                } // end option 0
                case 9 -> running = false; // if user selected 9 they want to exit the program. Change running to false.
            }
        }
    }
}
