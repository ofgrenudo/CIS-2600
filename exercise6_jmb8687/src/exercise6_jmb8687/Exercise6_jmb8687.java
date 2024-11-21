/*******************************************************************************
* Programmer: Joshua Winters-Brown
* ClassID: jmb8687
* CIS 2600: Business Application Programming
* Fall 2024
* Due date: 11/8/24
* Date completed: 11/7/24
********************************************************************************
* Program Explanation
* 
* This Java program demonstrates two ways to iterate through an array of 15 U.S.
* states. First, it uses an enhanced for loop to print the states in standard 
* (first-to-last). Then, it uses a traditional for loop to print the states in 
* reverse order (last-to-first).
*******************************************************************************/

package exercise6_jmb8687;

import java.util.Scanner; // import scanner!

public class Exercise6_jmb8687 {
    // Create array of strings for program!
    public static final String[] states = {
        "California",
        "Texas",
        "Florida",
        "New York",
        "Pennsylvania",
        "Illinois",
        "Ohio",
        "Georgia",
        "North Carolina",
        "Michigan",
        "New Jersey",
        "Virginia",
        "Washington",
        "Arizona",
        "Massachusetts"
    };
    
    public static Scanner scanner = new Scanner(System.in); // create scanner!
    
    public static void main(String[] args) {
        System.out.println("Using Enhanced For Loop");
        for (String state: states) { // enhanced loop!
            System.out.print(state + ", "); // Print state then comma, then iterate!
        }
        
        {
//            System.out.print("\n\nPress Enter to Continue");
//            String _ = scanner.nextLine();
            System.out.println("\n\n"); // give space
        }

        System.out.println("Using Standard For Loop");
        for(int x = states.length - 1; x > -1; x--){ // standard loop starting from max, then down
            // note I must remove 1 value from the length, because it counts from 1, but java indexes from 0.
            System.out.print(states[x] + ", "); // print the state, then comma, then iterate!
        }
        
    }
    
}
