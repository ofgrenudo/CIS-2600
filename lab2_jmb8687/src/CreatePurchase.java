/*******************************************************************************
* Programmer: Joshua Winters-Brown
* ClassID: jmb8687
* CIS 2600: Business Application Programming
* Fall 2024
* Due date: 10/27/24
* Date completed: 10/27/24
********************************************************************************
* Program Explanation
* This object, manages the creation of purchase, as well as validates the objects
* information was correctly input.
*******************************************************************************/

import java.util.Scanner;

public class CreatePurchase {
    // nothing to initialize. No values are really stored in this class, you only use this class to run the purchase loop.
    // Yo would need this class though if you wanted to store multiple invoices. This class probably could have a better name like invoice.
    public void CreatePurchase() {
    }
    
    // main run loop, this will run until user decides they are done.
    // This was done here to simplify the reading of code. It could have been done in the main loop, but otherwise im not sure what this class would do 
    // other than get input from the user? We could have put that in purchase.java.
    public void run() {
        boolean running = true; // set my running variable
        Scanner myScanner = new Scanner(System.in); // create a scanner for user input
        
        while(running) {
            giveMeSpace(); // get space, healper function
            System.out.println("Welcome to The Store"); // print
            System.out.println("Please enter the product id of item you would like to purchase!"); // provide select items.
            System.out.println(" 1 > Orange"); // orange
            System.out.println(" 2 > Rope"); // rope
            System.out.println(" 3 > Boots"); // boots
            System.out.println(" 4 > Toothpaste"); // toothpaste
            System.out.println(" 5 > Car"); // car
            System.out.println(""); // I really thought about making these options strange but decided to not.
            System.out.println(" 9 > Exit"); // Are you done? Ready  to leave? Maybe?

            System.out.print("store> "); // print input.
            int operationInput = myScanner.nextInt(); // get next int.
            
            // switch statement because it would be to many ifs.
            switch (operationInput) {
                case 0 -> { test(); } // secret option not displayed!!! 
                case 1 -> { newPurchase("Orange"); } // call function, provide name of item.
                case 2 -> { newPurchase("Rope"); } // call function, provide name of item.
                case 3 -> { newPurchase("Boots"); } // call function, provide name of item.
                case 4 -> { newPurchase("Toothpaste"); } // call function, provide name of item.
                case 5 -> { newPurchase("Car"); } // call function, provide name of item.
                case 9 -> { // you want to leave!?
                    giveMeSpace(); // I think i need space
                    running = false; // terminate lop.
                }
            }
            
            // run again, if you finished pruchasing the object and you didnt decide to leave me.
        }}
    
    // helpder functio that manages object pruchases
    private void newPurchase(String name) { // takes name to define in loop.
        boolean running = true; // create var to control loop.
        while(running) { // run loop while running is true
            Scanner myScanner = new Scanner(System.in); // create scanner object
            Purchase newOrder = new Purchase(); // Create new purchase.
            System.out.println("Product Name > " + name); // print out defined name.

            System.out.print("Product Sale Price > "); // Print Price input
            double saleAmmount = myScanner.nextDouble(); // get Price Input

            System.out.print("Product Invoice Number > "); // Print invoice input
            int invoiceNumber = myScanner.nextInt(); // get invoice input

            // Notice, I dont check the above values live, I wait until i get all values then check them and provide you feedback.
            
            boolean nameUpdateSuccess = newOrder.setName(name); // sets name, will return error if you did something wrong.
            boolean saleAmmountUpdateSuccess = newOrder.setAmmountOfSale(saleAmmount); // sets ammount of sale, will return error if you did something wrong
            boolean invoiceNumberUpdateSuccess = newOrder.setInvoiceNumber(invoiceNumber); // sets invoice number, will return error if you did something wrong
            
            // Check everything returned true!
            if(nameUpdateSuccess == true && saleAmmountUpdateSuccess == true && invoiceNumberUpdateSuccess == true) { 
                giveMeSpace(); // were breaking up. I need space >;(.
                
                // This is where I should store the object for later if the user wants to buy something else.
                
                newOrder.printReciept(); // print the reciept.
                
                pauseForEnter(); // pause for user to acknowledge recietp
                
                running = false; // exit loop.
            }
        }
    }
    
    // Helper Functions Below!
    
    // wiat for user to acknowledge something.
    private void pauseForEnter(){
        Scanner myScanner = new Scanner(System.in); // get system input
        System.out.print("\nPress Enter to continue"); // print polite message demanding input
        String wait = myScanner.nextLine(); // wait for demanded input.
//        wait = myScanner.nextLine();
    }
    
    // give me space >;(
    private void giveMeSpace() {
        System.out.println("\n\n\n\n\n\n\n\n"); // nnnnnnnnn
    }
    
    // Tests
    // helped me test the reciept and other functions!
    private void test() {
        System.out.println(""); // give me space
        
        testSetInvoiceNumber(); // test invoice number
        
        System.out.println(""); // give me space
        
        testPrintReciept(); // test printing reciept.

        pauseForEnter(); // pause for acknowledge ment
    }
    
    // test invoice number.
    private void testSetInvoiceNumber() {
        Purchase testOrder = new Purchase(); // get new purchase object
        testOrder.testSetInvoiceNumber(); // set invoice number
    }
    
    // test reciept function
    private void testPrintReciept() {
        Purchase testOrder = new Purchase(); // get new purchase object
        testOrder.printReciept(); // test printing a blank reciept.
    }
}
