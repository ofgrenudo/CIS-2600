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

public class CreateUserAccount {

    int MAX_USER_ACCOUNTS = 20; // set max user accounts as a variable
    static Scanner scanner = new Scanner(System.in); // create our scanner object.
    UserAccount[] allUsers = new UserAccount[MAX_USER_ACCOUNTS]; // create our database allUsers.
    
    // do nothing. Provides a constructor. Not used.
    public CreateUserAccount(){
    }
    
    /**
     * addUser essentially is the buisness logic that goes through and adds the user
     * to the allUsers array or our "Database".
     */
    public void addUser(){
        int currentObjectsInArray = objectsInArray(allUsers); // call our helper function and get the current objects in array that are not null.
        if (currentObjectsInArray < 20) { // ensure the array is under 20 to add an account
            UserAccount tempAccount = new UserAccount(); // not needed.
            
            String inputFirst; // placeholder
            String inputLast; // placeholder
            String inputEmail; // placeholder
            String inputPassword; // placeholder
            
            
            // get user input
            System.out.print("First Name = ");
            inputFirst = scanner.nextLine(); 
            
            // get user input
            System.out.print("Last Name = ");
            inputLast = scanner.nextLine();
                        
            // get user input
            System.out.print("Email = ");
            inputEmail = scanner.nextLine();
            
            // get user input
            System.out.print("Password = ");
            inputPassword = scanner.nextLine();
            
            Result resultEmail; // placeholder

            if (!isEmailInDatabase(inputEmail)) { // confirm the email is unique. Call helper function.
                Result resultFirst = tempAccount.setFirstName(inputFirst); // store result of setting function
                Result resultLast  = tempAccount.setLastName(inputLast); // store result of setting function
                Result resultPassword = tempAccount.setPassword(inputPassword); // store result of setting function
    
                resultEmail = tempAccount.setEmailAddress(inputEmail);   // store result of setting function
            
                if (!resultFirst.status) { System.out.println(resultFirst.message); } // honestly if that status is not true just tweak out
                if (!resultLast.status) { System.out.println(resultLast.message); } // honestly if that status is not true just tweak out
                if (!resultEmail.status) { // honestly if that status is not true just tweak out
                    while (!resultEmail.status) { // actually maybe fix it.
                        give_me_space(); // I cant give you the stars and moons, but i can give you about 50 new lines.
                        System.out.println(resultEmail.message); // tweak out fr now.
                        System.out.print("Email = "); // politely ask you to update the email.
                        inputEmail = scanner.nextLine(); // uhmm..
                        resultEmail = tempAccount.setEmailAddress(inputEmail); // try again?                    
                    }
                }
                if (!resultPassword.status) { System.out.println(resultPassword.message); } // honestly if that status is not true just tweak out

                allUsers[currentObjectsInArray] = tempAccount; // update database.

                viewUser(currentObjectsInArray); // view commited user.

            } else { // emails already been used.
                String message = "\n\n\nEmail is already in database. Did not create account!";
                resultEmail = new Result(true, message); // legacy? i return void here not result lol.
                System.out.println(message); // tweak out? Why did i create a result here? Must be legacy from when I was doing something else.
            }
        }
        else { // womp womp, the user database is over 20 accounts
            System.out.println("\n\tThe database is currently full. I am unable to create a new account.");
            pause(); // https://www.tiktok.com/@iammjonezy/video/7431271135628594475
        }
    }
    
    /**
     * searchUserByEmail is a buisness logic loop for finding and modifying a user.
     */
    public void searchUserByEmail() {
        // get email of user you want to modify
        System.out.print("Enter User Email : ");
        String inputEmail = scanner.nextLine();
        
        System.out.println("");
        
        Result validEmailAddress = checkEmailAddress(inputEmail); // confirm email is real, theres a weird bug,
        // where if you provide a non email, it will get caught in a loop of looking for the email address...
        
        // confirm the status is true
        if (validEmailAddress.status) {
            viewUser(inputEmail); // return the user information row.
            modifyUser(inputEmail); // send to modifyUser function
        } else { // you didnt enter a valid email.
            System.out.println("Please enter a valid email address");
            pause();
        }
    }
    
    /**
     * isEmailInDatabase essentially is returning a status code of weather or not 
     * the email has already been used or not.
     * @param email
     * @return 
     */
    public boolean isEmailInDatabase(String email) { // takes email address as an input.
        for (int x = 0; x < allUsers.length; x++){ // standard for loop, could be done better with a enhanced for loop.
            if (allUsers[x] != null) { // confirm again that the placeholder is not null.
                String currentUserEmail = allUsers[x].getEmailAddress(); // get the email address to variable for simplicity.
                if (currentUserEmail.equals(email)) { // check that the email address is valid
                    return true; // return true.
                }
            }
        }
        return false; // did not find email.
    }
    
    /**
     * viewAllUsers will essentially go through and find each user and print the 
     * information out in a predefined way.
     */
    public void viewAllUsers() {
        // Iterate through all users.
        // Sort all users by Last Name
        // Display users and emails.
        // Some how allow user to hook into modify or view user.
        for (int x = 0; x < allUsers.length; x++) {
//            System.out.println(x + " " + allUsers.length);
            if (allUsers[x] != null) {
                viewUser(x); // call our helper function viewUser.
            }
        }
    }
    
    /**
     * viewUser(email) is the original method that i created that would search for 
     * the user and print out the information, but I figured I could extrapulate the
     * printing part to something simpler, so viewUser(ArrayLocation) is the part that
     * actually prints the data for you.
     * @param email 
     */
    public void viewUser(String email){
        // View Specific User Information
        // Some how allow user to hook into modify user.
        for (int x = 0; x < allUsers.length; x++){
            if (allUsers[x] != null) {
                String currentUserEmail = allUsers[x].getEmailAddress();
                if (currentUserEmail.equals(email)) {
                    viewUser(x); // call our helper function.
                }
                
            }
        }
    }
    
    /**
     * viewUser(ArrayLocation) used to be combined with the viewUser(email) function
     * but I extrapulated this half of the code, since in other places I would already 
     * have the ArrayLocation. Essentially this is like a displayUser function.
     * @param ArrayLocation 
     */
    public void viewUser(int ArrayLocation) {
        // View Specific User Information
        
        System.out.print(" | " + (ArrayLocation + 1) + " |\t");
        System.out.print(" | First Name | " + this.allUsers[ArrayLocation].getFirstName() + " |\t");
        System.out.print(" | Last Name | " + this.allUsers[ArrayLocation].getLastName() + " |\t");
        System.out.print(" | Email |" + this.allUsers[ArrayLocation].getEmailAddress() + " |\t\n");
    }
    
    /**
     * modifyUser(email) essentially is a buisness logic loop that will go through
     * and confirm the data you provide it as well as update the object in place of 
     * the array location.
     * 
     * @param email 
     */
    public void modifyUser(String email) {
        // Get prompt to modify user.
        System.out.print("\nWould you like to modify user the user? (Y/N): ");
        String inputModificationRequest = scanner.nextLine();
        
        // confirm that the user said yes.
        if (inputModificationRequest.toUpperCase().equals("Y")) {
            String newInputEmail;  // placeholder
            String newInputFirstName; // placeholder
            String newInputLastName; // placeholder
            String newInputPassword; // placeholder
            
            // find the object location in the user database
            int objectPlaceInDatabase = getObjectPlaceInArray(email);
            UserAccount targetUser = allUsers[objectPlaceInDatabase];            
            
            // get email address changes
            System.out.print("Leave any value empty and it will be ommitted!\n\nEmail (" + targetUser.getEmailAddress() + ") : ");
            newInputEmail = scanner.nextLine();

            // get first name changes
            System.out.print("\nFirst Name (" + targetUser.getFirstName() + "): ");
            newInputFirstName = scanner.nextLine();
            
            // get last name changes
            System.out.print("\nLast Name (" + targetUser.getLastName() + ") : ");
            newInputLastName = scanner.nextLine();
            
            // get password changes
            System.out.print("\nPassword (" + targetUser.getPassword() + ") : ");
            newInputPassword = scanner.nextLine();  
            
            // check if email address is not empty
            if(!newInputEmail.strip().equals("")) { // note I had to strip the input, because i was getting werid behavior where '\n' == ""
                if(isEmailInDatabase(newInputEmail)){ // Check for duplicate emails. If it is a duplicate do the following below.
                    System.out.println("\n\tThere was an error updating the email address, please try again..."); 
                    pause(); 
                }
                else { targetUser.setEmailAddress(newInputEmail); } // email is not duplicate. Update email.
            }
            
            // check if first name is not empty
            if(!newInputFirstName.strip().equals("")) { // note I had to strip the input, because i was getting werid behavior where '\n' == ""
                targetUser.setFirstName(newInputFirstName); // update value
            }
            
            // check if last name is not empty
            if(!newInputLastName.strip().equals("")) { // note I had to strip the input, because i was getting werid behavior where '\n' == ""
                targetUser.setLastName(newInputLastName); // update value
            }
            
            // check if password is not empty
            if(!newInputPassword.strip().equals("")) { // note I had to strip the input, because i was getting werid behavior where '\n' == ""
                targetUser.setPassword(newInputPassword); // update value
            }
        }
    }

    /** Helper Functions
     * The functions below are to help aid in writing the program. These functions
     * are commonly called or heavily reproduced code extracted to a function to save
     * my fingies from typing so much.
     */ 
    
    /**
     * objectsInArray accepts an array of UserAccounts, and will iterate through
     * the array, determining the "real" ammount of objects. The reason we have 
     * to do this is because we are statically setting the size of our array to 
     * twenty. So when we would call inputArray.length it would return twenty
     * even though all twenty spaces in the array could be "null".
     */
    private int objectsInArray(UserAccount[] inputArray){
        int objectsInArrayCount = 0; // Set Flag to 0.
        for (int x = 0; x < inputArray.length; x++) { // Standard for loop.
            if (inputArray[x] == null) { // check if the array spot is null.
                ; // do nothing :() womp womp.
            } else { 
                objectsInArrayCount++; //increment our flag!
            }
        }
        
        return objectsInArrayCount; // returns the next "null" space in the array.
    }
    
    /**
     * getObjectPlaceInArray accepts a string that should be the equivalent of
     * the email you want to search for. We then, weill go through each space in 
     * the array and check that its not null, and if it is not null, then we grab
     * its email and compare it to the email you provided earlier.
     */
    private int getObjectPlaceInArray(String email) {
        int flag = -1; // set our flag
        while(flag == -1) { // run while flag is -1.
            for (int x = 0; x < allUsers.length; x++){ // iterate through all users.
                if (allUsers[x] != null) { // check all users is not null.
                    String currentUserEmail = allUsers[x].getEmailAddress(); // get email address of array space.
                    if (currentUserEmail.equals(email)) { // compare emails.
                        flag = x; // if the emails are true, modify the flag to the space we are in the array.
                    }
                }
            }            
        }
        
        return flag; // return the space we were in the array.
        // Note we had to put this here, because theres a possibility if i put it in the If statement
        // above that it would never execute if we ran this with an initially empty database.
    }
    
    /**
     * seedUserAccount creates a UserAccount object with predefined "seed"
     * values for first name, last name, and password, while accepting a
     * specific email. This is helpful for testing or initial population of the
     * database with sample data.
     */
    public UserAccount seedUserAccount(String email) {
        // Create a new UserAccount object
        UserAccount seed = new UserAccount();

        // Temporary variable to capture the result of each setter method (unused here)
        Result _waste;

        // Set seed data for first name, last name, email, and password
        _waste = seed.setFirstName("seedFirstName");  // setting first name as "seedFirstName"
        _waste = seed.setLastName("seedLastName");    // setting last name as "seedLastName"
        _waste = seed.setEmailAddress(email);         // using the email parameter for the email address
        _waste = seed.setPassword("seedPassword");    // setting password as "seedPassword"

        // Determine the current number of non-null objects in the array
        int currentObjectsInArray = objectsInArray(allUsers);

        // Place the new seed account in the next available position in the array
        allUsers[currentObjectsInArray] = seed;

        // Return the seeded user account for further operations if needed
        return seed;
    }

    /**
     * seedManyUserAccounts generates multiple seeded user accounts. Each
     * account receives a unique email address based on the loop counter, while
     * other fields are populated with default seed values. Useful for quickly
     * populating the database.
     */
    public void seedManyUserAccounts(int numberOfAccounts) {
        // Loop to create and add a specific number of seeded accounts
        for (int x = 0; x < numberOfAccounts; x++) {
            // Generate a unique email for each account by appending the loop counter
            String email = "test" + x + "@gmail.com";

            // Call seedUserAccount to create and add the user account with this email
            seedUserAccount(email);
        }
    }
        
    /**
     * checkEmailAddress verifies whether the provided email address contains an
     * '@' symbol. This simple validation checks for the presence of '@' to
     * determine if the email has a basic valid format.
     */
    private Result checkEmailAddress(String emailAddress) {
        // Check if the '@' symbol is present in the emailAddress string
        int containsOneOrMoreAtSymbol = emailAddress.indexOf("@");

        // If '@' symbol is found, create a Result indicating success with a message
        if (containsOneOrMoreAtSymbol > -1) {
            Result result = new Result(true, "Email address contains @ symbol.");
            return result;
        } else {
            // If '@' symbol is not found, create a Result indicating failure with a message
            Result result = new Result(false, "Email address does NOT contain @ symbol.");
            return result;
        }
    }

    /**
     * give_me_space outputs a large block of empty lines to visually separate
     * sections in the console output. This can be useful for improving
     * readability when displaying information to the user by creating a "clear
     * screen" effect.
     */
    public static void give_me_space() {
        // Print multiple new lines to create a large empty space in the console
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    /**
     * pause temporarily halts the program until the user presses Enter. This is
     * useful for allowing the user to review information displayed on the
     * console before moving on to the next operation.
     */
    public static void pause() {
        // Prompt the user to press Enter to continue
        System.out.println("\nPress Enter to Continue");

        // Capture the Enter key press to pause execution until the user provides input
        String _waste = scanner.nextLine();
    }
}
