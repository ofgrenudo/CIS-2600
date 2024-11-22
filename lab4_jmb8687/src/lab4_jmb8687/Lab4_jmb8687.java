package lab4_jmb8687;

public class Lab4_jmb8687 {

    public static void main(String[] args) {
        testInsurance();
    }    

    public static void testInsurance() {
        Package testPackage = new Package(0.6, Package.ShippingMethod.AIR);
        InsuredPackage testInsPackage = new InsuredPackage(0.6, Package.ShippingMethod.AIR);
        
        testInsPackage.calculateCost();
        testPackage.calculateCost();   
        
        testInsPackage.display();
    }
}
