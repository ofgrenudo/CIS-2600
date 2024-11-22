package lab4_jmb8687;

import javax.swing.JOptionPane;

public class UsePackage {
    
    public static void getPackageInformation() {
        boolean running = true;
        while(running) {
            String input_customer_name;
            
            String input_shipping_method;
            Package.ShippingMethod package_shipping_method = Package.ShippingMethod.AIR;
            
            String input_weight;
            double package_weight;
            
            Package user_package;
            
            
            input_customer_name     = JOptionPane.showInputDialog("Please Enter the Customers Name");
            input_weight            = JOptionPane.showInputDialog("Please Enter the Package Weight");
            input_shipping_method   = JOptionPane.showInputDialog("Please Enter Shipping Method\n\n(A)ir, (T)ruck, (M)ail");
            
            package_weight = Double.parseDouble(input_weight);
            if(input_shipping_method.equals("A")) { package_shipping_method = Package.ShippingMethod.AIR; }
            if(input_shipping_method.equals("T")) { package_shipping_method = Package.ShippingMethod.TRUCK; }            
            if(input_shipping_method.equals("M")) { package_shipping_method = Package.ShippingMethod.MAIL; }      
            
            
            // Display a Yes/No dialog
            int response = JOptionPane.showConfirmDialog(
                    null,
                    "Do you want to pay for Insurance?",
                    "Insurance Status",
                    JOptionPane.YES_NO_OPTION);

            // Check the user's response
            if (response == JOptionPane.YES_OPTION) {
                user_package = new InsuredPackage(package_weight, package_shipping_method);
                user_package.setCustomerName(input_customer_name);
                user_package.display();
            } else if (response == JOptionPane.NO_OPTION) {
                user_package = new Package(package_weight, package_shipping_method);
                user_package.setCustomerName(input_customer_name);
                user_package.display();
            } else {
                JOptionPane.showMessageDialog(null, "You canceled the dialog.");
            }
            
            running = false;
        }
    }
    
}
