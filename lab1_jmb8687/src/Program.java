/*******************************************************************************
* Programmer: Joshua Winters-Brown
* ClassID: jmb8687
* Task 01: Gather input from user for:
*   - Name of Job.
*   - Cost of Material.
*   - Number of hours needed.
*   - Number of hours travel.
* 
* Task 02: Make sure to use the parameters and calculation formula noted in the 
* exercise to compute the final costs.
* 
* For instance, if the cost of material is $100, and the hours needed to 
*   complete the work is 4 hours, then the final cost would be the cost of material
*   ($100) plus $35 multiplied by the number of hours of work (4) required to 
*   complete the work, plus $12 multiplied by number of hours travel time (let's 
*   say 2 hours of travel time), then the estimated final cost of the job would be
*   100 + 35 * 4 + 12 * 2 = $264.00
* 
* Task 03: Place a company name (you make up the company) formatted at the top 
* with ASCII design as you deem appropriate (Text blocks feature of Java).
* Detailed invoice for the work. For example, include pertinent items used to 
* calculate the cost.
*   -   The name of the job
*   -   The cost of the material
*   -   The hours worked and the total costs
*   -   The hours traveled and the total costs
* 
* Format the bottom of the output with ASCII as you deem appropriate. 
* 
* Challenge Parameters:
* For those who want to create a more robust application, consider the following 
* in this order [Must complete 1 before attempting 2]:
*   [Moderate Challenge]: 
*       Calculate the price for more than one item (hourly rate remains the same).
*       Make sure to output each item in the invoice.
*   [Difficult Challenge]: 
*       Create a Job class that contains the information and instantiate object(s)
*       from it to meet all lab parameters. Consider making a separate class file 
*       for this.
* 
* CIS 2600: Business Application Programming
* Fall 2024
* Due date: 10/04/24
* Date completed: 
********************************************************************************
* Program Explanation
* 
* The point of this program is to calculate the cost of a a repair owner to. It 
* then will provide a reciept to the user of the program explaining the billing
* and reason for costs incured.
*******************************************************************************/

// Import the Scanner class to allow for us to get input from the user
import java.util.Scanner; 

// Create main class name program.
public class Program {

    static Scanner  reader = new Scanner(System.in); //I Initialize and create a new scanner called reader.
    static String jobName;          // The name of the job
    static double jobMaterialCost;          // The cost of the material
    static double jobHours;         // The hours worked and the total costs
    static double jobTravelTime;    // The hours traveled and the total costs
    
    // Constants
    static final String companyName = "Joshua Build"; // Create constant of company name.
    static final double hourlyCost = 35.00;         // Define constant of hourly cost.
    static final double travelHourlyCost = 12.00;   // Define constant of travel hourly cost.
    
    // Create main function that accepts command line argument.
    public static void main(String[] args) {
        
        // Task One
        /* Gather the following information:
        *    Name of the Job (i.e., Kitchen Remodel)
        *    Cost of Materials
        *    Number of hours needed
        *    Number of hours travel time
        */
        
        System.out.println("**************************************************************"); // print beautifying mark.
        System.out.print("** Please enter the name of the job  : "); // print string requesting name.
        jobName = reader.nextLine(); // read next line as string stored under name.

        System.out.print("** Please enter the cost of the materials (double) : "); // print string requesting cost of materials value.
        jobMaterialCost = reader.nextDouble(); // read next line as a double.
        
        System.out.print("** Please enter the number of hours needed (double) : "); // print string requesting the number of hours needed.
        jobHours = reader.nextDouble(); // read next line as a double.
        
        System.out.print("** Please enter the number of hours of travel (double) : "); // print string requesting the number of hours traveled.
        jobTravelTime = reader.nextDouble(); // read next line as a double.
        
         System.out.println("**************************************************************"); // print beautifying mark.

        /* Task 03: Place a company name (you make up the company) formatted at the top 
        * with ASCII design as you deem appropriate (Text blocks feature of Java).
        * Detailed invoice for the work. For example, include pertinent items used to 
        * calculate the cost.
        *   -   The name of the job
        *   -   The cost of the material
        *   -   The hours worked and the total costs
        *   -   The hours traveled and the total costs
        */
        
        System.out.println("\n\n$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$"); // print beautifying mark.
        System.out.println("$$ " + companyName + " Reciept for " + jobName); // print company name and jobname.
        System.out.println("$$ Material Cost: " + jobMaterialCost); // print material cost.
        System.out.println("$$ Total Hours on Job: Flat Rate of " + hourlyCost + " * " + jobHours); // print cost method.
        System.out.println("$$ Total Hours Traveled: Flat Rate of " + travelHourlyCost + " * " + jobTravelTime); // print travel method
        System.out.println("$$ "); // print spacer
        System.out.println("$$ Total Cost of Job : " + calculatedCost(jobMaterialCost, jobHours, jobTravelTime)); // print the total cost of the job.
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$"); // print beautifying mark.
    }
    
    /* Task 02: Make sure to use the parameters and calculation formula noted in the 
    * exercise to compute the final costs.
    * 
    * For instance, if the cost of material is $100, and the hours needed to 
    *   complete the work is 4 hours, then the final cost would be the cost of material
    *   ($100) plus $35 multiplied by the number of hours of work (4) required to 
    *   complete the work, plus $12 multiplied by number of hours travel time (let's 
    *   say 2 hours of travel time), then the estimated final cost of the job would be
    *   100 + 35 * 4 + 12 * 2 = $264.00
    */
    
    //create a variable that returns a double called calculatedCost that takes materialCost hoursNeeded hoursOfTravel as parameters.
    static double calculatedCost(double materialCost, double hoursNeeded, double hoursOfTravel ){
        double calculatedHours = hourlyCost * hoursNeeded; //create a variable called calculated hours that is hourlycost times hours needed.
        double calculatedTravelHours = travelHourlyCost * hoursOfTravel; // create a variable called calculatedtravel hours that is travel hourly cost and hours of travel.
        
        double calculatedCost = materialCost + calculatedHours + calculatedTravelHours; // calculate the final cost that we need.
        return calculatedCost; // return our final calculated variable.
    }
}
