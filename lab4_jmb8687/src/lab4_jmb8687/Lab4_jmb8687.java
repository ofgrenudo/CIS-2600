package lab4_jmb8687;

public class Lab4_jmb8687 {

    public static void main(String[] args) {
        UsePackage.getPackageInformation(); // run buisness loop
    }    

    // test insurance function.
    public static void testInsurance() {
        // Craete new test package without insurance
        Package testPackage = new Package(0.6, Package.ShippingMethod.AIR); 
        
        // Create new test package with insurance
        InsuredPackage testInsPackage = new InsuredPackage(0.6, Package.ShippingMethod.AIR);
        
        // Display Test Package with insurance
        testPackage.display();
        
        // Display test package without insurance
        testInsPackage.display();
    }
}
