package lab4_jmb8687;

public class Lab4_jmb8687 {

    public static void main(String[] args) {
        Package testPackage = new Package(5.0, Package.ShippingMethod.AIR);
        
        // TODO THis is buggy, does not give the right cost? not sure what im doing wrong
        testPackage.calculateCost();        
    }
    
}
