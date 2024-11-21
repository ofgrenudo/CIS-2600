public class dog {
    private String name;
    private int age;
    
    public String getName(){ return name; }
    public int getAge() { return age; }
    
    public int setName(String inputName) {
        name = inputName;
        return 1;
    }
    
    public int setAge(int inputAge) {
        age = inputAge;
        return 1;
    }
    
    public void bark(){ System.out.println("Woof Woof!"); }
}
