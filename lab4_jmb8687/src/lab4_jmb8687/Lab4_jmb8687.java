package lab4_jmb8687;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Lab4_jmb8687 {
    private static void createAndShowGUI() {
        // Create the main application window (JFrame)
        JFrame frame = new JFrame("Swing Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add a label to the frame
        JLabel label = new JLabel("Hello, Swing!");
        frame.getContentPane().add(label);

        // Set the frame size and make it visible
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Schedule a job for the event-dispatching thread
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}


//public class Lab4_jmb8687 {
//
//    public static void main(String[] args) {
//        testInsurance();
//    }    
//
//    public static void testInsurance() {
//        Package testPackage = new Package(0.6, Package.ShippingMethod.AIR);
//        InsuredPackage testInsPackage = new InsuredPackage(0.6, Package.ShippingMethod.AIR);
//        
//        testInsPackage.calculateCost();
//        testPackage.calculateCost();   
//        
//        System.out.println("Non Insured Price\t: " + testPackage.getCost());
//        System.out.println("Insured Price\t\t: " + testInsPackage.getCost());
//    }
//}
