
import javax.swing.JOptionPane;

/*******************************************************************************
* Programmer: Joshua Winters-Brown
* ClassID: jmb8687
* Task 01: Print to console desired output
* Task 02: Open dialog window with desired output
* CIS 2600: Business Application Programming
* Fall 2024
* Due date: 09/10/24
* Date completed: 09/10/24
********************************************************************************
* Program Explanation
* This program will run, and output into console, hello wmu! as well as display
* content in a java dialog window.
*******************************************************************************/

public class program {

    public static void main(String[] args) {
        // Output to consol a constant string.
        System.out.print("Hello WMU!\nJoshua D Winters-Brown\nWelcomes you to Java.");
        
        // Create an JOptionPane object named dialog_box and-
        // initiate a new instance of the class JOptionPane.
        JOptionPane dialog_box = new JOptionPane();
        
        // Call on the JOptionPane class method showMessageDialog
        // Pass the dialog_box variable we created earlier as well as-
        // The string we want to pass to the shoMessageDialog function on our object.
        JOptionPane.showMessageDialog(dialog_box, "This is my first dialog\nwelcomes you to Java.");
    }
    
}
