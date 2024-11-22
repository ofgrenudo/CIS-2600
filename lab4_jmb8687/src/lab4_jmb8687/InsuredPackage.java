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

    private double insured_package_cost;

    /* ============================ Constructors =============================*/    
    public InsuredPackage () { ; }
    
    public InsuredPackage (double weight, ShippingMethod shipping_method) { 
        super.setWeight(weight);
        super.setShippingMethod(shipping_method);
    }
    
    /* ============================== Helpers ================================*/
    @Override
    public void calculateCost() {
        super.calculateCost();
        double current_cost = super.getCost();
        
        if (current_cost > 3.01) {
            super.setCost(current_cost + 5.55);
        } else if (current_cost > 1.01) {
            super.setCost(current_cost + 3.95);
        } else {
            super.setCost(current_cost + 2.45);
        }
    }
}
