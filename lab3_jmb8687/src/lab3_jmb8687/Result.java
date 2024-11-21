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

/**
 * Result
 * 
 * The reason I created this class was because I really struggled in the begging
 * with UserAccount figuring out a good way to signal if something was successfully
 * or not. Something I ran into pretty early on, was that the email verification
 * could fail for a number of reasons. Creating this custom class allowed for me 
 * to very easily identify what and why it failed.
 * 
 * 
 * @author jwintersbro
 */
public class Result {
    
    public boolean status; // status message true or false. Could have been an int for more complex error codes.
    public String message; // your message to smuggle.

    // Constructor
    Result(boolean inputStatus, String inputMessage) {
        status = inputStatus;
        message = inputMessage;
    }
    
    /**
     * because the variables are public you dont need to have any getters or 
     * setters, though you 100 percent could if needed be.
     */
}
