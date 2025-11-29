/**
 * Tutorial: This Keyword
 * Demonstrates usage of 'this' keyword
 */
public class ThisKeyword {
    private String name;
    private int age;
    
    // Using 'this' to refer to instance variables
    public ThisKeyword(String name, int age) {
        this.name = name;  // this.name refers to instance variable
        this.age = age;    // this.age refers to instance variable
    }
    
    // Using 'this' to call another constructor
    public ThisKeyword(String name) {
        this(name, 0);  // Calls the constructor above
    }
    
    // Using 'this' to return current object
    public ThisKeyword setName(String name) {
        this.name = name;
        return this;  // Enables method chaining
    }
    
    public ThisKeyword setAge(int age) {
        this.age = age;
        return this;
    }
    
    // Using 'this' to pass current object
    public void display() {
        printInfo(this);
    }
    
    private void printInfo(ThisKeyword obj) {
        System.out.println("Name: " + obj.name + ", Age: " + obj.age);
    }
    
    public static void main(String[] args) {
        ThisKeyword obj = new ThisKeyword("Alice", 25);
        obj.display();
        
        // Method chaining using 'this'
        obj.setName("Bob").setAge(30).display();
    }
}


















