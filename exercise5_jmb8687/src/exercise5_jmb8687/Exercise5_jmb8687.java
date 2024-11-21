/*******************************************************************************
* Programmer: Joshua Winters-Brown
* ClassID: jmb8687
* Task 01: Get input from user.
* Task 02: Check against defined number.
* Task 03: Exit loop if input is correct. 
* CIS 2600: Business Application Programming
* Fall 2024
* Due date: 10/15/2024
* Date completed: 10/11/2024
********************************************************************************
* Program Explanation
* This program will begin with a defined loop that has a known number to guess.
* The second part of the program will randomly generate the number to guess
*******************************************************************************/

package exercise5_jmb8687;

import java.util.Scanner; // import scanner to get user input
import java.util.Random; // import random to get random number

public class Exercise5_jmb8687 { 
    static final int RANGE_MAX = 5; // define man number range.
    static final int RANGE_MIN = 0; // define min number range.
    static final int TARGET_NUMBER = 3; // define non random target number
    
    // main loop.
    public static void main(String[] args) {
        guessingGame(); // Guessing Game using non random number.
        randomGuessingGame(); // Guessing Game using random number.
    }

    public static void guessingGame() {
        Scanner userInput = new Scanner(System.in); // initialize our scanner for just this function.
        boolean running = true; // define our running loop status as true.
        int guessedNumber = -1; // define our guessed number. We assign a value thats out of range so that we wont accidentally, provide a number that would immediately be guessed.

        // print beginning message
        System.out.println("guess> Starting guessingGame with fixed number!");
        outOfRangeInput();
        while (running != false) { // run loop while running is anything but false.
            System.out.print("guess> "); // print console header.
            guessedNumber = userInput.nextInt(); // read user input next int.
            
            if(guessedNumber > RANGE_MAX){ outOfRangeInput(); } // check user input is within bounds.
            else if (guessedNumber < RANGE_MIN) { outOfRangeInput(); } // check user input within bounds
            else if (guessedNumber == TARGET_NUMBER) { // check guessedNumber is TARGET_NUMBER
                running = false; // exit the loop, assign running to false
            } 
            // If the code made it here, you have the wrong number, please repeat.         
        } 
        
        System.out.println("\nguess> Congratulations, you guessed the correct number!\n"); 
    }    
    
    // Guessing Game using random number
    public static void randomGuessingGame() {
        Random randomGenerator = new Random(); // initialize random number generator.
        int randomTargetNumber = randomGenerator.nextInt(6); // get random number anything from 0 to 6.
        
        Scanner userInput = new Scanner(System.in); // intialize scanner input.
        
        boolean running = true; // set run loop to true.
        int guessedNumber = -1; // define our guessed number. We assign a value thats out of range so that we wont accidentally, provide a number that would immediately be guessed.
        
        System.out.println("guess> Starting game with random number!"); // Print notification
        outOfRangeInput();
        while (running != false) { // run loop while running is anything but false.
            System.out.print("guess> "); // enter console mark.
            guessedNumber = userInput.nextInt(); // get input from user.
            
            if(guessedNumber > RANGE_MAX){ outOfRangeInput(); } // check input is within range max
            else if (guessedNumber < RANGE_MIN) { outOfRangeInput(); } // check input is within range min.
            else if (guessedNumber == randomTargetNumber) { running = false; } // check input is target number, if so set running to false.
        }
        // Congratulations you won!
        System.out.println("\nguess> Congratulations, you guessed the correct number!");
    }

    // out of range function
    public static void outOfRangeInput() {
        // print error message
        System.out.println("guess> Please guess a number that is greater than " + RANGE_MIN + " and less than " + RANGE_MAX + "."); // print mark using range min and rang max.
    }

}
