package in_class_objectexercise;

public class In_class_ObjectExercise {
    
    public static void main() {
        double money[] = {20, 10, 20, 30, 50, 60, 70, 80, 190};

        search(money, 70);
    }

    static void search(double[] index, double searchItem){
        for (double item : index) {
            if (item == searchItem) {
                System.out.println("Found " + item);
            }
        }
    }

}
