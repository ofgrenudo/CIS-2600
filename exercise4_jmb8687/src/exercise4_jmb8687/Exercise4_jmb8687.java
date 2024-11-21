/*******************************************************************************
* Programmer: Joshua Winters-Brown
* ClassID: jmb8687
* Task 01: Get input sales from user.
* Task 02: Calculate sales commission.
* Task 03: Print out commission. 
* CIS 2600: Business Application Programming
* Fall 2024
* Due date: 10/15/2024
* Date completed: 10/11/2024
********************************************************************************
* Program Explanation
* This program will run, and get sales from user. Then calculate the commission
* that they will recieve.
*******************************************************************************/

package exercise4_jmb8687;

// Import the Scanner class to allow for us to get input from the user
import java.util.Scanner; 

public class Exercise4_jmb8687 {
    private static final double highCommissionBarrier = 5000; // set static commission barrier
    private static final double lowCommissionBarrier = 3000; // set static commission barrier
    
    private static final double highCommissionRate = 0.2; // set static commission rate
    private static final double lowCommissionRate = 0.1; // set static commission rate

    static Scanner  reader = new Scanner(System.in); //I Initialize and create a new scanner called reader.

    public static void main(String[] args) {
        // print initial wall of text.
        System.out.println("""
                           With weekly sales between $3000 and $4999.99
                           you recieve 10% commission. With sales of $5000
                           or more you recieve 20% commission.
                           
                           We will calculate your commission for this week.
                           =================================================
                           """);
        
        // print input question.
        System.out.print("How much sales did you do this week? $");
        
        // get input from user.
        double salesMadeThisWeekInput = reader.nextDouble(); // read next line as string stored under name.
        System.out.println("================================================="); // beautifying mark
        System.out.println("Total Weekly Sales: " + salesMadeThisWeekInput); // output what we recieved.
        getCommission(salesMadeThisWeekInput); // run get commission rate.
    }
    
    // get commission function, signature requires a dobule of money made this period.
    public static void getCommission(double sales_this_period) {
        if (sales_this_period >= lowCommissionBarrier) { // check if sales this period is greater than or equal to lowCommissionBarrier.
            if (sales_this_period >= highCommissionBarrier) { // check if sales this period is greater than or equal to highCommissionBarrier.
                double commission = sales_this_period * highCommissionRate; // sales is greaterthan or equal to highCommissionBarrier, so we calculate our 
                System.out.println("Your 20% commission this week is " + commission + ", congratulations!"); // print output. Ideally, id like to extrapulate this, but would require two functions.
            } else {
                double commission = sales_this_period * lowCommissionRate; //sales was not greater than 5000, but is greater than lowCommissionBarrier. So we get the low commission rate.
                System.out.println("Your 10% commission this week is " + commission + ", congratulations!"); // print output. Ideally, id like to extrapulate this, but would require two functions.
            }
        }
        else { // Sales was not greater than lowCommissionBarrier, so we get no commissions.
            System.out.println("You do not qualify for a commission this week,\ntry again next week!"); // print output. Ideally, id like to extrapulate this, but would require two functions.
        }
    }
}
