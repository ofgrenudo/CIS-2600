package lab4_jmb8687;

import javax.swing.JOptionPane;

/**
 * ## `Package` Class
 * - `Customer Name`: String
 * - `Weight`: double (in ounces)
 * - `Shipping Method`: Struct (A for Air, T for Truck, M for Mail)
 * - `Shipping Cost`: double
 * 
 * Required Constructor* that contains arguments for weight and shipping method.
 * 
 * Required Calculate Cost* method that determines the shipping cost based on 
 * the following information :
 * 
 * | Weight (oz.) | Air ($) | Truck ($) | Mail ($) |
 * | ------------ | ------- | --------- | -------- |
 * | 1 ~ 8        | 2.00    | 1.50      | 0.50     |
 * | 9 ~ 16       | 3.00    | 2.35      | 1.50     |
 * | 17 and over  | 4.00    | 3.25      | 2.15     |
 * 
 * Required Display Method* that shows the customers name, weight and shipping method.
 * 
 * @author jwintersbro
 */
public class Package {
    
    // Create a enum of shipping methods
    public enum ShippingMethod {
        AIR, TRUCK, MAIL
    }
    
    // Create a enum of weight classes    
    public enum WeightClass {
        SMALL, MEDIUM, LARGE
    }
    
    // Variables of the class
    private String customer_name;
    private double weight;
    private WeightClass weight_class;
    private ShippingMethod shipping_method;
    private double cost;
    
    /* ======================== Assign Package Costs =========================*/
    // Package weight is between 0 ~ 8.99 OZ.
    private final double SMALL_MAX_WEIGHT = 8.99;
    private final double SMALL_AIR_PACKAGE_COST = 2.00; 
    private final double SMALL_TRUCK_PACKAGE_COST = 1.50; 
    private final double SMALL_MAIL_PACKAGE_COST = 0.50; 

    // Package weight is between 9 ~ 16.99 OZ.    
    private final double MEDIU_MAX_WEIGHT = 16.99;
    private final double MEDIU_AIR_PACKAGE_COST = 2.00; 
    private final double MEDIU_TRUCK_PACKAGE_COST = 1.50; 
    private final double MEDIU_MAIL_PACKAGE_COST = 0.50; 
    
    // Package weight is between 17 ~ inf. OZ.
    private final double LARGE_AIR_PACKAGE_COST = 2.00; 
    private final double LARGE_TRUCK_PACKAGE_COST = 1.50; 
    private final double LARGE_MAIL_PACKAGE_COST = 0.50; 

    public boolean INSURED = false; // default package has no insurance

    /* ============================ Constructors =============================*/    
    public Package () { ; } // do nothing
    
    // Assign our package weight and shipping method
    public Package (double weight, ShippingMethod shipping_method) { 
        setWeight(weight);
        setShippingMethod(shipping_method);
    }
    
    
    /* =========================== Getter Setters ============================*/    
    public void setCustomerName(String customer_name) { this.customer_name = customer_name; }
    public void setWeight(double weight) { this.weight = weight; setWeightClass(weight); }
    public void setShippingMethod(ShippingMethod shipping_method) { this.shipping_method = shipping_method; }
    public void setCost(double cost) { this.cost = cost; }

    public String getCustomerName() { return customer_name; }
    public double getWeight() { return weight; }
    public WeightClass getWeightClass() { return weight_class;}
    public ShippingMethod getShippingMethod() { return shipping_method; }
    public double getCost() { return cost; }
    
    /* ============================== Helpers ================================*/
    private void setWeightClass(double weight) {
        // If weight is greater than the medium weight max, then it is large.
        if (weight > MEDIU_MAX_WEIGHT) { 
            weight_class = WeightClass.LARGE;
        } 
        // If weight is less than medium weight max, it is either medium or small.
        else { 
            // if weight is greater than small max weight, then it is medium.
            if (weight > SMALL_MAX_WEIGHT) {
                weight_class = WeightClass.MEDIUM;
            }
            // If weight is not greater than small max weight then it is small.
            else {
                weight_class = WeightClass.SMALL;
            }
        }
    }
    
    public void calculateCost() {
        // if package weight class is small
        if (weight_class == WeightClass.SMALL) {
            // check shipping methods
            switch (shipping_method){
                // apply air package cost
                case ShippingMethod.AIR:
                    cost = SMALL_AIR_PACKAGE_COST;
                    break;
                // apply truck package cost
                case ShippingMethod.TRUCK:
                    cost = SMALL_TRUCK_PACKAGE_COST;
                    break;
                // apply mail package cost
                case ShippingMethod.MAIL:
                    cost = SMALL_MAIL_PACKAGE_COST;
                    break;
            }                    
        } 
        // if package weight class is medium
        else if (weight_class == WeightClass.MEDIUM) {
            // check shipping method
            switch (shipping_method){
                // apply air package cost
                case ShippingMethod.AIR:
                    cost = MEDIU_AIR_PACKAGE_COST;
                    break;
                // apply truck package cost
                case ShippingMethod.TRUCK:
                    cost = MEDIU_TRUCK_PACKAGE_COST;
                    break;
                // apply mail package cost
                case ShippingMethod.MAIL:
                    cost = MEDIU_MAIL_PACKAGE_COST;
                    break;
            }
        } 
        // if package weight class is large
        else if (weight_class == WeightClass.LARGE) {
            // check shipping method
            switch (shipping_method){
                // apply air package cost.
                case ShippingMethod.AIR:
                    cost = LARGE_AIR_PACKAGE_COST;
                    break;
                // apply truck package cost.
                case ShippingMethod.TRUCK:
                    cost = LARGE_TRUCK_PACKAGE_COST;
                    break;
                // apply mail shipping cost.
                case ShippingMethod.MAIL:
                    cost = LARGE_MAIL_PACKAGE_COST;
                    break;
            }
        }
    }
    
    // print out reciept
    public void display() {
        calculateCost(); // confirm cost is calculated before printing
        // generate reciept
        String message = "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n" +
        "\t\tU-SHIP\n" +
        "\nReciept for -> " + getCustomerName() + "\n" +
        "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n\n" +
        "Package Weight\t-> " + getWeight() + " (oz)\n" +
        "Package Insured\t-> " + INSURED + "\n" +
        "Shipping Method\t-> " + getShippingMethod() + "\n" +
        "Shipping Cost\t-> " + getCost() + "\n" +
        "\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%";

        // print reciept to console just in case
        System.out.println(message);
        // display reciept to joption pane as required.
        JOptionPane.showMessageDialog(null, message);
    }
    
    /* ============================== Tester  ================================*/
    // for testing packages
    public void testWeightClass(){
        Package testSmallPackage = new Package(5.0, ShippingMethod.AIR);
        Package testMediuPackage = new Package(15.0, ShippingMethod.AIR);
        Package testLargePackage = new Package(20.0, ShippingMethod.AIR);
    
        System.out.println("Input Weight : " + testSmallPackage.getWeight() + "  | Should be SMALL class.  | Reports as : " + testSmallPackage.getWeightClass());
        System.out.println("Input Weight : " + testMediuPackage.getWeight() + " | Should be MEDIUM class. | Reports as : " + testMediuPackage.getWeightClass());
        System.out.println("Input Weight : " + testLargePackage.getWeight() + " | Should be LARGE class.  | Reports as : " + testLargePackage.getWeightClass());
   }

}
