package lab4_jmb8687;

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
    
    public boolean success; // status message true or false. Could have been an int for more complex error codes.
    public String message; // your message to smuggle.
    private String return_value;

    // Constructor
    Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
    
    public void setValue(String value) { return_value = value; }
    public String getValue() { return return_value; }
}
