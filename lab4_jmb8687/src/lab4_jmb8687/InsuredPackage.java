/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4_jmb8687;

/**
 * ## `InsuredPackage` Class
 * 
 * Extends Package Class. adds a **Insurance Cost** based on the following table.
 * 
 * | Shipping Cost Before Insurance ($) | Additional Cost ($) |
 * | ---------------------------------- | ------------------- |
 * | 0 ~ 1.00                           | 2.45                |
 * | 1.01 ~ 3.00                        | 3.95                |
 * | 3.01 and over                      | 5.55                |
 * 
*/
public class InsuredPackage extends Package {


    /* ============================ Constructors =============================*/    
    // set the insured flag in the parent class!
    public InsuredPackage () { super.INSURED = true; }
    
    // Create our insured constructor.
    public InsuredPackage (double weight, ShippingMethod shipping_method) { 
        // set weight
        super.setWeight(weight);
        // set shipping method
        super.setShippingMethod(shipping_method);
        // set insured flag
        super.INSURED = true;
    }
    
    /* ============================== Helpers ================================*/
    /**
     * Here we are going to override the calculateCost function to include the 
     * insurance costs that we have predefined in the lab.
     */
    @Override
    public void calculateCost() {
        // run the parent function calculate cost.
        super.calculateCost();
        // get the calculated cost from the parent class.
        double current_cost = super.getCost();
        
        // Add insurance cost accordingly.
        if (current_cost > 3.01) {
            super.setCost(current_cost + 5.55);
        } else if (current_cost > 1.01) {
            super.setCost(current_cost + 3.95);
        } else {
            super.setCost(current_cost + 2.45);
        }
    }
}
