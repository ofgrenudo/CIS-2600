/*******************************************************************************
* Programmer: Joshua Winters-Brown
* ClassID: jmb8687
* CIS 2600: Business Application Programming
* Fall 2024
* Due date: 10/27/24
* Date completed: 10/27/24
********************************************************************************
* Program Explanation
* This function will allow for you to calculate the cost and taxes of an object 
* sold as well as to print out a reciept for you or your client.
*******************************************************************************/

public class Purchase {
    
    private String name; // name of object.
    private int invoiceNumber; // invoice number
    private double ammountOfSale; // how much the object costs after tax
    private double ammountOfSalePreTax; // how much the object costs with tax.
    
    private final double SALES_TAX = 0.06; // tax ammount defined by instructor
    private final int INVOICE_RANGE_MIN = 1000; // invoice range minimum!
    private final int INVOICE_RANGE_MAX = 8000; // invoice range maximum!
    
    public String getName() { return name; } // return name variable
    public int getInvoiceNumber() { return invoiceNumber; } // return invoice number
    public double getAmmountOfSale() { return ammountOfSale; } // return amount of sale.
    public double getSalesTax() { return SALES_TAX; } // return sales tax.
    
    public boolean setName(String input) { name = input; return true; } // set name. return true to signify we succeeded at this.
    public boolean setInvoiceNumber(int input) {  // set invoice number
        if (input > INVOICE_RANGE_MIN && input < INVOICE_RANGE_MAX) { // check the invoice number is within the range limits.
            invoiceNumber = input; // assign the invoice number.
            return true;   // return true to signify the operation was successfull.
        } else { // if the invoice number is not in the range, return false so that we can try again.
            System.out.println("\tERROR > Please input a number within the range of " + INVOICE_RANGE_MIN + " and " + INVOICE_RANGE_MAX); // provde a descriptive error.
            return false; // return false.
        }
    }
    public boolean setAmmountOfSale(double input) { // 
        if (input > 0) { // check we have a valid price. We are a buisness not a charity.
            ammountOfSalePreTax = input; // assign pre tax value
            ammountOfSale = input + calculatedSalesTax(input); // calculate our post tax value.
            return true; // return true to indicate the operation succeded
        } else {
            System.out.println("\tERROR > Please input a number greater than 0."); // return descriptive error.
            return false; // return false, to indicate the operation failed
        }
    } 
    public boolean setSalesTax(double input) { return false; } // operation not permitted as instructor defined static falue. Return false.
    public double getAmountOfSalePreTax() { // return pre tax value
        return ammountOfSalePreTax;
    }
    
    // print the reciept reliably, every time, the same way.
    public void printReciept(){
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%"); // header
        System.out.println("|Joshuas General Store"); // store name
        System.out.println("|171 Lake Washington Blvd E, Seattle, Washington, U.S."); // Kurt Kobains house otherwise known as my buisness address.
        System.out.println("|"); // spacer
        System.out.println("|Invoice Number: \t\t\t" + getInvoiceNumber()); // tried to do right aligned stuff
        System.out.println("|Item Name: \t\t\t\t" + getName()); // tried to do right aligned stuff
        System.out.println("|Pre Tax Price: \t\t\t" + getAmountOfSalePreTax()); // tried to do right aligned stuff
        System.out.println("|Sales Tax: \t\t\t\t" + getSalesTax()); // tried to do right aligned stuff
        System.out.println("|"); // spacer
        System.out.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\tSale Price"); // Sale Price header
        System.out.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\t" + getAmmountOfSale()); // return amount charged to client
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%"); // footer
    }
    
    // Helper Functions
    private double calculatedSalesTax(double sale){ return sale * SALES_TAX; } // do the math for the sales tax.
    
    // Tests to make sure the bounds are working.
    public void testSetInvoiceNumber(){
        boolean case_one = setInvoiceNumber(999); // should return false
        boolean case_two = setInvoiceNumber(8001); // should return false
        boolean case_three = setInvoiceNumber(1207); // should return true
        
        System.out.println(""); // space
        if (!case_one) { System.out.println("Invoice Number Lower Bound Check Passed"); } else { System.out.println("Invoice Number Lower Bound Check Passed"); } // check and provdide output for user running tests.
        if (!case_two) { System.out.println("Invoice Number Upper Bound Check Passed"); } else { System.out.println("Invoice Number Upper Bound Check Passed"); } // check and provdide output for user running tests.
        if (case_three) { System.out.println("Invoice Number In-Range Bound Check Passed"); } else { System.out.println("Invoice Number In-Range Bound Check Failed"); } // check and provdide output for user running tests.
    }
}
