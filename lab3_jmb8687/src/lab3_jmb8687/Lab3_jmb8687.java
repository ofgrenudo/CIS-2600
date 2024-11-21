/*******************************************************************************
* Programmer: Joshua Winters-Brown
* ClassID: jmb8687
* CIS 2600: Business Application Programming
* Fall 2024
* Due date: 11/15/24
* Date completed: 11/13/24
********************************************************************************
* Program Explanation
* 
* The point of this program is to be able to create a database and allow for the 
* user to create, and update user accounts but *not* for them to be able to delete
* the accounts they create. Only update them.
*******************************************************************************/

package lab3_jmb8687;

import java.util.Scanner;

public class Lab3_jmb8687 {
    
    static Scanner scanner = new Scanner(System.in); // create scanner object
    
    // main entry of program.
    public static void main(String[] args) {
        boolean running = true; // set our running flag.
        CreateUserAccount accountManager = new CreateUserAccount(); // create our object for sanity purposes.
                
        // run while true.
        while (running) {
            accountManager.give_me_space(); // give me space.
            
            // print menu
            System.out.println("""
                               Account Manager
                               1 > Create New Account
                               2 > View All Users
                               3 > Search User via Email
                               4 > Modify Users

                               9 > Quit!
                               """);
            
            // console prompt
            System.out.print("account_manager > ");

            // get option
            int userOption = scanner.nextInt();
            
            // compare our input
            switch (userOption) {
                case 0: // Seed Database.
                    accountManager.seedManyUserAccounts(20);
                    break;
                case 1: // Create New Account
                    accountManager.addUser();
                    break;
                case 2: // View All Users
                    System.out.println("");
                    accountManager.viewAllUsers();
                    accountManager.pause();
                    break;
                case 3: // Modify Users
                    accountManager.searchUserByEmail();
                    break;
                case 4:
                    System.out.println("");
                    accountManager.viewAllUsers();
                    System.out.println("");
                    accountManager.searchUserByEmail();
                    break;
                case 9:
                    running = false; // set running to false.
                    break;
            }            
        }
        
        // Exiting Loop, gracefully exit program... right?
        
    }    
}
