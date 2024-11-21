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

public class UserAccount {
    /**
     * UserAccount.java: Your object class used to create each of the 20 potential 
     * user account objects. Each contains a name, email address, and password. 
     * This is from Exercise 5A (pp. 321). 
     */
    private String first_name;
    private String last_name;
    private String email_address;
    private String password;
    
    // do nothing constructor
    public void UserAccount() {
        ;
    }
    
    // getters
    public String getFirstName(){ return first_name; } 
    public String getLastName() { return last_name; }
    public String getEmailAddress() { return email_address; }
    public String getPassword() { return password; }
    
    // setters return result.
    public Result setFirstName(String input){ 
        first_name = input; 
        
        Result result = new Result(true, "Successfully Set First Name");
        return result;
    }

    // setters return result.
    public Result setLastName(String input) {
        last_name = input;
        
        Result result = new Result(true, "Successfully Set Last Name");
        return result;
    }
    
    // setters return result.
    public Result setEmailAddress(String inputEmailAddress) {
        Result validEmailAddress = checkEmailAddress(inputEmailAddress); // confirm the email contains a @ symbol. 
        
        if (validEmailAddress.status) { // confirm result.
            email_address = inputEmailAddress;
            Result result = new Result(true, "Successfully Set Email Address");        
            return result;
        } else { // result was bad, return a bad result our selves.
            Result result = new Result(false, "Please confirm, you submitted a valid email address");
            return result;
        }
    }
    
    // set password
    public Result setPassword(String inputPassword) { 
        password = inputPassword;
        
        Result result = new Result(true, "Successfully Set Password");
        return result;
    }
    
    // Helper Functions
    /**
     * checkEmailAddress verifies whether the provided email address contains an
     * '@' symbol. This simple validation checks for the presence of '@' to
     * determine if the email has a basic valid format.
     * 
     * **NOTE** this is a bit of redundant code. It is also present in CreateUserAccount.
     * There was no good way to expose this without making another file like helper functions
     * or something. Im not sure how to to do this correctly.
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
}
