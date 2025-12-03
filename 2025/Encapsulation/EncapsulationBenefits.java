/**
 * Tutorial: Benefits of Encapsulation
 * Demonstrates why encapsulation is important
 */
public class EncapsulationBenefits {
    // Without encapsulation (bad practice)
    public int badAge;  // Can be modified directly
    
    // With encapsulation (good practice)
    private int goodAge;
    
    public void setGoodAge(int age) {
        if (age > 0 && age < 150) {
            this.goodAge = age;
        } else {
            System.out.println("Invalid age");
        }
    }
    
    public int getGoodAge() {
        return goodAge;
    }
    
    // Encapsulation allows:
    // 1. Data validation
    // 2. Read-only or write-only properties
    // 3. Changing internal implementation without affecting users
    // 4. Better control over data access
    
    private String internalData = "Original";
    
    // Read-only property
    public String getInternalData() {
        return internalData;
    }
    
    // Can change implementation without breaking code
    public void setInternalData(String data) {
        // Can add logging, validation, etc.
        this.internalData = data.toUpperCase();  // Example: auto-uppercase
    }
    
    public static void main(String[] args) {
        EncapsulationBenefits obj = new EncapsulationBenefits();
        
        // Bad: Direct access
        obj.badAge = -5;  // No validation
        System.out.println("Bad age: " + obj.badAge);
        
        // Good: Controlled access
        obj.setGoodAge(25);
        System.out.println("Good age: " + obj.getGoodAge());
        obj.setGoodAge(-5);  // Rejected
        
        obj.setInternalData("hello");
        System.out.println("Internal data: " + obj.getInternalData());
    }
}


















